package builders

import logic.SuperHero

class SuperHeroBuilder(private val name: String) {
    private var moves = mutableListOf<MoveBuilder>()

    fun move(initializer: MoveBuilder.() -> Unit) {
        moves.add(MoveBuilder().apply(initializer))
    }

    fun build(): SuperHero {
        return SuperHero(name, moves.map { it.build() })
    }
}

class SuperHeroesBuilder {
    private val heroes = mutableListOf<SuperHeroBuilder>()
    fun hero(name: String, initializer: SuperHeroBuilder.() -> Unit) {
        heroes.add(SuperHeroBuilder(name).apply(initializer))
    }

    fun build(): List<SuperHero> {
        return heroes.map { it.build() }
    }
}

fun superHeroes(initializer: SuperHeroesBuilder.() -> Unit): List<SuperHero> {
    return SuperHeroesBuilder().apply(initializer).build()
}
