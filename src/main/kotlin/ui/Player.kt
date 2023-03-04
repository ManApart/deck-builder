package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import logic.Player
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.playerSpace(player: Player) {
    div {
        +"Player: ${player.superHero.name}."
    }
}