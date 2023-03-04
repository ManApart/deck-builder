package logic

typealias Deck = MutableList<Card>

fun Deck.send(destination: Deck)  {
  if (isNotEmpty()){
      send(this.first(), destination)
  }
}

fun Deck.send(card: Card, destination: Deck) {
    card.reset()
    destination.add(card)
    remove(card)
}

fun Deck.send(amount: Int, destination: Deck, shuffleBackup: Deck) {
    //TODO
//    val card = this.first()
//    card.reset()
//    destination.add(card)
//    remove(card)
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