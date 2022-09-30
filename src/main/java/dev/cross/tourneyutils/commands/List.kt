package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.ColorGetter
import dev.cross.tourneyutils.manager.DataStorage
import dev.cross.tourneyutils.manager.Teams
import dev.cross.tourneyutils.manager.UnicodeFormatter
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class List : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(args.size <= 0) {
                for(team in Teams.values()) {
                    sender.sendMessage("${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode("${ColorGetter.getFullName(team)}: ")}")
                    sender.sendMessage("     ")

                    for(i in DataStorage.getAllPlayersFromTeam(team)) {

                        sender.sendMessage("${ColorGetter.getColor(team)}${i.name}")

                    }
                    sender.sendMessage("        ")
                }
                return true
            }
            if(ColorGetter.getTeamFromString(args[0].lowercase()) == Teams.NONE) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That team so called ${args[0].lowercase()} was not found.")}")
                return true
            }

            var team = ColorGetter.getTeamFromString(args[0].lowercase())

            sender.sendMessage("${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode("${ColorGetter.getFullName(team)}: ")}")
            sender.sendMessage("     ")

            for(i in DataStorage.getAllPlayersFromTeam(team)) {

                sender.sendMessage("${ColorGetter.getColor(team)}${i.name}")

            }
            sender.sendMessage("        ")
        }
        return true
    }
}