package net.alerok.plugin.service;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.config.EpicMOTDConfig;
import net.alerok.plugin.enumeration.MessageType;
import net.alerok.plugin.enumeration.ToastNotificationStyle;
import net.alerok.plugin.model.MessageModel;
import net.alerok.plugin.model.TitleModel;
import net.alerok.plugin.model.ToastModel;

public class WelcomeService {

    private final Config<EpicMOTDConfig> config;

    private final MessageService messageService = new MessageService();
    private final TitleService titleService = new TitleService();
    private final ToastService toastService = new ToastService();

    public WelcomeService(final Config<EpicMOTDConfig> config) {
        this.config = config;
    }

    public void welcomePlayer(final PlayerRef playerRef) {
        var configuration = config.get();
        var messageType = MessageType.fromString(configuration.getMessageType());

        switch (messageType) {
            case TITLE -> showWelcomeTitle(playerRef);
            case TOAST -> showWelcomeToast(playerRef);
            case MESSAGE -> sendWelcomeMessage(playerRef);
        }
    }

    private void sendWelcomeMessage(final PlayerRef playerRef) {
        var configuration = config.get();

        messageService.sendMessage(
                MessageModel.builder()
                        .ref(playerRef)
                        .body(configuration.getTitle())
                        .build()
        );
    }

    private void showWelcomeTitle(final PlayerRef playerRef) {
        var configuration = config.get();

        titleService.showTitle(
                TitleModel.builder()
                        .ref(playerRef)
                        .title(configuration.getTitle())
                        .subtitle(configuration.getSubtitle())
                        .epic(configuration.getEpicTitle())
                        .build()
        );
    }

    private void showWelcomeToast(final PlayerRef playerRef) {
        var configuration = config.get();

        toastService.showToast(
                ToastModel.builder()
                        .ref(playerRef)
                        .title(configuration.getTitle())
                        .subtitle(configuration.getSubtitle())
                        .notificationStyle(
                                ToastNotificationStyle.fromString(configuration.getToastNotificationStyle())
                                        .toNotificationStyle()
                        )
                        .build()
        );
    }

}
