package logic

import builders.allCards
import builders.allSuperHeroes
import builders.allSuperVillains

data class Game(val players: List<Player>, val drawPile: Deck, val stage: Deck, val superVillains: Deck) {

}

fun newGame(playerCount: Int = 2): Game {
    val cards = allCards.shuffled().toMutableList()
    val villains = allSuperVillains.shuffled().toMutableList()
    val supers = allSuperHeroes.shuffled()
    val players = (0 until playerCount).map { i ->
        Player(supers[i]).also {
            cards.send(5, it.hand)
        }
    }
//    println("Game has ${cards.size} cards, ${villains.size} villains, ${supers.size} supers.")
//    players.forEach { println("${it.superHero.name} has ${it.hand.size} cards") }

    return Game(players, cards, mutableListOf(), villains).apply {
        drawPile.send(5, stage)
    }
}