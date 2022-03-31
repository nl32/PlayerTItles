package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import eu.pb4.placeholders.TextParser;
import io.github.nl32.playertitles.PlayerTitles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
public class setSelfTitle implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        PlayerEntity player = context.getSource().getPlayer();
        String title = getString(context,"title");
        PlayerTitles.getPlayerManager().setPlayerTitle(player,title);
        context.getSource().sendFeedback(TextParser.parse("Title of " + player.getName().asString() + "has been changed to " +
                PlayerTitles.getTitleManager().getTitleText(title)),false);
        return 0;
    }
}
