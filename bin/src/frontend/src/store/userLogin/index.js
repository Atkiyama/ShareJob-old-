/**
 * management userId and isLogged
 */
const state={
    userId:"",
    isLogged:false
};

const getters={
    getUserId(state){
        return state.userId;
    },
    getIsLogged(state){
        return state.isLogged;
    }
};

const mutations={
    saveUserId(state,userId){
        state.userId=userId;
    },
    removeUserId(state){
        state.userId="";
    },
    changeIsLogged(state){
        state.isLogged=!state.isLogged;
    }
};

const actions={
    saveUserId({commit},userId){
        commit("saveUserId",userId);
    },
    removeUserId({commit}){
        commit("removeUserId");
    },
    changeIsLogged({commit}){
        commit("changeIsLogged");
    }
};

const userLogin={
    namespaced:true,//important
    state,
    getters,
    actions,
    mutations
};

export default userLogin;