package dev.cross.tourneyutils.manager

import org.bukkit.Bukkit
import org.bukkit.Location

class ConfigManager {

    companion object {
        private val config = Bukkit.getPluginManager().getPlugin("TourneyUtils")!!.config

        fun addLocationToConfig(locName : String, loc : Location) {
            config.set(locName.lowercase(), loc)
            Bukkit.getPluginManager().getPlugin("TourneyUtils")!!.saveConfig()
        }

        fun getLocationByName(locName: String): Location? {
            return config.getLocation(locName.lowercase())
        }
    }
}