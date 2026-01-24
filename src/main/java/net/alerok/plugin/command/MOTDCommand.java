package net.alerok.plugin.command;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.config.EpicMOTDConfig;
import net.alerok.plugin.service.WelcomeService;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class MOTDCommand extends AbstractPlayerCommand {

    private final WelcomeService welcomeService;

    public MOTDCommand(final Config<EpicMOTDConfig> config) {
        super("emotd", "Sends the Message of the Day again.");
        this.welcomeService = new WelcomeService(config);
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext,
                           @NonNullDecl Store<EntityStore> store,
                           @NonNullDecl Ref<EntityStore> ref,
                           @NonNullDecl PlayerRef playerRef,
                           @NonNullDecl World world
    ) {
        welcomeService.welcomePlayer(playerRef);
    }
}
