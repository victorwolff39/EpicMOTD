package net.alerok.plugin.model;

import com.hypixel.hytale.server.core.universe.PlayerRef;
import lombok.Builder;

@Builder
public record TitleModel(
        PlayerRef ref,
        String title,
        String subtitle,
        Boolean epic
) {

}
