package dev.cross.tourneyutils.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Reply : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(args.size <= 0) {
                sender.sendMessage("${ChatColor.GRAY}You didn't provide a reply.")
                return true
            }
            
        }
        return true
    }
}