package logic

data class Game(val players: List<Player>, val drawPile: Deck, val stage: Deck, val superVillains: Deck) {

    fun newGame(){

    }
}