package net.alerok.plugin.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class EpicMOTDConfig {

    public static final BuilderCodec<EpicMOTDConfig> CODEC =
            BuilderCodec.builder(EpicMOTDConfig.class, EpicMOTDConfig::new)
                    .append(new KeyedCodec<String>("Title", Codec.STRING),
                            (exConfig, aString, extraInfo) -> exConfig.title = aString,
                            (exConfig, extraInfo) -> exConfig.title)
                    .add()
                    .append(new KeyedCodec<String>("Subtitle", Codec.STRING),
                            (exConfig, aString, extraInfo) -> exConfig.subtitle = aString,
                            (exConfig, extraInfo) -> exConfig.subtitle)
                    .add()
                    .build();

    private String title = "Welcome to EpicMOTD plugin!";
    private String subtitle = "This is the default MOTD! You can change it in the configuration file at \"./net.alerok_EpicMOTD\".";

    public EpicMOTDConfig() {
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
