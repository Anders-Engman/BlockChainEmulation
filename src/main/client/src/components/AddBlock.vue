<template>
  <b-card title="Add A BLOCK" variant="light">
      <b-card-text>
        <b-input-group prepend="Data">
            <b-form-input
              type="text"
              v-model="data"
            ></b-form-input>
          </b-input-group>     
      </b-card-text>
      <b-button type="submit" variant="outline-primary" @click="addBlock()">ADD</b-button>
  </b-card>
</template>
  

<script>

export default {
  name: "AddBlock",
  data() {
    return {
      data: '',
    }
  },
  methods:{
    addBlock(){
      const blockDataList = this.$store.state.blockDataList
      const parentBlock = blockDataList[blockDataList.length-1];
      const parentHash = parentBlock.hash 
      const id = parentBlock.id + 1

      this.$store.dispatch('addBlock',{data:this.data, parentHash:parentHash, id })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>