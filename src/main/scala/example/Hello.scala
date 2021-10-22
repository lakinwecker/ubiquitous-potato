package example
import org.playstrategy.FairyStockfish

object Hello extends Greeting with App {
  println(greeting)
  FairyStockfish.init()
  //FairyStockfish.info()
  val variant = "shogi"
  val initFen = FairyStockfish.initialFen(variant)
  val emptyMoves = new FairyStockfish.VectorOfStrings()
  val legalMoves = FairyStockfish.getLegalMoves(variant, initFen, emptyMoves)
  val uciMoves = List.range(0, legalMoves.size()).map(i => legalMoves.get(i).getString())
  println(uciMoves)
  uciMoves.map(m => println(FairyStockfish.getFEN(variant, initFen, new FairyStockfish.VectorOfStrings(m))))

  val piecesOnBoard = FairyStockfish.piecesOnBoard(variant, initFen)
  var first = piecesOnBoard.begin();
  while(!first.equals(piecesOnBoard.end())) {
    println(s"${first.first().getString()} -> ${first.second().color()} - ${first.second().pieceInfo().id}")
    first = first.increment();
  }

  //println(FairyStockfish.gameResult(variant, initFen, emptyMoves))
  //println(FairyStockfish.isImmediateGameEnd(variant, initFen, emptyMoves))
  //println(FairyStockfish.hasInsufficientMaterial(variant, initFen, emptyMoves).get1())
}

trait Greeting {
  lazy val greeting: String = "hello"
}
