package builders

val superHeroes = superHeroes {
    hero("Taco Man") {
        move {
            description = "If you have the Guac Glock in your hand, place it on the bottom of your draw pile and draw two cards."
            type = MoveType.TURN_START
            canPlay = {_, player -> player.hand.any { it.name == "Guac Glock" } }
//            move = {}
        }
    }
    hero("Queso Boy") {
        move {
            description = "At the start of every turn, draw an extra card"
        }
    }
}