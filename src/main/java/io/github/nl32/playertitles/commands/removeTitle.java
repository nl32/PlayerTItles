package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.nl32.playertitles.PlayerTitles;
import io.github.nl32.playertitles.title.TitleManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
public class removeTitle implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        TitleManager titleManager = PlayerTitles.getTitleManager();
        titleManager.removeTitle(getString(context,"name"));
        context.getSource().sendFeedback(Text.of("Title Removed"),false);
        return 0;
    }
}
