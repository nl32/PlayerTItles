package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import eu.pb4.placeholders.TextParser;
import io.github.nl32.playertitles.PlayerTitles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.command.argument.EntityArgumentType.getPlayer;
public class getTitle implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        PlayerEntity player = getPlayer(context,"name");
        context.getSource().sendFeedback(TextParser.parse(player.getName().asString()+"'s title: "+ PlayerTitles.getPlayerManager().parsedPlayerTitle(player)),false);
        return 0;
    }
}
