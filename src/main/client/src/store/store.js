import Vuex from "vuex";
import Vue from "vue";
import {
  getAllBlocks,
  createBlock,
  mineBlock,
  updateBlock,
} from "../services/BlockChainService.js";

Vue.use(Vuex);

const successStatus = 200 || 201;

export default new Vuex.Store({
  state: {
    blockDataList: [],
  },

  getters: {
    blockDataList: (state) => {
      return state.blockDataList;
    },
  },

  mutations: {
    loadBlocks(state, response) {
      state.blockDataList = response;
    },
  },

  actions: {
    async loadBlocks({ commit }) {
      const response = await getAllBlocks();

      if (response.status === successStatus) {
        commit("loadBlocks", response.body);
        console.log(response.body);
      } else {
        console.warn(response);
      }
    },
    async addBlock({ commit }, { data, parentHash, id }) {
      const success = await createBlock({ data, parentHash, id });

      if (success) {
        const response = await getAllBlocks();

        if (response.status === successStatus) {
          commit("loadBlocks", response.body);
        } else {
          console.warn(response);
        }
      } else {
        console.warn("Error");
      }
    },
    async mineBlock({ commit }, { id, parentHash, hash, data }) {
      const success = await mineBlock({ id, parentHash, hash, data });

      if (success) {
        const response = await getAllBlocks();

        if (response.status === successStatus) {
          commit("loadBlocks", response.body);
        } else {
          console.warn(response);
        }
      } else {
        console.warn("Error");
      }
    },
    async updateBlock({ commit }, { data, id, hash, parentHash }) {
      const success = await updateBlock({ data, id, hash, parentHash });

      if (success) {
        const response = await getAllBlocks();

        if (response.status === successStatus) {
          commit("loadBlocks", response.body);
        } else {
          console.warn(response);
        }
      } else {
        console.warn("Error");
      }
    },
  },
});
