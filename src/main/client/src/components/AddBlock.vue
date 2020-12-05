<template>
  <div>
    <b-card variant="light">
        <b-card-text>
          <b-input-group prepend="Data">
              <b-form-input
                type="text"
                v-model="data"
              ></b-form-input>
            </b-input-group>     
        </b-card-text>
        <b-button type="submit" variant="outline-primary" @click="addBlock()">Add Block</b-button>
    </b-card>
  </div>
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
      this.$store.dispatch('addBlock',{data:this.data})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>