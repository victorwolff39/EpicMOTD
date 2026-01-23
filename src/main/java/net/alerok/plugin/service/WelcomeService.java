package net.alerok.plugin.service;

import com.hypixel.hytale.protocol.packets.interface_.NotificationStyle;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import net.alerok.plugin.config.EpicMOTDConfig;
import net.alerok.plugin.model.MessageModel;
import net.alerok.plugin.model.TitleModel;
import net.alerok.plugin.model.ToastModel;

public class WelcomeService {

    private final EpicMOTDConfig config;

    private final MessageService messageService = new MessageService();
    private final TitleService titleService = new TitleService();
    private final ToastService toastService = new ToastService();

    public WelcomeService(final EpicMOTDConfig config) {
        this.config = config;
    }

    public void welcomePlayer(final PlayerRef playerRef) {
        showWelcomeToast(playerRef);
    }

    public void sendWelcomeMessage(final PlayerRef playerRef) {

        messageService.sendMessage(
                MessageModel.builder()
                        .ref(playerRef)
                        .body(config.getTitle())
                        .build()
        );
    }

    public void showWelcomeTitle(final PlayerRef playerRef) {

        titleService.showTitle(
                TitleModel.builder()
                        .ref(playerRef)
                        .title(config.getTitle())
                        .subtitle(config.getSubtitle())
                        .epic(true)
                        .build()
        );
    }

    public void showWelcomeToast(final PlayerRef playerRef) {

        toastService.showToast(
                ToastModel.builder()
                        .ref(playerRef)
                        .title(config.getTitle())
                        .subtitle(config.getSubtitle())
                        .notificationStyle(NotificationStyle.Default)
                        .build()
        );
    }

}
