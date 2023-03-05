package ui

import el
import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.id
import logic.Game
import org.w3c.dom.HTMLElement

fun redrawGame(game: Game) {
    val root = el("game-page")
    root.innerHTML = ""
    root.append.gamePage(game)
}

fun TagConsumer<HTMLElement>.gamePage(game: Game) {
    div {
        id = "game-page"

        sharedSpace()
        game.players.forEach {
            playerSpace(it)
        }
    }
}