<template>
    <b-card :title='getBlockName()' :sub-title="getSubTitle()">
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
          <b-form-input :state="null" readonly class="back" :value="blockData.parentHash"></b-form-input>
        </b-input-group>
      </b-card-text>
      <b-card-text>
        <b-input-group prepend="HASH">
          <b-form-input :state="blockData.workProven ? true : false" readonly class="back" :value="blockData.hash"></b-form-input>
        </b-input-group> 
      </b-card-text>
      <b-button v-show="!blockData.workProven" pill variant="info" @click="mineBlock()">Mine</b-button> 
    </b-card>
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
    getSubTitle(){
      const timeStamp = new Date(this.$props.blockData.timeStamp)
      const formatted = new Intl.DateTimeFormat('en-US', { dateStyle: 'full', timeStyle: 'long' }).format(timeStamp)
      return `created on ${formatted}`
    },
    getBlockName(){
      return `Block ${this.$props.blockName}`
    },
    mineBlock(){
      const {id, parentHash, hash} = this.$props.blockData
      this.$store.dispatch('mineBlock',{id, parentHash, hash, data: this.data})
    },

    updateBlock(){
      const {id, parentHash, hash} = this.$props.blockData
      this.$store.dispatch('updateBlock',{
         data: this.data,
         id,
         hash,
         parentHash
         })
    },
  }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>