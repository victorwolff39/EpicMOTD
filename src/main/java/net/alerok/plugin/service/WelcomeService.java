package net.alerok.plugin.service;

import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import com.hypixel.hytale.server.core.util.NotificationUtil;
import net.alerok.plugin.config.EpicMOTDConfig;
import net.alerok.plugin.model.MessageModel;

public class WelcomeService {

    private final EpicMOTDConfig config;

    private final MessageService messageService = new MessageService();

    public WelcomeService(EpicMOTDConfig config) {
        this.config = config;
    }

    public void sendWelcomeMessage(final PlayerRef playerRef) {
        messageService.sendMessage(MessageModel.builder()
                .ref(playerRef)
                .body(config.getTitle())
                .build()
        );
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
