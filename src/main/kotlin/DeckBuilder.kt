import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.dom.append
import logic.newGame
import org.w3c.dom.HTMLElement
import ui.gamePage

val game = newGame()

fun main() {
    window.onload = {
        document.body?.append {
            gamePage(game)
        }
    }
}

fun el(id: String) = document.getElementById(id) as HTMLElement
fun <T> el(id: String) = document.getElementById(id) as T