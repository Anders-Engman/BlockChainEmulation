<template>
  <div id="app">
    <BlockChain />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import BlockChain from './containers/BlockChain.vue'

export default {
  name: 'App',
  components: {
    BlockChain
  }
}
</script>

<style>
  @import './assets/styles/global.css';
</style>