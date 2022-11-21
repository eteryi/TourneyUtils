package dev.cross.tourneyutils.events

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class OnMessage : Listener {

    @EventHandler
    fun onTell(e : PlayerCommandPreprocessEvent) {

        println(e.message)
    }
}