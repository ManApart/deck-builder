package ui

import game
import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.js.onClickFunction
import logic.Player
import logic.SuperHero
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.playerSpace(player: Player) {
    div("player") {
        h1 {
            +"Player ${player.id}"
        }
        if (game.isPlayerTurn(player)) {
            div("button button-active") {
                +"End Turn"
                onClickFunction = {
                    game.nextPlayerTurn()
                    redrawGame(game)
                }
            }
        }
        hero(player.superHero, player)
        deck("Draw Pile", player.drawPile)
        deck("Hand", player.hand, 100)
        deck("Discard Pile", player.discardPile)
    }
}

fun TagConsumer<HTMLElement>.hero(hero: SuperHero, player: Player) {
    with(hero) {
        div("super-hero") {
            +hero.name
            moves(moves, player)
        }
    }
}