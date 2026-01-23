package net.alerok.plugin.service;

import com.hypixel.hytale.server.core.Message;
import net.alerok.plugin.model.MessageModel;

public class MessageService {

    public void sendMessage(final MessageModel message) {
        var playerRef = message.ref();

        if (playerRef != null)
            playerRef.sendMessage(Message.raw(message.body()));
    }

}
