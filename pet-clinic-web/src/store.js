import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);
Vue.config.devtools = true;

export default new Vuex.Store({
    state: {
        ownersSearchResults: []
    },
    mutations: {
        'LOAD_OWNERS_SEARCH_RESULTS': (state, payload) => {
            state.ownersSearchResults = payload;
        }
    },
    actions: {
        loadOwnersSearchResults: ({commit}, searchStr) => {
            axios.get('/owners/findAllByLastNameLike/' +searchStr).then(res => {
                console.log(res.data);
                commit('LOAD_OWNERS_SEARCH_RESULTS', res.data);
            })
        }
    },
    getters: {
        ownersSearchResults: (state) => {
            return state.ownersSearchResults;
        }
    }
})