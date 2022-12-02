package dev._2lstudios.deluxebans.plugins;

import org.bukkit.plugin.java.JavaPlugin;

import dev._2lstudios.deluxebans.commands.ExampleCommand;
import dev._2lstudios.deluxebans.listeners.PlayerJoinListener;
import dev._2lstudios.deluxebans.tasks.ExampleTask;

public class DeluxeBansPlugin extends JavaPlugin {
    
    @Override
    public void onEnable () {
        // Save default config
        this.saveDefaultConfig();

        // Set static instance
        DeluxeBansPlugin.instance = this;

        // Register the example command
        this.getCommand("example").setExecutor(new ExampleCommand());
        
        // Register the example listener
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Register the example task
        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new ExampleTask(), taskRepeatEvery, taskRepeatEvery);
    }

    private static DeluxeBansPlugin instance;

    public static DeluxeBansPlugin getInstance () {
        return DeluxeBansPlugin.instance;
    }
}