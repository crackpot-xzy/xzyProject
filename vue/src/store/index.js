import { createStore } from 'vuex'

export default createStore({
  state: {
    userId:'',
  },
  getters: {
  },
  mutations: {
    setId(state,id){
      state.userId=id;
    }

  },
  actions: {
  },
  modules: {
  }
})
