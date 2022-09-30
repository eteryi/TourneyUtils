package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.TimeManager
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Countdown : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }
            if(args.size <= 0) {
                sender.sendMessage("${ChatColor.RED}Countdown started.")
                TimeManager.startCountdown()
                return true
            }

            args[0].forEach {
                if(!it.isDigit()) {
                    sender.sendMessage("${ChatColor.RED}Use a valid number.")
                    return true
                }
            }
            TimeManager.setTimeLeft(args[0].toInt())
            sender.sendMessage("${ChatColor.GRAY}You set the time left to ${ChatColor.RED}${args[0]} ${ChatColor.GRAY}seconds.")
        }
        return true
    }
}