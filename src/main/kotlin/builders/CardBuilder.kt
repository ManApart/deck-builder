package builders

import logic.Card
import logic.CardType

class CardBuilder(private val name: String, private val count: Int) {
    var cost = 1
    var cardType = CardType.POWER
    var power = 1
    var victoryPoints: Int? = null
    var getVictoryPoints = { 1 }
    private var moves = mutableListOf<MoveBuilder>()

    fun move(initializer: MoveBuilder.() -> Unit) {
        moves.add(MoveBuilder().apply(initializer))
    }

    fun build(): List<Card> {
        val victory = if (victoryPoints != null) {
            { victoryPoints!! }
        } else getVictoryPoints
        return (0 until count).map { Card(name, cost, cardType, power, victory, moves.map { it.build() }) }
    }
}

class CardsBuilder {
    private val cards = mutableListOf<CardBuilder>()

    fun card(name: String, initializer: CardBuilder.() -> Unit) {
        cards.add(CardBuilder(name, 1).apply(initializer))
    }
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
