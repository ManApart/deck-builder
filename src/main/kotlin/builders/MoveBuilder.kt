package builders

import Game
import Move
import MoveType
import Player

class MoveBuilder {
    var type = MoveType.ATTACK
    var description = "A move"
    var canPlay: (Game, Player) -> Boolean = { _, _ -> true }
    var move: (Game, Player) -> Unit = { _, _ -> }


    fun build(): Move {
        return Move(type, description, canPlay, move)
    }
}