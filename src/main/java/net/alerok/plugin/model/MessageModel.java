package net.alerok.plugin.model;

import com.hypixel.hytale.server.core.universe.PlayerRef;
import lombok.Builder;

@Builder
public record MessageModel(
        PlayerRef ref,
        String body
) {

}
