package net.alerok.plugin.service;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.util.EventTitleUtil;
import net.alerok.plugin.model.TitleModel;

public class TitleService {

    public void showTitle(final TitleModel title) {

        EventTitleUtil.showEventTitleToPlayer(
                title.ref(),
                Message.raw(title.title()),
                Message.raw(title.subtitle()),
                title.epic()
        );
    }

}
