package example
import org.playstrategy.FairyStockfish

object Hello extends Greeting with App {
  println(greeting)
  FairyStockfish.init()
  FairyStockfish.info()
  val variant = "shogi"
  val initFen = FairyStockfish.initialFen(variant)
  val legalMoves = FairyStockfish.getLegalMoves(variant, initFen, new FairyStockfish.VectorOfStrings())
  val uciMoves = List.range(0, legalMoves.size()).map(i => legalMoves.get(i).getString())
  println(uciMoves)
  uciMoves.map(m => println(FairyStockfish.getFEN(variant, initFen, new FairyStockfish.VectorOfStrings(m))))

  val piecesOnBoard = FairyStockfish.piecesOnBoard(variant, initFen)
  var first = piecesOnBoard.begin();
  while(!first.equals(piecesOnBoard.end())) {
    println(s"${first.first().getString()} -> ${first.second().pieceInfo().name().getString()}")
    first = first.increment();
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
