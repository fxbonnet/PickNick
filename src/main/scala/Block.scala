import java.util.Date

/**
  * Companion factory for Block
  */
object Block {
  def createBlock(previousHash: String, data: String): Block = {
    new Block(previousHash: String, data: String)
  }
}

/**
  * Block represents a unit for blockchain. Has private default constructor and parametrized public constructor.
  */
class Block private() {
  var timestamp: Long = 0
  var previousHash: String = ""
  var data: String = ""
  var hash: String = ""

  private def this(previousHash: String, data: String) {
    this()
    this.timestamp = new Date().getTime
    this.data = data
    this.previousHash = previousHash
    this.hash = calculateHash
  }

  /**
    * Calculates hash of block by applying SHA256 hash function on sum of previous hash with timestamp and data
    */
  def calculateHash: String = {
    Crypto.hash(this.previousHash + this.timestamp.toString + this.data)
  }

  override def toString: String = {
    "Block hash:" + this.hash + " | last hash:" + this.previousHash + " | data:" + this.data
  }
}
