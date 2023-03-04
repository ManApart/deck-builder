package ui

import kotlinx.html.TagConsumer
import logic.Game
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.gamePage(game: Game) {
    sharedSpace()
    game.players.forEach {
        playerSpace(it)
    }
}