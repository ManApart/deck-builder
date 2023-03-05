package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import kotlinx.html.h3
import logic.Deck
import logic.HIDDEN_CARD
import org.w3c.dom.HTMLElement
import kotlin.math.min

fun TagConsumer<HTMLElement>.deck(deckName: String, deck: Deck, visibleCount: Int = 0) {
    div("deck") {
        h3 {
            +deckName
        }
        div("deck-card-count") {
            +"${deck.size} cards"
        }
        if (visibleCount == 0) {
            card(HIDDEN_CARD)
        } else {
            deck.subList(0, min(visibleCount, deck.size)).forEach { card(it) }
        }
    }
}