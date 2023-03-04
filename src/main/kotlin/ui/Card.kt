package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.span
import logic.Card
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.card(card: Card) {
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
            }
            div("card-moves"){
                moves.forEach { move ->
                    div("card-move") {
                        +move.description
                    }
                }
            }
        }
    }
}