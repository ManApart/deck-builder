package builders

import SuperHero

class HeroBuilder(private val name: String) {
    private var moves = mutableListOf<MoveBuilder>()

    fun move(initializer: MoveBuilder.() -> Unit) {
        moves.add(MoveBuilder().apply(initializer))
    }

    fun build(): SuperHero {
        return SuperHero(name, moves.map { it.build() })
    }
}

class HeroesBuilder {
    private val heroes = mutableListOf<HeroBuilder>()
    fun hero(name: String, count: Int, initializer: HeroBuilder.() -> Unit) {
        heroes.add(HeroBuilder(name).apply(initializer))
    }

    fun build(): List<SuperHero> {
        return heroes.map { it.build() }
    }
}

fun heros(initializer: HeroesBuilder.() -> Unit): List<SuperHero> {
    return HeroesBuilder().apply(initializer).build()
}
