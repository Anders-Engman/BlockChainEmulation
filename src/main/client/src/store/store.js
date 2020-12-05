import Vuex from "vuex";
import Vue from "vue";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    blockDataList: [],
  },

  getters: {
    // Here we will create a getter
  },

  mutations: {
    loadBlocks(state, response) {
      state.blockDataList = response;
    },
  },

  actions: {
    loadBlocks({ commit }) {
      // call load api route

      commit("loadBlocks", [
        {
          data: "placeholder",
          previousHash: "0",
          hash: "osrrtme",
          nonce: 0,
          workProven: false,
        },
      ]);
    },
    addBlock({ commit }, { data }) {
      console.warn("data", data);

      // make create block api call

      commit("loadBlocks", [
        {
          data: "placeholder",
          previousHash: "0",
          hash: "osrrtme",
          nonce: 0,
          workProven: false,
        },
        {
          data,
          previousHash: "0",
          hash: "addBlock",
          nonce: 0,
          workProven: false,
        },
      ]);
    },
    mineBlock({ commit }, { hash }) {
      console.warn("hash", hash);

      // call mine api route

      commit("loadBlocks", [
        {
          data: "placeholder",
          previousHash: "0",
          hash: "mineBlock",
          nonce: 0,
          workProven: true,
        },
      ]);
    },
    updateBlock({ commit }, { data, hash }) {
      console.warn("data", data);
      console.warn("hash", hash);

      // call update api route

      commit("loadBlocks", [
        {
          data,
          previousHash: "0",
          hash: "updateBlock",
          nonce: 0,
          workProven: false,
        },
      ]);
    },
  },
  // Here we will create Larry
});
