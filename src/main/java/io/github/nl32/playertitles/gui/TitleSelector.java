package io.github.nl32.playertitles.gui;

import eu.pb4.placeholders.TextParser;
import eu.pb4.sgui.api.elements.GuiElementBuilder;
import eu.pb4.sgui.api.gui.layered.Layer;
import eu.pb4.sgui.api.gui.layered.LayeredGui;
import io.github.nl32.playertitles.PlayerTitles;
import io.github.nl32.playertitles.title.Title;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

import java.util.Collection;

public class TitleSelector extends LayeredGui {
    final Layer background;
    final Layer controller;
    final Layer titles;
    int pageNum;
    public TitleSelector(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X5, player, false);
        this.setTitle(TextParser.parse("Title Selector"));
        pageNum = 1;

        Layer titles = new Layer(3,7);
        this.titles = titles;
        Collection<Title> titleMap = PlayerTitles.getTitleManager().getTitles().values();
        for (Title title : titleMap) {
            if(titles.getFirstEmptySlot()!=-1) {
                titles.setSlot(titles.getFirstEmptySlot(), new GuiElementBuilder(title.getItem()).setName(title.getParsedTitle()));
            }
        }

        this.addLayer(titles,1,1).setZIndex(2);

        Layer controller = new Layer(1,3);
        this.controller=controller;
        controller.setSlot(0,new GuiElementBuilder(Items.ARROW).setName(new LiteralText("previous page")));
        controller.setSlot(1,new GuiElementBuilder(Items.PAPER).setName(new LiteralText("Page "+pageNum)));
        controller.setSlot(2,new GuiElementBuilder(Items.ARROW).setName(new LiteralText("Next Page")));

        this.addLayer(controller,3,4).setZIndex(1);


        Layer background = new Layer(5,9);
        this.background=background;
        GuiElementBuilder builder = new GuiElementBuilder(Items.GRAY_STAINED_GLASS_PANE).setName(LiteralText.EMPTY.copy());
        while(background.getFirstEmptySlot()!=0){
            background.addSlot(builder);
        }
        this.addLayer(background,0,0);
    }
}
