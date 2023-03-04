package logic

class Player(
    val superHero: SuperHero,
    val hand: Deck= mutableListOf(),
    val drawPile: Deck= mutableListOf(),
    val discardPile: Deck= mutableListOf(),
) {
    var weaknesses = 0
    var extraTurnPower = 0

    fun newTurn(){
        extraTurnPower = 0
        hand.drawAll(discardPile)
        drawPile.send(5, hand, discardPile)
    }

    fun getPower(): Int {
        return hand.sumOf { it.power } + extraTurnPower
    }
}