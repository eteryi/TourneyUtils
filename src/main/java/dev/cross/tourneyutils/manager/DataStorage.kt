package dev.cross.tourneyutils.manager

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.util.UUID

class DataStorage {
    companion object {

        private var playerTeams = hashMapOf<UUID, Teams>()

        fun setPlayerTeam(player: Player, team : Teams) {
            playerTeams[player.uniqueId] = team
        }

        fun removePlayerTeam(player: Player) {
            playerTeams.remove(player.uniqueId)
        }

        fun getAllPlayersFromTeam(team : Teams): ArrayList<Player> {
            var listOfPlayers = arrayListOf<Player>()
            for(i in Bukkit.getOnlinePlayers()) {
                if((playerTeams[i.uniqueId] ?: Teams.NONE) == team) {
                    listOfPlayers.add(i)
                }
            }
            return listOfPlayers
        }

    }
}