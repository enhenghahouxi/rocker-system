import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
Vue.use(Vuex)
const state={
    hasgetlist:[],
    hasnotgetlist:[],
}

const mutations ={//改变
  GET_HASGETLIST(state,hasgetlist){
    state.hasgetlist=hasgetlist;
  },
  GET_HASNOTGETLIST(state,hasnotgetlist){
    state.hasnotgetlist=hasnotgetlist;
  }
}

const actions={
  GET_HASGETLIST({commit}){
    return new Promise((resolve,reject )=> {
      axios.get('/api/participant/selectAllHasGetPariticipant').then(response =>{
        commit('GET_HASGETLIST',response.data.data);
        resolve();
      })
    })
  },
  GET_HASNOTGETLIST({commit}){
    return new Promise((resolve,reject )=> {
      axios.get('/api/participant/selectAllHasNotGetPariticipant').then(response =>{
        commit('GET_HASNOTGETLIST',response.data.data);
        resolve();
      })
    })
  }
}

export  default  new Vuex.Store({
  state,
  mutations,
  actions,
})
