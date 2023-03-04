package logic

class Player(
    val superHero: SuperHero,
    val hand: Deck,
    val drawPile: Deck,
    val discardPile: Deck,
) {
    var extraTurnPower = 0

    fun newTurn(){
        extraTurnPower = 0
        hand.drawAll(discardPile)
        drawPile.drawAmount(5, hand, discardPile)
    }
}