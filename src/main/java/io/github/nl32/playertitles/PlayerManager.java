package io.github.nl32.playertitles;

import com.google.common.reflect.TypeToken;
import io.github.nl32.playertitles.title.TitleManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {
    private static final File file = new File(FabricLoader.getInstance().getConfigDirectory().getName()+"/playerTitles.json");
    private TitleManager titleManager = PlayerTitles.getTitleManager();
    private HashMap<UUID,String> playerTitlesMap;
    public PlayerManager() {
        loadPlayers();
        if(playerTitlesMap ==null){
            playerTitlesMap = new HashMap<>();
        }
    }

    public boolean setPlayerTitle(PlayerEntity player, String titleName) {
        if(titleManager.titleExists(titleName)){
            playerTitlesMap.put(player.getUuid(), titleName);
            savePlayers();
            return true;
        }
        return false;
    }
    public void removePlayerTitle(PlayerEntity player){
        playerTitlesMap.remove(player.getUuid());
    }
    public String getPlayerTitle(PlayerEntity player){
        return playerTitlesMap.get(player.getUuid());
    }
    public Text parsedPlayerTitle(PlayerEntity player){
        player.enterCombat();
        String key = playerTitlesMap.get(player.getUuid());
        if(key!=null) {
            return titleManager.getTitleText(key);
        }else{
            return Text.of("");
        }

    }


    public void savePlayers() {
        FileDataHandler.saveData(file, playerTitlesMap, new TypeToken<HashMap<UUID,String>>(){}.getType());
    }
    public void loadPlayers() {
        HashMap<UUID,String> map = FileDataHandler.loadData(file,new TypeToken<HashMap<UUID,String>>(){}.getType());
        if(map != null) playerTitlesMap = map;
    }
}
