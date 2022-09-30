package dev.cross.tourneyutils.events

import dev.cross.tourneyutils.manager.*
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatMessage : Listener {

    @EventHandler
    fun onMessage(e : AsyncPlayerChatEvent) {
        e.isCancelled = true

        if(ChatManager.isMuted() && !e.player.isOp) {
            e.player.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Hey!")} ${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("Chat is turned off for now")}.")
            return
        }
        if(ChatManager.getChatMap(e.player) == ChatType.PARTY) {
            val message = e.message
            val team = DataStorage.getPlayerTeam(e.player)
            val chatMessage = "${ChatColor.YELLOW}[${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode(ColorGetter.getFullName(team))}${ChatColor.YELLOW}] ${ColorGetter.getColor(team)}${e.player.name}: ${ChatColor.WHITE}$message"
            for(i in DataStorage.getAllPlayersFromTeam(DataStorage.getPlayerTeam(e.player))) {
                i.sendMessage(chatMessage)
            }
            Bukkit.getLogger().info(chatMessage)
            return
        }
        val message = e.message
        val team = DataStorage.getPlayerTeam(e.player)
        val chatMessage = "${ColorGetter.getColor(team)}${e.player.name}: ${ChatColor.WHITE}$message"
        for(i in Bukkit.getOnlinePlayers()) {
            i.sendMessage(chatMessage)
        }
        Bukkit.getLogger().info(chatMessage);
        return

    }
}