package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.nl32.playertitles.PlayerTitles;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class listTitles implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        PlayerTitles.getTitleManager().titles().forEachRemaining((s) -> stringBuilder.append(s+", "));
        context.getSource().sendFeedback(Text.of(stringBuilder.toString()),false);
        return 0;
    }
}
