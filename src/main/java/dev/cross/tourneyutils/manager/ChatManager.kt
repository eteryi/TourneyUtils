package dev.cross.tourneyutils.manager

import org.bukkit.entity.Player
import java.util.UUID

class ChatManager {
    companion object {
        private var chatMap = hashMapOf<UUID, ChatType>()
        private var isMuted = false
        private val lastPlayerMessaged = hashMapOf<Player, Player>()

        fun setLastMessaged(p : Player, m : Player) {
            lastPlayerMessaged[p] = m
        }
        fun getLastMessaged(p : Player): Player? {
            return lastPlayerMessaged[p]
        }
        fun setIsMuted(b : Boolean) {
            isMuted = b
        }

        fun isMuted(): Boolean {
            return isMuted
        }

        fun getChatMap(p : Player): ChatType {
            return chatMap[p.uniqueId] ?: ChatType.LOCAL
        }

        fun setChatType(p : Player, chat : ChatType) {
            chatMap[p.uniqueId] = chat
        }
    }
}