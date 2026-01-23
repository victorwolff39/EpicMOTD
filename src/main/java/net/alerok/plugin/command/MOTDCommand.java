package net.alerok.plugin.command;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class MOTDCommand extends AbstractPlayerCommand {

    public MOTDCommand() {
        super("emotd", "Sends the Message of the Day again.");
    }

    @Override
    protected void execute(@NonNullDecl CommandContext commandContext,
                           @NonNullDecl Store<EntityStore> store,
                           @NonNullDecl Ref<EntityStore> ref,
                           @NonNullDecl PlayerRef playerRef,
                           @NonNullDecl World world
    ) {
        EventTitleUtil.showEventTitleToPlayer(
                playerRef,
                Message.raw("Hello World!"),
                Message.raw("Your title server!"),
                true
        );
    }
}
