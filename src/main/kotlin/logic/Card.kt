package logic

enum class CardType { EQUIPMENT, POWER, HERO, VILLAIN, SUPER_VILLAIN, VULNERABILITY }

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