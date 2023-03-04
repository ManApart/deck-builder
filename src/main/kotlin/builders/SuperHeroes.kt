package builders

import logic.MoveType
import logic.send
import logic.getCard
import logic.hasCard

const val GLOCK_GUAC = "Glock Guac"

val allSuperHeroes = superHeroes {
    hero("Taco Man") {
        move {
            description = "If you have the Guac Glock in your hand, place it on the bottom of your draw pile and draw two cards."
            type = MoveType.TURN_START
            canPlay = { _, player -> player.hand.hasCard(GLOCK_GUAC) }
            move = { _, player ->
                val card = player.hand.getCard(GLOCK_GUAC)
                if (card != null) {
                    player.hand.send(card, player.drawPile)
                    player.drawPile.send(2, player.hand, player.discardPile)
                }
            }
        }
    }
    hero("Queso Boy") {
        move {
            description = "At the start of every turn, draw an extra card."
            type = MoveType.TURN_START
            move = { _, player ->
                player.drawPile.send(1, player.hand, player.discardPile)
            }
        }
    }
}