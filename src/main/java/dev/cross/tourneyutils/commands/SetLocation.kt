package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ConfigManager
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SetLocation : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }
            if(args.size <= 0) {
                sender.sendMessage("${ChatColor.RED}Correct usage: /setlocation <name of the location>. (e.g: /setlocation teamone)")
                return true
            }
            ConfigManager.addLocationToConfig(args[0], sender.location)

            sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("You have set your current location to ")}${ChatColor.RED}${UnicodeFormatter.getStringUnicode("${args[0]}")}${ChatColor.GRAY}.")
        }
        return true
    }
}