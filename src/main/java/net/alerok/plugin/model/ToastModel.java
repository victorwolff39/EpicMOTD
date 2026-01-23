package net.alerok.plugin.model;

import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import lombok.Builder;

@Builder
public record ToastModel(
        PlayerRef ref,
        String title,
        String subtitle,
        NotificationStyle notificationStyle
) {

}
