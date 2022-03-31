package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import eu.pb4.sgui.api.gui.layered.LayeredGui;
import io.github.nl32.playertitles.PlayerTitles;
import io.github.nl32.playertitles.gui.TitleSelector;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class titleGuiOpen implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        try{
        ServerPlayerEntity player = context.getSource().getPlayer();
        LayeredGui gui = new TitleSelector(player);
        gui.open();
        }catch(Exception e){
            PlayerTitles.LOG.error(e);
        }
        return 0;
    }
}
