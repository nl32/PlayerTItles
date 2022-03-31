package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.nl32.playertitles.PlayerTitles;
import io.github.nl32.playertitles.title.TitleManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;

public class addTitle implements Command<ServerCommandSource> {
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        TitleManager titleManager = PlayerTitles.getTitleManager();
        boolean success = titleManager.registerTitle(getString(context,"name"),getString(context,"title"));
        context.getSource().sendFeedback(Text.of("New title added"),false);
        return 0;
    }
}
