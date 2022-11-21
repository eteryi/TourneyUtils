package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ColorGetter
import dev.cross.tourneyutils.manager.DataStorage
import dev.cross.tourneyutils.manager.Teams
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Announce : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }

            if(args.size <= 1) {
                sender.sendMessage("${ChatColor.RED}Correct usage: /announce <team1> <team2> (e.g: /announce lime blue)")
                return true
            }
            if(ColorGetter.getTeamFromString(args[0].lowercase()) == Teams.NONE) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That team so called ${args[0].lowercase()} was not found.")}")
                return true
            }
            if(ColorGetter.getTeamFromString(args[1].lowercase()) == Teams.NONE) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That team so called ${args[1].lowercase()} was not found.")}")
                return true
            }

            var teamOne = ColorGetter.getTeamFromString(args[0].lowercase())
            var teamTwo = ColorGetter.getTeamFromString(args[1].lowercase())

            for(i in Bukkit.getOnlinePlayers()) {
                i.playSound(i.location, Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 0.025F)
                i.sendTitle("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("NEXT ROUND!")}", "${ColorGetter.getColor(teamOne)}${UnicodeFormatter.getStringUnicode(ColorGetter.getFullName(teamOne))} ${ChatColor.WHITE}${UnicodeFormatter.getStringUnicode("vs")} ${ColorGetter.getColor(teamTwo)}${UnicodeFormatter.getStringUnicode(ColorGetter.getFullName(teamTwo))}", 0, (20 * DataStorage.getRoundAnnounceTime()), 0)
            }
        }
        return true
    }
}