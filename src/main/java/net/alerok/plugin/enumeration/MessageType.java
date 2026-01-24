package net.alerok.plugin.enumeration;

import java.text.MessageFormat;
import java.util.Arrays;

import static net.alerok.plugin.EpicMOTD.getPluginLogger;

public enum MessageType {

    TOAST,
    TITLE,
    MESSAGE;

    public static MessageType fromString(final String type) {
        var messageType = MessageType.TITLE;

        try {
            messageType = MessageType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            getPluginLogger().atWarning().log(
                    MessageFormat.format("Invalid message type: [{0}], supported types are: {1}. Fallback type [{2}] applied.",
                            type,
                            Arrays.toString(MessageType.values()),
                            messageType
                    )
            );
        }

        return messageType;
    }

}
