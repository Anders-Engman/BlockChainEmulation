<template>
  <div id="app">
    <BlockChainView />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import BlockChainView from './views/BlockChainView.vue'

export default {
  name: 'App',
  components: {
    BlockChainView
  }
}
</script>

<style>
  @import './assets/styles/global.css';
</style>