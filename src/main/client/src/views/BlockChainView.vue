<template>
  <div class="view">
    <AddBlock class="addBlock"/>
    <hr/>
    <BlockChain />
  </div>
</template>

<script>
import BlockChain from "../containers/BlockChain.vue"
import AddBlock from "../components/AddBlock.vue"

export default {
  name: "BlockChainView",
  components: {
    BlockChain,
    AddBlock
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

