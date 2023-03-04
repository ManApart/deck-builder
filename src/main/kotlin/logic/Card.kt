package logic

enum class CardType { EQUIPMENT, POWER, HERO, VILLAIN, SUPER_VILLAIN, VULNERABILITY }

val HIDDEN_CARD = Card("Hidden", 0, CardType.VULNERABILITY, 0)

data class Card(
    val name: String,
    val cost: Int,
    val cardType: CardType,
    val power: Int,
    val getVictoryPoints: () -> Int = {0},
    val moves: List<Move> = listOf(),
) {
    fun reset(){
        moves.forEach { it.reset() }
    }
}