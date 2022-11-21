package dev.cross.tourneyutils

import dev.cross.tourneyutils.commands.*
import dev.cross.tourneyutils.commands.List
import dev.cross.tourneyutils.events.ChatMessage
import dev.cross.tourneyutils.events.OnMessage
import dev.cross.tourneyutils.manager.DataStorage
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
        registerCommand(PartyChat(), "party")
        registerCommand(Mute(), "mute")

        registerEvents(ChatMessage())

        config.options().copyDefaults(true)

        config.addDefault("announceTimeInSeconds", 5)
        saveConfig()

        if(config.getInt("announceTimeInSeconds") > 0) {
            DataStorage.setRoundAnnounceTime(config.getInt("announceTimeInSeconds"))
        }
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