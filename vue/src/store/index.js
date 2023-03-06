import { createStore } from 'vuex'

export default createStore({
  state: {
    id:'',
    name:'',
    password:'',
    account:'',
    address:'',
    email:''
  },
  getters: {
  },
  mutations: {
    set(state,formData){
      state.id=formData.id;
      state.name=formData.name;
      state.password=formData.password;
      state.account=formData.account;
      state.address=formData.address;
      state.email=formData.email;
    },
    clean(state){
      state.id='';
      state.name='';
      state.password='';
      state.account='';
      state.address='';
      state.email='';
    }

  },
  actions: {
  },
  modules: {
  }
})
