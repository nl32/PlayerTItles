package io.github.nl32.playertitles.commands;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.github.nl32.playertitles.title.Title;

import java.lang.reflect.Type;

public class TitleSerializer implements JsonSerializer<Title> {
    @Override
    public JsonElement serialize(Title src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
