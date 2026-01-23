package net.alerok.plugin.enumeration;

import com.hypixel.hytale.logger.HytaleLogger;

import java.text.MessageFormat;
import java.util.Arrays;

public enum MessageType {

    TOAST,
    TITLE,
    MESSAGE;

    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public static MessageType fromString(final String type) {
        var messageType = MessageType.TITLE;

        try {
            messageType = MessageType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            LOGGER.atWarning().log(
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
