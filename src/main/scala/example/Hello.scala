package example
import org.playstrategy.FairyStockfish

object Hello extends Greeting with App {
  println(greeting)
  FairyStockfish.init()
  FairyStockfish.info()
}

trait Greeting {
  lazy val greeting: String = "hello"
}
