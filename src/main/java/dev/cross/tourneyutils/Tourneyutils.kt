package dev.cross.tourneyutils

import dev.cross.tourneyutils.commands.*
import dev.cross.tourneyutils.commands.List
import org.bukkit.Bukkit
import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Tourneyutils : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        registerCommand(Add(), "add")
        registerCommand(Remove(), "remove")
        registerCommand(List(), "list")
        registerCommand(Announce(), "announce")
        registerCommand(AllTeleport(), "allteleport")
        registerCommand(Countdown(), "countdown")
        registerCommand(SetLocation(), "setlocation")

        config.options().copyDefaults(true)

        saveConfig()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun registerCommand(commandexecute: CommandExecutor?, nameOfCommand: String?) {
        getCommand(nameOfCommand!!)!!.setExecutor(commandexecute)
    }

    fun registerEvents(e: Listener?) {
        server.pluginManager.registerEvents(e!!, this)
    }
}