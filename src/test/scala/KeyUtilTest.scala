import org.specs2.mutable.Specification

class KeyUtilTest extends Specification {

  "KeyUtil" should {
    "generate key pairs, encrypt end decrypt texts" in {
      val keyPair = KeyUtil.generateKeyPair()
      val text = "Text to be encrypted"
      val encryptedText = KeyUtil.encrypt(text, keyPair)
      val decryptedText = KeyUtil.decrypt(encryptedText, keyPair)
      decryptedText shouldEqual text
    }
  }
}