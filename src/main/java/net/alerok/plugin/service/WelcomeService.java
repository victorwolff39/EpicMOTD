package net.alerok.plugin.service;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import com.hypixel.hytale.server.core.util.NotificationUtil;
import net.alerok.plugin.config.EpicMOTDConfig;

public class WelcomeService {

    private final EpicMOTDConfig config;
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public WelcomeService(EpicMOTDConfig config) {
        this.config = config;
    }

    public void sendWelcomeMessage(final PlayerRef playerRef) {

        if (playerRef != null)
            playerRef.sendMessage(Message.raw(config.getTitle()));
    }

    public void showWelcomeTitle(final PlayerRef playerRef) {

        EventTitleUtil.showEventTitleToPlayer(
                playerRef,
                Message.raw(config.getTitle()),
                Message.raw(config.getSubtitle()),
                true //ou false
        );
    }

    public void showWelcomeToast(final PlayerRef playerRef) {
        NotificationUtil.sendNotification(
                playerRef.getPacketHandler(),
                Message.raw(config.getTitle()).bold(true),
                Message.raw(config.getSubtitle()),
                "motd",                    // id/categoria (pode ser qualquer string)
                NotificationStyle.Default  // Default / Danger / Warning / Success
        );
    }

}
