package dev.cross.tourneyutils.commands

import dev.cross.tourneyutils.manager.*
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AllTeleport : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is Player) {
            if(!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Whoops, you can't do that!")}")
                return true
            }
            if(args.size <= 0) {
                sender.sendMessage("${ChatColor.RED}Please provide the team you're trying to teleport. (e.g /allteleport blue) ${ChatColor.BOLD}OR ${ChatColor.RESET}${ChatColor.RED}you can specify a location (e.g /allteleport blue <location set by the /setlocation command>.")
                return true
            }
            if(ColorGetter.getTeamFromString(args[0].lowercase()) == Teams.NONE) {
                sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("That team so called ${args[0].lowercase()} was not found.")}")
                return true
            }

            var team = ColorGetter.getTeamFromString(args[0].lowercase())


            if(args.size >= 2) {
                if(ConfigManager.getLocationByName(args[1]) == null) {
                    sender.sendMessage("${ChatColor.RED}${UnicodeFormatter.getStringUnicode("Could not find so called location ${args[1]}.")}")
                    return true
                }
                for(i in DataStorage.getAllPlayersFromTeam(team)) {
                    i.teleport(ConfigManager.getLocationByName(args[1])!!)
                }
                sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("Teleporting all of")} ${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode("${ColorGetter.getFullName(team)}${ChatColor.GRAY}...")}")
                return true
            }
            for(i in DataStorage.getAllPlayersFromTeam(team)) {
                i.teleport(sender.location)
            }
            sender.sendMessage("${ChatColor.GRAY}${UnicodeFormatter.getStringUnicode("Teleporting all of")} ${ColorGetter.getColor(team)}${UnicodeFormatter.getStringUnicode("${ColorGetter.getFullName(team)}${ChatColor.GRAY}...")}")
        }
        return true
    }
}