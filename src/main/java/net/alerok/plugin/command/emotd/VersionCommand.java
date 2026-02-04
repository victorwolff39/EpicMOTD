package net.alerok.plugin.command.emotd;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractAsyncCommand;
import com.hypixel.hytale.server.core.permissions.HytalePermissions;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.concurrent.CompletableFuture;

public class VersionCommand extends AbstractAsyncCommand {

    private final String version;

    public VersionCommand(final String version) {
        super("version", "Shows the version of the EpicMOTD plugin.");

        this.version = version;

        requirePermission (
                HytalePermissions.fromCommand("admin")
        );
    }

    @NonNullDecl
    @Override
    protected CompletableFuture<Void> executeAsync(@NonNullDecl CommandContext commandContext) {
        commandContext.sendMessage(Message.raw("EpicMOTD plugin version: " + version));

        return CompletableFuture.completedFuture(null);
    }

}
