package builders

import Card
import CardType

class CardBuilder(private val name: String, private val count: Int) {
    var cost = 1
    var cardType = CardType.POWER
    var power = 1
    var getVictoryPoints = { 1 }
    private var moves = mutableListOf<MoveBuilder>()

    fun move(initializer: MoveBuilder.() -> Unit) {
        moves.add(MoveBuilder().apply(initializer))
    }

    fun build(): List<Card> {
        return (0 until count).map { Card(name, cost, cardType, power, getVictoryPoints, moves.map { it.build() }) }
    }
}

class CardsBuilder {
    private val cards = mutableListOf<CardBuilder>()
    fun card(name: String, count: Int, initializer: CardBuilder.() -> Unit) {
        cards.add(CardBuilder(name, count).apply(initializer))
    }

    fun build(): List<Card> {
        return cards.flatMap { it.build() }
    }
}

fun cards(initializer: CardsBuilder.() -> Unit): List<Card> {
    return CardsBuilder().apply(initializer).build()
}
