package dev._2lstudios.deluxebans.tasks;

import org.bukkit.Bukkit;

import dev._2lstudios.deluxebans.plugins.DeluxeBansPlugin;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        final String message = DeluxeBansPlugin.getInstance().getConfig().getString("messages.from-task");
        Bukkit.getServer().broadcastMessage(message);
    }
}