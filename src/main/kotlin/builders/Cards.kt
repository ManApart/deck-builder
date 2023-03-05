package builders

import logic.CardType

const val VULNERABILITY = "Vulnerability"
const val PUNCH = "Punch"

val VULNERABILITY_STARTER = card(VULNERABILITY, 10) {
    power = 0
    cost = 0
    cardType = CardType.VULNERABILITY
    victoryPoints = 0
}

val PUNCH_STARTER = card(PUNCH, 10) {
    cost = 2
    cardType = CardType.POWER
    victoryPoints = 1
}

val allCards = cards {
    card(VULNERABILITY_STARTER)
    card(PUNCH_STARTER)
}