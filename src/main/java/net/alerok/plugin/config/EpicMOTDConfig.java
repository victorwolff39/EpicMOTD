package net.alerok.plugin.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import lombok.Getter;

@Getter
public class EpicMOTDConfig {

    public static final BuilderCodec<EpicMOTDConfig> CODEC =
            BuilderCodec.builder(EpicMOTDConfig.class, EpicMOTDConfig::new)
                    .append(new KeyedCodec<>("MessageType", Codec.STRING),
                            (exConfig, aString, extraInfo) -> exConfig.messageType = aString,
                            (exConfig, extraInfo) -> exConfig.messageType)
                    .add()

                    .append(new KeyedCodec<>("Title", Codec.STRING),
                            (exConfig, aString, extraInfo) -> exConfig.title = aString,
                            (exConfig, extraInfo) -> exConfig.title)
                    .add()

                    .append(new KeyedCodec<>("Subtitle", Codec.STRING),
                            (exConfig, aString, extraInfo) -> exConfig.subtitle = aString,
                            (exConfig, extraInfo) -> exConfig.subtitle)
                    .add()

                    .append(new KeyedCodec<>("EpicTitle", Codec.BOOLEAN),
                            (exConfig, aBoolean, extraInfo) -> exConfig.epicTitle = aBoolean,
                            (exConfig, extraInfo) -> exConfig.epicTitle)
                    .add()
                    .build();

    private String messageType = "TITLE";
    private String title = "Welcome to EpicMOTD plugin!";
    private String subtitle = "This is the default MOTD! You can change it in the configuration file at \"./net.alerok_EpicMOTD\".";
    private Boolean epicTitle = true;

    public EpicMOTDConfig() {
    }

}
