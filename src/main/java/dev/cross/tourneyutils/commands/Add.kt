package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ColorGetter
import dev.cross.tourneyutils.manager.DataStorage
import dev.cross.tourneyutils.manager.Teams
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Add : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }
            if(args.size <= 1) {
                sender.sendMessage("${ChatColor.RED}Correct usage: /add <player> <team> (e.g: /add etery lime")
                sender.sendMessage("${ChatColor.RED}or /add etery,vibesnek lime)")
                return true
            }


            val players = args[0].split(',')

            for(i in players) {
                if(Bukkit.getPlayerExact(i) == null) {
                    sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That player so called $i was not found.")}")
                    return true
                }
            }
            if(ColorGetter.getTeamFromString(args[1].lowercase()) == Teams.NONE) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That team so called ${args[1].lowercase()} was not found.")}")
                return true
            }
            var team = ColorGetter.getTeamFromString(args[1].lowercase())
            sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("You have added ${args[0].lowercase()} to")} ${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode("${args[1]}.")}")

            for(i in players) {
                DataStorage.setPlayerTeam(Bukkit.getPlayerExact(i)!!, team)
            }
        }
        return true
    }
}