package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.h3
import logic.Player
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.playerSpace(player: Player) {
    div("player") {
        h3 {
            +"Player: ${player.superHero.name}"
        }
        deck("Draw Pile", player.drawPile)
        deck("Hand", player.hand, 100)
        deck("Discard Pile", player.discardPile)
    }
}