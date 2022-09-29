package dev.cross.tourneyutils.manager

class UnicodeFormatter {

    companion object {
        private var lettersUnicode = hashMapOf<Char, String>('a' to "ᴀ", 'b' to "ʙ", 'c' to "ᴄ", 'd' to "ᴅ", 'e' to "ᴇ", 'f' to "ꜰ", 'g' to "ɢ", 'h' to "ʜ", 'i' to "ɪ", 'j' to "ᴊ", 'k' to "ᴋ", 'l' to "ʟ", 'm' to "ᴍ", 'n' to "ɴ", 'o' to "ᴏ", 'p' to "ᴘ", 'q' to "ꞯ", 'r' to "ʀ", 's' to "ꜱ", 't' to "ᴛ", 'u' to "ᴜ", 'v' to "ᴠ", 'w' to "ᴡ", 'x' to "x", 'y' to "ʏ", 'z' to "ᴢ")


        fun getOrdinal(i : Int) : String {


            if(i == 1) {
                return "1st"
            } else if (i == 2) {
                return "2nd"
            } else if (i == 3) {
                return "3rd"
            } else if(i <= 20) {
                return i.toString() + "th"
            }

            return "0"
        }
        fun getStringUnicode(s : String) : String? {

            var Output = ""
            s.lowercase().forEach { c ->
                if(c == ' ') {
                    Output += c
                } else if(c.isDigit()) {
                    Output += getIntUnicode(c.digitToInt())
                } else if(c.isLetter()) {
                    Output += lettersUnicode[c]
                } else {
                    Output += c
                }
            }
            return Output

        }
        fun getIntUnicode(number : Int): String {

            var Output = ""

            var numberOfPlayers = number
            val arr = arrayOf("₀", "₁", "₂", "₃", "₄", "₅", "₆", "₇",  "₈","₉");

            numberOfPlayers.toString().forEach { c ->

                Output += arr[c.digitToInt()]

            }

            return Output
        }


    }
}