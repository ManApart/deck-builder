package builders

import logic.CardType

const val VULNERABILITY = "Vulnerability"
const val PUNCH = "Glock Guac"

val allCards = cards {
    card(VULNERABILITY, 10) {
        power = 0
        cost = 0
        cardType = CardType.VULNERABILITY
        victoryPoints = 0
    }
    card(PUNCH, 10) {
        cost = 2
        cardType = CardType.POWER
        victoryPoints = 1
    }
}