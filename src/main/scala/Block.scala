import java.util.Date

/**
  * Created by Nick on 19/2/18.
  */
class Block private() {
  var timestamp: Long = 0
  var previousHash: String = ""
  var data: String = ""
  var hash: String = ""

  def this(previousHash: String, data: String) {
    this()
    this.timestamp = new Date().getTime
    this.data = data
    this.previousHash = previousHash
    this.hash = calculateHash
  }

  def calculateHash: String = {
    Crypto.applySHA256(this.previousHash + this.timestamp.toString + this.data)
  }

  override def toString: String = {
    "Block hash:" + this.hash + " | last hash:" + this.previousHash + " | data:" + this.data
  }
}
