import java.math.BigInteger
import java.nio.charset.StandardCharsets.UTF_8
import java.security._
import java.util.Base64

import javax.crypto.Cipher

/**
  * Contains logic for hashing and encryption
  */
object Crypto {
  private val RSA = "RSA"
  private val KEY_SIZE = 2048
  private val SHA256 = "SHA-256"
  private val SHA256_RSA = "SHA256withRSA"

  /**
    * Applies hashing on passed text parameter.
    */
  def hash(text: String): String = {
    val messageDigest = MessageDigest.getInstance(SHA256)
    val hashBytes = messageDigest.digest(text.getBytes(UTF_8))
    String.format("%064x", new BigInteger(1, hashBytes))
  }

  /**
    * Generate a key pair with private and public key using 1024 bytes.
    */
  def generateKeyPair(): KeyPair = {
    val keyPairGenerator = KeyPairGenerator.getInstance(RSA)
    keyPairGenerator.initialize(KEY_SIZE)
    keyPairGenerator.generateKeyPair
  }

  /**
    * Encrypt a String using a public or private key.
    */
  def encrypt(text: String, key: Key): Array[Byte] = {
    val cipher = Cipher.getInstance(RSA)
    cipher.init(Cipher.ENCRYPT_MODE, key)
    cipher.doFinal(text.getBytes(UTF_8))
  }

  /**
    * Decrypt a String using a private or public key.
    */
  def decrypt(text: Array[Byte], key: Key): String = {
    val cipher = Cipher.getInstance(RSA)
    cipher.init(Cipher.DECRYPT_MODE, key)
    new String(cipher.doFinal(text), UTF_8)
  }

  /**
    * Sign a String.
    */
  def sign(text: String, privateKey: PrivateKey): String = {
    val signatureUtil = Signature.getInstance(SHA256_RSA)
    signatureUtil.initSign(privateKey)
    signatureUtil.update(text.getBytes(UTF_8))
    val signatureBytes = signatureUtil.sign
    Base64.getEncoder.encodeToString(signatureBytes)
  }

  /**
    * Verify a signature.
    */
  def verify(text: String, signature: String, publicKey: PublicKey): Boolean = {
    val signatureUtil = Signature.getInstance(SHA256_RSA)
    signatureUtil.initVerify(publicKey)
    signatureUtil.update(text.getBytes(UTF_8))
    val signatureBytes = Base64.getDecoder.decode(signature)
    signatureUtil.verify(signatureBytes)
  }

}
