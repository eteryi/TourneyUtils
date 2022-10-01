package dev.cross.tourneyutils.manager

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask
import java.awt.TrayIcon.MessageType

class TimeManager {
    companion object {
        private var timeLeft = 180

        private var timeRestock = 180

        var count: BukkitTask? = null

        fun setTimeLeft(time : Int) {
            timeLeft = time
            timeRestock = time

        }

        private fun getMinutesLeft(): Int {
            return timeLeft / 60
        }

        fun getSecondsLeft(): String {
            var output = ""
            if (timeLeft - (60 * getMinutesLeft()) < 10) {
                output += "0"
            }
            output += (timeLeft - (60 * getMinutesLeft())).toString()

            return output
        }

        fun startCountdown() {
            if(count != null) {
                count?.cancel()
            }
            count = object : BukkitRunnable() {
                override fun run() {
                    timeLeft--

                    for(i in Bukkit.getOnlinePlayers()) {
                        i.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("${ChatColor.RED}${getMinutesLeft()}:${getSecondsLeft()}"))
                    }

                    if(timeLeft == 0) {
                        count?.cancel()
                        for(i in Bukkit.getOnlinePlayers()) {
                            i.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Time's up!")}")
                            i.playSound(i.location, Sound.BLOCK_BELL_USE, 1.0f, 1.0f)
                            i.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Time's up!")}"))
                        }
                        timeLeft = timeRestock
                    }
                }
            }.runTaskTimer(Bukkit.getPluginManager().getPlugin("TourneyUtils")!!, 0L, 20L)
        }
    }
}