import java.nio.charset.StandardCharsets
import java.security.{KeyPair, KeyPairGenerator}

import javax.crypto.Cipher

object KeyUtil {
  val ALGORITHM = "RSA"

  /**
    * Generate a key pair with private and public key using 1024 bytes.
    */
  def generateKeyPair(): KeyPair = {
    val keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM)
    keyPairGenerator.initialize(1024)
    keyPairGenerator.generateKeyPair
  }

  /**
    * Encrypt a String using a public key.
    */
  def encrypt(text: String, keyPair: KeyPair): Array[Byte] = {
    val cipher = Cipher.getInstance(ALGORITHM)
    cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic)
    cipher.doFinal(text.getBytes(StandardCharsets.UTF_8))
  }

  /**
    * Decrypt a String using a private key.
    */
  def decrypt(text: Array[Byte], keyPair: KeyPair): String = {
    val cipher = Cipher.getInstance(ALGORITHM)
    cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate)
    new String(cipher.doFinal(text), StandardCharsets.UTF_8)
  }
}