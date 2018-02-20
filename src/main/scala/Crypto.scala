/**
  * Contains logic for hashing and encryption
  */
object Crypto {
  /**
    * Applies SHA256 hashing on passed text parameter
    * @param text
    * @return
    */
  def applySHA256(text: String) : String = String.format("%064x", new java.math.BigInteger(1, java.security.MessageDigest.getInstance("SHA-256").digest(text.getBytes("UTF-8"))))
}
