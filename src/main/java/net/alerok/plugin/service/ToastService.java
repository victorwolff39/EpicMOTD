package net.alerok.plugin.service;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.util.NotificationUtil;
import net.alerok.plugin.model.ToastModel;

public class ToastService {

    public void showToast(final ToastModel toast) {

        NotificationUtil.sendNotification(
                toast.ref().getPacketHandler(),
                Message.raw(toast.title()).bold(true),
                Message.raw(toast.subtitle()),
                "motd",
                toast.notificationStyle()
        );
    }

}
