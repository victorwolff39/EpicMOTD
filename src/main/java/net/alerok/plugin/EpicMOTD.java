package net.alerok.plugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import net.alerok.plugin.command.MOTDCommand;
import net.alerok.plugin.service.WelcomeService;

import javax.annotation.Nonnull;

public class EpicMOTD extends JavaPlugin {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public EpicMOTD(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());
        this.getCommandRegistry().registerCommand(new ExampleCommand(this.getName(), this.getManifest().getVersion().toString()));
        this.getCommandRegistry().registerCommand(new MOTDCommand());

        //Send MOTD to player
        this.getEventRegistry().register(PlayerConnectEvent.class, event -> {
            new WelcomeService().showWelcomeToast(event.getPlayerRef());
        });
    }

}
