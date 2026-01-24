package net.alerok.plugin.enumeration;

import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;

import java.text.MessageFormat;
import java.util.Arrays;

import static net.alerok.plugin.EpicMOTD.getPluginLogger;

public enum ToastNotificationStyle {

    DEFAULT("Default"),
    SUCCESS("Success"),
    WARNING("Warning"),
    DANGER("Danger");

    private final String value;

    ToastNotificationStyle(String value) {
        this.value = value;
    }

    public NotificationStyle toNotificationStyle() {
        return NotificationStyle.valueOf(this.value);
    }

    public static ToastNotificationStyle fromString(final String type) {
        var notificationStyle = ToastNotificationStyle.DEFAULT;

        try {
            notificationStyle = ToastNotificationStyle.valueOf(type);
        } catch (IllegalArgumentException e) {
            getPluginLogger().atWarning().log(
                    MessageFormat.format("Invalid toast notification style: [{0}], supported types are: {1}. Fallback type [{2}] applied.",
                            type,
                            Arrays.toString(ToastNotificationStyle.values()),
                            notificationStyle
                    )
            );
        }

        return notificationStyle;
    }

}
