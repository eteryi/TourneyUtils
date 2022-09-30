package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ChatManager
import dev.cross.tourneyutils.manager.ChatType
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PartyChat : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(ChatManager.getChatMap(sender) == ChatType.PARTY) {
                ChatManager.setChatType(sender, ChatType.LOCAL)
                sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("You're now talking in the")} ${ChatColor.WHITE}${UnicodeFormatter.getStringUnicode("LOCAL")} ${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("chat.")}")
                return true
            }
            ChatManager.setChatType(sender, ChatType.PARTY)
            sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("You're now talking in the")} ${ChatColor.YELLOW}${UnicodeFormatter.getStringUnicode("PARTY")} ${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("chat.")}")
        }
        return true
    }


}