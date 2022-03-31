package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.nl32.playertitles.PlayerTitles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.command.argument.EntityArgumentType.getPlayer;

public class removePlayerTitle implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        PlayerEntity player= getPlayer(context,"name");
        PlayerTitles.getPlayerManager().removePlayerTitle(player);
        context.getSource().sendFeedback(Text.of("Removed Player Title"),false);
        return 0;
    }
}
