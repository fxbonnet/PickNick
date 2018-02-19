import scala.collection.mutable.ListBuffer

/**
  * Created by Nick on 19/2/18.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val blockChain = ListBuffer(new Block("0", "Genesis block!"))
    for (i <- 1 to 10) {
      blockChain += new Block(blockChain.last.toString, "Block " + i)
    }
    blockChain.foreach(println)
  }
}
