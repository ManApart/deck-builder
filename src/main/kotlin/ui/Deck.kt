package ui

import kotlinx.html.TagConsumer
import kotlinx.html.div
import logic.Deck
import org.w3c.dom.HTMLElement
import kotlin.math.min

fun TagConsumer<HTMLElement>.deck(deckName: String, deck: Deck, visibleCount: Int = 0) {
    div {
        +deckName
//        println("Deck has ${deck.size} cards and shows $visibleCount")
        deck.subList(0, min(visibleCount, deck.size-1)).forEach { card(it) }
    }
}