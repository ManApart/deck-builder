package logic

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