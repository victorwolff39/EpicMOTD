package net.alerok.plugin.service;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import com.hypixel.hytale.server.core.util.NotificationUtil;

public class WelcomeService {

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public void sendWelcomeMessage(final PlayerRef playerRef) {
        LOGGER.atInfo().log("Entity added to the system");

        if (playerRef != null)
            playerRef.sendMessage(Message.raw("Jubileu, vc n sabe nem eu..."));
    }

    public void showWelcomeTitle(final PlayerRef playerRef) {

        EventTitleUtil.showEventTitleToPlayer(
                playerRef,
                Message.raw("Hello World!"),
                Message.raw("Your title server!"),
                true //ou false
        );
    }

    public void showWelcomeToast(final PlayerRef playerRef) {
        NotificationUtil.sendNotification(
                playerRef.getPacketHandler(),
                Message.raw("Welcome!").bold(true),
                Message.raw("Prepare for an epic adventure."),
                "motd",                    // id/categoria (pode ser qualquer string)
                NotificationStyle.Default  // Default / Danger / Warning / Success
        );
    }

}
