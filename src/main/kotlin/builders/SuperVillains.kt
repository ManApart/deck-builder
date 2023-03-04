package builders

import logic.CardType

const val CHURRIOSO = "Churrioso"

val allSuperVillains = cards {
    card(CHURRIOSO, 1) {
        power = 0
        cost = 0
        cardType = CardType.VULNERABILITY
        victoryPoints = 0
        move {
            description = "On reveal, forces all players to discard one card."
            //TODO -implement attacks
        }
    }
}