/**
  * Created by Nick on 19/2/18.
  */
object Crypto {
  def applySHA256(text: String) : String = String.format("%064x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("SHA-256").digest(text.getBytes("UTF-8"))))
}
