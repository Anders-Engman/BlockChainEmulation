<template>
  <div class="blockChain"> 
    <div class="blockWrapper" v-for="(block, index) in blocks" :key="index">
      <div class="block">
        <Block :blockName="index" :blockData="block"/>
      </div>
    </div>
  </div>
</template>



<script>

import Block from "../components/Block.vue"

export default {
  name: "BlockChain",
  components: {
    Block
  },

  created() {
    this.$store.dispatch('loadBlocks')
  },
  computed: {
    blocks(){
      console.warn(this.$store.getters.blockDataList)
      return this.$store.getters.blockDataList
    },
  },  
  methods:{

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>

