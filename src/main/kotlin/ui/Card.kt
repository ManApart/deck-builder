package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import logic.Card
import org.w3c.dom.HTMLElement

fun TagConsumer<HTMLElement>.card(card: Card){
    div {
        +card.name
    }
}