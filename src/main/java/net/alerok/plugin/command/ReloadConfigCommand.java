package net.alerok.plugin.command;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.config.EpicMOTDConfig;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ReloadConfigCommand extends AbstractPlayerCommand {

    private final Config<EpicMOTDConfig> config;
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public ReloadConfigCommand(Config<EpicMOTDConfig> config) {
        super("emotd-reload", "Reloads config file.");
        this.config = config;
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext,
                           @NonNullDecl Store<EntityStore> store,
                           @NonNullDecl Ref<EntityStore> ref,
                           @NonNullDecl PlayerRef playerRef,
                           @NonNullDecl World world
    ) {

        config.load();
        LOGGER.atInfo().log("Abacaxi: " + config.get().getTitle());
    }
}
