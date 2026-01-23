package net.alerok.plugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.command.MOTDCommand;
import net.alerok.plugin.config.EpicMOTDConfig;
import net.alerok.plugin.service.WelcomeService;

import javax.annotation.Nonnull;

public class EpicMOTD extends JavaPlugin {

    private final Config<EpicMOTDConfig> config;
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public EpicMOTD(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.atInfo().log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());

        this.config = this.withConfig("config", EpicMOTDConfig.CODEC);
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());

        saveConfig();

        registerCommands();
        welcomePlayer();
    }

    private void saveConfig() {
        LOGGER.atInfo().log("Saving config file...");
        this.config.save();
        LOGGER.atInfo().log("Configuration file saved!");
    }

    private void welcomePlayer() {
        this.getEventRegistry().register(PlayerConnectEvent.class, event -> {
            new WelcomeService().showWelcomeToast(event.getPlayerRef());
        });
    }

    private void registerCommands() {
        this.getCommandRegistry().registerCommand(new MOTDCommand());
    }

}
