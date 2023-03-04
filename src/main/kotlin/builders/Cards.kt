package builders

import logic.CardType

const val GLOCK_GUAC = "Glock Guac"

val cards = cards {
    card("Vulnerability", 10) {
        power = 0
        cost = 0
        cardType = CardType.VULNERABILITY
        victoryPoints = 0
    }
    card("Punch", 10) {
        cost = 2
        cardType = CardType.POWER
        victoryPoints = 1
    }
}