package io.github.nl32.playertitles.title;

import com.google.gson.*;
import io.github.nl32.playertitles.FileDataHandler;

import java.lang.reflect.Type;

public class TitleSerializer implements JsonSerializer<Title>, JsonDeserializer<Title>{
    private static final Gson GSON = FileDataHandler.getGSON();
    @Override
    public JsonElement serialize(Title src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getPojo());
    }

    @Override
    public Title deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        TitleData data = context.deserialize(json,TitleData.class);
        return new Title(data.getTitle(),data.getItem());
    }
}
