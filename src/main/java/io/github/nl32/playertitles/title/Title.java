package io.github.nl32.playertitles.title;

import eu.pb4.placeholders.TextParser;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Set;

public class Title {
    String unparsedTitle;
    Item titleItem;
    Set<String> permissions;

    public Title(){
        unparsedTitle = "";
        titleItem = null;
        permissions = new HashSet<>();
    }
    public Title(String titleString){
        unparsedTitle = titleString;
        //Default item for Title's in gui
        setTitleItem(Items.BOOK);
    }
    public Title(String unparsedTitle, String itemID) {
        this.unparsedTitle = unparsedTitle;
        this.titleItem = Registry.ITEM.get(new Identifier(itemID));
    }
    public Title(String titleString, Item item){
        unparsedTitle = titleString;
        setTitleItem(item);
    }
    public Text getParsedTitle(){
        return TextParser.parse(unparsedTitle);
    }
    public void setTitleItem(Item item){
        titleItem = item;
    }
    public String getItemPath(){
        return Registry.ITEM.getId(titleItem).toString();
    }
    public Item getItem(){
        return titleItem;
    }
    protected TitleData getPojo(){
        return new TitleData(unparsedTitle, getItemPath());
    }

}
