<template>
  <div>
    <div v-for="(block, index) in blockDataList" :key="index">
      <Block :blockName="index" :blockData="block"/>
    </div>
    <AddBlock/>
    

  </div>
</template>



<script>
import Block from "../components/Block.vue"
import AddBlock from "../components/AddBlock.vue"

export default {
  name: "BlockChain",
  components: {
    Block,
    AddBlock
  },
  created() {
    this.$store.dispatch('loadBlocks')
  },
  computed: {
    blockDataList () {
      return this.$store.state.blockDataList
    }
  },
  methods:{
    },
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>

