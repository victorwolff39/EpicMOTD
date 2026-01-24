package net.alerok.plugin.command;

import com.hypixel.hytale.server.core.command.system.basecommands.AbstractCommandCollection;
import com.hypixel.hytale.server.core.util.Config;
import net.alerok.plugin.command.emotd.PreviewCommand;
import net.alerok.plugin.command.emotd.ReloadCommand;
import net.alerok.plugin.config.EpicMOTDConfig;

public class EMOTDCommandCollection extends AbstractCommandCollection {

    private final Config<EpicMOTDConfig> config;

    public EMOTDCommandCollection(final Config<EpicMOTDConfig> config) {
        super("emotd", "Controls the EpicMOTD plugin.");
        this.config = config;

        addSubCommand(new ReloadCommand(config));
        addSubCommand(new PreviewCommand(config));
    }
}
