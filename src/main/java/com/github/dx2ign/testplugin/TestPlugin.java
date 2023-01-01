package com.github.dx2ign.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("플러그인이 활성화 되었습니다.");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
         System.out.println("플러그인이 비활성화 되었습니다.");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equals("test")) {
            sender.sendMessage("Hello, Command!");
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(command.getName().equals("test")) {
            if(args.length == 1) {
                List<String> returns1 = new ArrayList<>();
                returns1.add("a15");
                returns1.add("a23");
                returns1.add("b48");
                returns1.add("b38");
                List<String> returns2 = new ArrayList<>();
                for (String returns : returns1){
                    if(returns.toLowerCase().startsWith(args[0].toLowerCase())){
                        returns2.add(returns);
                    }
                }
                return returns2;
            } else if(args.length == 2) {
                List<String> returns1 = new ArrayList<>();
                returns1.add("a58");
                returns1.add("a63");
                returns1.add("b764");
                returns1.add("b761");
                List<String> returns2 = new ArrayList<>();
                for (String returns : returns1){
                    if(returns.toLowerCase().startsWith(args[1].toLowerCase())){
                        returns2.add(returns);
                    }
                }
                return returns2;
            }else{
                return Arrays.asList("");
            }
        }
        return null;
    }
    @EventHandler
    public void death(PlayerDeathEvent event){
        Player player = event.getEntity();
        event.setDeathMessage(player.getName()+"님께서 사망했습니다.");
    }
    @EventHandler
    public void sneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        for (Player players : Bukkit.getOnlinePlayers()){
            players.sendMessage(player.getName()+"님이 웅크리기를 토글했습니다.");
        }
    }
}
