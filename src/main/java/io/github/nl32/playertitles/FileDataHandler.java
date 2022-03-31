package io.github.nl32.playertitles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.nl32.playertitles.title.Title;
import io.github.nl32.playertitles.title.TitleSerializer;

import java.io.*;
import java.lang.reflect.Type;

public class FileDataHandler {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .setLenient()
            .registerTypeAdapter(Title.class,new TitleSerializer())
            .create();


    public static void saveData(File file, Object object, Type type) {
        try {
            file.createNewFile();
            Writer writer = new FileWriter(file, false);
            GSON.toJson(object,type,writer);
            writer.flush();
            writer.close();
        } catch (IOException e){
            PlayerTitles.LOG.error(e);
        }
    }
    public static <T> T loadData(File file, Type type){
        try {
            return GSON.fromJson(new FileReader(file),type);
        }catch(FileNotFoundException e){e.printStackTrace(System.out);
            PlayerTitles.LOG.error(e);
        }
        return null;
    }

    public static Gson getGSON() {
        return GSON;
    }
}
