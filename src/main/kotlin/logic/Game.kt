package logic

import builders.*

data class Game(val players: List<Player>, val drawPile: Deck, val stage: Deck, val superVillains: Deck) {

}

fun newGame(playerCount: Int = 2): Game {
    val cards = allCards.shuffled().toMutableList()
    val villains = allSuperVillains.shuffled().toMutableList()
    val supers = allSuperHeroes.shuffled()
    val players = (0 until playerCount).map { i ->
        Player(i, supers[i]).also { player ->
            repeat(5){player.drawPile.add(VULNERABILITY_STARTER.first().copy())}
            repeat(5){player.drawPile.add(PUNCH_STARTER.first().copy())}
            player.drawPile.shuffle()
            player.drawPile.send(5, player.hand)
        }
    }
    println("Game has ${cards.size} cards, ${villains.size} villains, ${supers.size} supers.")

    return Game(players, cards, mutableListOf(), villains).apply {
        drawPile.send(5, stage)
    }
}