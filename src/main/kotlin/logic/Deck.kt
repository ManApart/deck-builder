package logic

import kotlin.math.min

typealias Deck = MutableList<Card>

fun Deck.send(destination: Deck) {
    if (isNotEmpty()) {
        send(this.first(), destination)
    }
}

fun Deck.send(card: Card, destination: Deck) {
    destination.add(card)
    remove(card)
    card.reset()
}

fun Deck.send(amount: Int, destination: Deck) {
    val amountToSend = min(size, amount)
    val sent = take(amountToSend)
    sent.forEach {
        this.remove(it)
        it.reset()
    }
    destination.addAll(sent)
}

fun Deck.send(amount: Int, destination: Deck, shuffleBackup: Deck) {
    if (amount > size) {
        addAll(shuffleBackup.shuffled())
        shuffleBackup.clear()
    }
    send(amount, destination)
}

fun Deck.drawAll(destination: Deck) {
    forEach { it.reset() }
    destination.addAll(this)
    this.clear()
}

fun Deck.hasCard(name: String): Boolean {
    return getCard(name) != null
}

fun Deck.getCard(name: String): Card? {
    return firstOrNull { it.name.lowercase() == name.lowercase() }
}


//fun Deck.power(name: String): Boolean {
//
//}