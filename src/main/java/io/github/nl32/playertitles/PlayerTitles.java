package io.github.nl32.playertitles;

import eu.pb4.placeholders.PlaceholderAPI;
import eu.pb4.placeholders.PlaceholderResult;
import io.github.nl32.playertitles.commands.registrar;
import io.github.nl32.playertitles.title.TitleManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.text.Texts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PlayerTitles implements ModInitializer {
    private static TitleManager titleManager;
    private static PlayerManager playerManager;
    public static final Logger LOG= LogManager.getLogger("Player Titles");
    @Override
    public void onInitialize() {
        titleManager = new TitleManager();
        playerManager = new PlayerManager();
        CommandRegistrationCallback.EVENT.register(new registrar());

        PlaceholderAPI.register(new Identifier("playertitles","titleplaceholder"),(context) ->{
            ArrayList<Text> texts = new ArrayList<>();
            texts.add(playerManager.parsedPlayerTitle(context.getPlayer()));
            if(texts.get(0).asString().length()>0)
                texts.add(Text.of(" "));
            return PlaceholderResult.value(Texts.join(texts, Text.of("")));
        }
        );

        LOG.info("Player Titles Initialized");
    }
    public static TitleManager getTitleManager(){
        return titleManager;
    }
    public static PlayerManager getPlayerManager(){
        return playerManager;
    }
}
