package net.alerok.plugin.command.emotd;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractAsyncCommand;
import com.hypixel.hytale.server.core.permissions.HytalePermissions;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.config.EpicMOTDConfig;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.concurrent.CompletableFuture;

public class ReloadCommand extends AbstractAsyncCommand {

    private final Config<EpicMOTDConfig> config;

    public ReloadCommand(Config<EpicMOTDConfig> config) {
        super("reload", "Reloads config file.");
        this.config = config;

        requirePermission (
                HytalePermissions.fromCommand("admin")
        );
    }

    @NonNullDecl
    @Override
    protected CompletableFuture<Void> executeAsync(@NonNullDecl CommandContext commandContext) {
        LOGGER.atInfo().log("Reloading plugin config file");

        config.load();
        commandContext.sendMessage(Message.raw("EpicMOTD config reloaded."));

        return CompletableFuture.completedFuture(null);
    }

}
