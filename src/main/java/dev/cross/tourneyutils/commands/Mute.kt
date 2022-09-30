package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ChatManager
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Mute : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }
            if(ChatManager.isMuted()) {
                ChatManager.setIsMuted(false)
                sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("Chat is now turned")} ${ChatColor.GREEN}${UnicodeFormatter.getStringUnicode("on")}${ChatColor.GRAY}.")
                return true
            }
            ChatManager.setIsMuted(true)
            sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("Chat is now turned")} ${ChatColor.RED}${UnicodeFormatter.getStringUnicode("off")}${ChatColor.GRAY}.")
            return true
        }
        return true
    }
}