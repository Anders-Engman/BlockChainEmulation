<template>
  <div>
    <b-card :title='getBlockName()'>
      <b-card-text>
          <b-input-group prepend="Data">
              <b-form-input
                type="text"
                v-model="data"
                v-on:input="updateBlock()"
              ></b-form-input>
            </b-input-group>  
      </b-card-text>
      <b-card-text>
        <b-input-group prepend="PREVIOUS HASH">
          <b-form-input :state="null" readonly class="back" :value="blockData.previousHash"></b-form-input>
        </b-input-group>
      </b-card-text>
      <b-card-text>
        <b-input-group prepend="HASH">
          <b-form-input :state="blockData.workProven ? true : false" readonly class="back" :value="blockData.hash"></b-form-input>
        </b-input-group> 
      </b-card-text> 
      <h4><b-badge>{{ blockData.nonce }}</b-badge></h4>
      <b-button variant="info" @click="mineBlock()">Mine</b-button> 
    </b-card>
  </div>
</template>
  

<script>

export default {
  name: "Block",
  props: {
    "blockName": Number,
    "blockData": Object
  },
  data(){
    return {
      data: this.blockData.data
    }
  },


  methods:{
    getBlockName(){
      return `Block ${this.$props.blockName}`
    },
    mineBlock(){
      this.$store.dispatch('mineBlock',{hash:this.$props.blockData.hash})
    },

    updateBlock(){
      this.$store.dispatch('updateBlock',{
         data: this.data,
         hash: this.$props.blockData.hash,
         })
    },
  }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>