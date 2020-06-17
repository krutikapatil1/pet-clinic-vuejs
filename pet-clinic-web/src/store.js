import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import {router} from './main';

Vue.use(Vuex);
Vue.config.devtools = true;

export default new Vuex.Store({
    state: {
        ownersSearchResults: [],
        selectedOwner: {}
    },
    mutations: {
        'LOAD_OWNERS_SEARCH_RESULTS': (state, payload) => {
            state.ownersSearchResults = payload;
            if (state.ownersSearchResults.length > 1) {
                router.push({path: '/owners/listView'});
            }
            else if (state.ownersSearchResults.length == 1) {
                state.selectedOwner = payload[0];
                router.push({path: '/owners/detailView'});
            }
            else {
                router.push({path: '/owners'});
            }
        },
        'SET_SELECTED_OWNER': (state, payload) => {
            state.selectedOwner = payload;
            router.push({path: '/owners/detailView'});
        },
        'ADD_OWNER': (state, payload) => {
            state.selectedOwner = payload;
            router.push({path: '/owners/detailView'});
        },
        'RESET_DATA': (state) => {
            state.ownersSearchResults = [];
            state.selectedOwner = {};
        }
    },
    actions: {
        loadOwnersSearchResults: ({commit}, searchStr) => {
            axios.get('/owners/findAllByLastNameLike/' +searchStr).then(res => {
                console.log(res.data);
                commit('LOAD_OWNERS_SEARCH_RESULTS', res.data);
            })
        },
        setSelectedOwner: ({commit}, payload) => {
            commit('SET_SELECTED_OWNER', payload);
        },
        addUpdateOwner: ({commit}, payload) => {
            axios.put('/owners/addOwner', payload).then(res => {
                console.log(res.data);
                commit('ADD_OWNER', res.data);
            }).catch(error => {
                console.log(error);
            })

        },
        resetData: ({commit}) => {
            commit('RESET_DATA');
        }
    },
    getters: {
        ownersSearchResults: (state) => {
            return state.ownersSearchResults;
        },
        selectedOwner: (state) => {
            return state.selectedOwner;
        }
    }
})