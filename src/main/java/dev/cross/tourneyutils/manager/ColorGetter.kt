package dev.cross.tourneyutils.manager

import org.bukkit.ChatColor

class ColorGetter {
    companion object {

        fun getTeamFromString(team : String) : Teams {
            var colorMap = hashMapOf<String, Teams>(

                "lime" to Teams.LIME_LLAMAS,
                "pink" to Teams.PINK_PARROTS,
                "purple" to Teams.PURPLE_PANDAS,
                "blue" to Teams.BLUE_BATS,
                "red" to Teams.RED_RABBITS,
                "green" to Teams.GREEN_GECKOS,
                "cyan" to Teams.CYAN_COYOTES,
                "aqua" to Teams.AQUA_AXOLOTLS
            )
            return colorMap[team] ?: Teams.NONE
        }
        fun getColor(team : Teams): ChatColor {
            var colorMap = hashMapOf<Teams, ChatColor>(

                Teams.LIME_LLAMAS to ChatColor.GREEN,
                Teams.PINK_PARROTS to ChatColor.LIGHT_PURPLE,
                Teams.PURPLE_PANDAS to ChatColor.DARK_PURPLE,
                Teams.BLUE_BATS to ChatColor.BLUE,
                Teams.RED_RABBITS to ChatColor.RED,
                Teams.GREEN_GECKOS to ChatColor.DARK_GREEN,
                Teams.CYAN_COYOTES to ChatColor.DARK_AQUA,
                Teams.AQUA_AXOLOTLS to ChatColor.AQUA
            )
            return colorMap[team] ?: ChatColor.WHITE
        }
        fun getFullName(team : Teams): String {
            var colorMap = hashMapOf<Teams, String>(

                Teams.LIME_LLAMAS to "Lime Llamas",
                Teams.PINK_PARROTS to "Pink Parrots",
                Teams.PURPLE_PANDAS to "Purple Pandas",
                Teams.BLUE_BATS to "Blue Bats",
                Teams.RED_RABBITS to "Red Rabbits",
                Teams.GREEN_GECKOS to "Green Geckos",
                Teams.CYAN_COYOTES to "Cyan Coyotes",
                Teams.AQUA_AXOLOTLS to "Aqua Axolotls"
            )
            return colorMap[team] ?: "NONE"
        }
    }
}