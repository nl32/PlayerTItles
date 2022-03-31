package io.github.nl32.playertitles.commands;

import com.mojang.brigadier.CommandDispatcher;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static net.minecraft.command.argument.EntityArgumentType.player;

public class registrar implements CommandRegistrationCallback {
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(literal("playertitles").then(
                literal("title")
                        .requires(Permissions.require("playertitles.title")).then(
                                literal("add").then(
                                        argument("name", string()).then(
                                                argument("title", string())
                                                        .executes(new addTitle())))
                        ).then(
                                literal("remove").then(
                                        argument("name", string())
                                                .executes(new removeTitle()))
                        ).then(
                                literal("list")
                                        .executes(new listTitles())
                        )
        ).then(
                literal("player")
                        .requires(Permissions.require("playertitles.player")).then(
                                literal("set").then(
                                        argument("title", string()).then(
                                                argument("name", player())
                                                        .executes(new setPlayerTitle())
                                        ).executes(new setPlayerTitle()))
                        ).then(
                                literal("clear").then(
                                        argument("name", player())
                                                .executes(new removePlayerTitle())
                                ).executes(new removeSelfTitle()))
                        .then(
                                literal("get").then(
                                        argument("name", player()).executes(new getTitle())
                                )
                        )
        ).then(
                literal("reload")
                        .requires(Permissions.require("playertitles.reload"))
                        .executes(new reload())
        ).executes(new titleGuiOpen()));
    }

}
