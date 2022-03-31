package io.github.nl32.playertitles.title;

import com.google.common.reflect.TypeToken;
import io.github.nl32.playertitles.FileDataHandler;
import io.github.nl32.playertitles.title.Title;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TitleManager {
    private HashMap<String, Title> titleList;
    private transient static final File file = new File(FabricLoader.getInstance().getConfigDirectory().getName()+"/titles.json");

    public TitleManager(){
        loadTitles();
        if(titleList==null){
            titleList = new HashMap<>();
        }
    }

    public boolean registerTitle(String name, String titleString) {
        if(!titleList.containsKey(name)) {
            titleList.put(name, new Title(titleString));
            saveTitles();
            return true;
        }
        return false;
    }
    public boolean removeTitle(String name){
        if(titleList.containsKey(name)){
            titleList.remove(name);
            saveTitles();
            return true;
        }
        return false;
    }

    public boolean titleExists(String name){
        return titleList.containsKey(name);
    }
    public Iterator<String> titles(){
        return titleList.keySet().iterator();
    }
    public Text getTitleText(String key){
        return titleList.get(key).getParsedTitle();
    }


    public void saveTitles() {
       FileDataHandler.saveData(file,titleList,new TypeToken<HashMap<String,Title>>(){}.getType());
    }
    public void loadTitles() {
        HashMap<String,Title> map = FileDataHandler.loadData(file,HashMap.class);
        if(map!=null) titleList = map;
    }
    public Map<String,Title> getTitles(){
        return titleList;
    }
}
