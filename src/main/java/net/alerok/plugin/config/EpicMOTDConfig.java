package net.alerok.plugin.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class EpicMOTDConfig {

    public static final BuilderCodec<EpicMOTDConfig> CODEC =
            BuilderCodec.builder(EpicMOTDConfig.class, EpicMOTDConfig::new)
                    .append(new KeyedCodec<Double>("LuckIncreaseChance", Codec.DOUBLE),
                            (exConfig, aDouble, extraInfo) -> exConfig.LuckIncreaseChance = aDouble,
                            (exConfig, extraInfo) -> exConfig.LuckIncreaseChance)
                    .add()
                    .build();

    private double LuckIncreaseChance = 0.40;

    public EpicMOTDConfig() {
    }

}
