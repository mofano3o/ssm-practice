import Vue from 'vue';
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)

const store = new Vuex.Store({
        plugins: [createPersistedState({
            storage: window.sessionStorage
        })],
        state: {
            user: {}
        },
        getters: {
            user: state => state.user
        },
        mutations: {
            login: ((state, payload) => {
                state.user = payload;
            })
        }
    }
)

export default store
