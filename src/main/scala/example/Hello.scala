package example
import org.playstrategy.FairyStockfish

object Hello extends Greeting with App {
  println(greeting)
  FairyStockfish.init()
  FairyStockfish.info()
  println(FairyStockfish.validateFEN("shogi", "lnsgkgsnl/1r5b1/ppppppppp/9/9/9/PPPPPPPPP/1B5R1/LNSGKGSNL b - 1"))

  //  The syntax for doing this is strange, due to the wrapper.
  val moves = new FairyStockfish.VectorOfStrings()
  // The UCI for this move is wrong, if we fix it, then it should work.
  moves.push_back("3i4h")
  println(FairyStockfish.getFEN("shogi", "lnsgkgsnl/1r5b1/ppppppppp/9/9/9/PPPPPPPPP/1B5R1/LNSGKGSNL b - 1", moves))
}

trait Greeting {
  lazy val greeting: String = "hello"
}
