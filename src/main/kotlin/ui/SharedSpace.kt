package ui

import game
import kotlinx.html.TagConsumer
import kotlinx.html.div
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.sharedSpace() {
    div {
        +"Shared Space"
        deck("Draw Pile", game.drawPile)
        deck("Stage", game.stage, 5)
        deck("Super Villains", game.superVillains, 1)
    }
}