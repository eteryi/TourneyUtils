package dev.cross.tourneyutils.manager

import net.md_5.bungee.api.ChatColor


class ColorGetter {
    companion object {

        fun getTeamFromString(team : String) : Teams {
            var colorMap = hashMapOf<String, Teams>(

                "lavender" to Teams.LAVENDER_LIGHTERS,
                "lime" to Teams.LIME_LLAMAS,
                "pink" to Teams.PINK_PARROTS,
                "purple" to Teams.PURPLE_PANDAS,
                "blue" to Teams.BLUE_BATS,
                "red" to Teams.RED_RABBITS,
                "green" to Teams.GREEN_GECKOS,
                "cyan" to Teams.CYAN_COYOTES,
                "aqua" to Teams.AQUA_AXOLOTLS,
                "yellow" to Teams.YELLOW_YAKS,
                "orange" to Teams.ORANGE_OCELOTS
            )
            return colorMap[team] ?: Teams.NONE
        }
        fun getColor(team : Teams): ChatColor {
            var colorMap = hashMapOf<Teams, net.md_5.bungee.api.ChatColor>(

                Teams.LAVENDER_LIGHTERS to ChatColor.of("#dcd0ff"),
                Teams.LIME_LLAMAS to ChatColor.GREEN,
                Teams.PINK_PARROTS to ChatColor.LIGHT_PURPLE,
                Teams.PURPLE_PANDAS to ChatColor.DARK_PURPLE,
                Teams.BLUE_BATS to ChatColor.BLUE,
                Teams.RED_RABBITS to ChatColor.RED,
                Teams.GREEN_GECKOS to ChatColor.DARK_GREEN,
                Teams.CYAN_COYOTES to ChatColor.DARK_AQUA,
                Teams.AQUA_AXOLOTLS to ChatColor.AQUA,
                Teams.ORANGE_OCELOTS to ChatColor.of("#eb941a"),
                Teams.YELLOW_YAKS to ChatColor.YELLOW
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
                Teams.AQUA_AXOLOTLS to "Aqua Axolotls",
                Teams.YELLOW_YAKS to "Yellow Yaks",
                Teams.ORANGE_OCELOTS to "Orange Ocelots",
                Teams.LAVENDER_LIGHTERS to "Lavender Lighters"
            )
            return colorMap[team] ?: "NONE"
        }
    }
}