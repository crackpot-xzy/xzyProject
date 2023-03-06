import { createStore } from 'vuex'

export default createStore({
  state: {
    userId:'',
  },
  getters: {
  },
  mutations: {
    set(state,id){
      state.userId=id;
    },
    clean(state){
      state.userId='';
    }

  },
  actions: {
  },
  modules: {
  }
})
