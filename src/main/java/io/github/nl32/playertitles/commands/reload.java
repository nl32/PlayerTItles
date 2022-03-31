package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.nl32.playertitles.PlayerTitles;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class reload implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        PlayerTitles.getTitleManager().loadTitles();
        PlayerTitles.getPlayerManager().loadPlayers();
        context.getSource().sendFeedback(Text.of("Player Titles Reloaded"),false);
        return 0;
    }
}
