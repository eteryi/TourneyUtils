package dev.cross.tourneyutils.manager

import org.bukkit.entity.Player
import java.util.UUID

class ChatManager {
    companion object {
        private var chatMap = hashMapOf<UUID, ChatType>()
        private var isMuted = false

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