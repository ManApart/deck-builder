package ui

import game
import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.js.onClickFunction
import kotlinx.html.span
import logic.Card
import logic.Move
import logic.Player
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.card(card: Card, player: Player? = null) {
    with(card) {
        div("card") {
            div("card-title") {
                +name
            }
            div("card-type") {
                +"Type: ${cardType.name}"
            }
            div("card-stats") {
                span {
                    +"Power: $power"
                }
                span {
                    +"Cost: $cost"
                }
                span {
                    +"Victory Points: ${getVictoryPoints()}"
                }
                moves(moves, player)
            }

        }
    }
}

fun TagConsumer<HTMLElement>.moves(moves: List<Move>, player: Player? = null) {
    div("card-moves") {
        moves.forEach { move ->
            div("card-move") {
                +move.description
            }
            if (player != null && move.canPlay(game, player) && !move.playedThisTurn) {
                div("button button-active") {
                    +"Use"
                    onClickFunction = {
                        move.move(game, player)
                        move.playedThisTurn = true
                        redrawGame(game)
                    }
                }
            } else {
                div("button button-disabled") {
                    +"Use"
                }
            }
        }
    }
}