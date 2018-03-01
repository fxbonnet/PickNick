import org.specs2.mutable.Specification

class CryptoTest extends Specification {

  "Crypto" should {
    "generate key pairs, encrypt end decrypt texts" in {
      val keyPair = Crypto.generateKeyPair()
      val text = "Text to be encrypted"
      val encryptedText = Crypto.encrypt(text, keyPair.getPrivate)
      val decryptedText = Crypto.decrypt(encryptedText, keyPair.getPublic)
      decryptedText shouldEqual text
    }
    "sign and verify signatures" in {
      val keyPair = Crypto.generateKeyPair()
      val text = "Text to be encrypted"
      val signature = Crypto.sign(text, keyPair.getPrivate)
      Crypto.verify(text, signature, keyPair.getPublic) should_=== true
      Crypto.verify("wrong text", signature, keyPair.getPublic) should_=== false
    }
  }
}