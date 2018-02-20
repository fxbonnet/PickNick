import org.specs2.mutable.Specification

class BlockTest extends Specification{

  "This test" should {
    "test the functionality of block hash" in {
      val genesisBlock = Block.createBlock("0", "Genesis block")
      val block = Block.createBlock(genesisBlock.hash, "Block 1")
      val block2 = Block.createBlock(block.hash, "Block 2")
      block.previousHash shouldEqual genesisBlock.hash
      block2.previousHash shouldEqual block.hash
    }
  }
}