import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.dom.append
import logic.newGame
import ui.gamePage

val game = newGame()

fun main() {
    window.onload = {
        document.body?.append {
            gamePage(game)
        }
    }
}
