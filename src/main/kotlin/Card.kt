enum class CardType { EQUIPMENT, POWER, HERO, VILLAIN, SUPER_VILLAIN, VULNERABILITY }
enum class MoveType { DEFEND, ATTACK, TURN_START, TURN_END }

data class Move(
    val type: MoveType,
    val description: String,
    val canPlay: (Game, Player) -> Boolean,
    val move: (Game, Player) -> Unit
) {
    var playedThisTurn = false

    fun reset(){
        playedThisTurn = false
    }
}

data class SuperHero(val name: String, val moves: List<Move>)

data class Card(
    val name: String,
    val cost: Int,
    val cardType: CardType,
    val power: Int,
    val getVictoryPoints: () -> Int,
    val moves: List<Move>,
) {
    fun reset(){
        moves.forEach { it.reset() }
    }
}