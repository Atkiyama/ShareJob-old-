/**
 * management jobList
 */
const state={
    userName:"",
    jlist:[],
};

const getters={
    getUserName(state){
        return state.userName;
    },
    getJList(state){
        return state.jlist;
    }
};

const mutations={
    saveUserName(state,userName){
        state.userName=userName;
    },
    saveJList(state,jlist){
        state.jlist=jlist;
    },
    resetUserName(state){
        state.userName="";
    },
    resetJList(state){
        state.jlist=[];
    },
    checkJListNull(state){
        if (state.jlist==[]){
            return true;
        }else{
            return false;
        }
    }
};

const actions={
    saveUserName({commit},userName){
        commit("saveUserName",userName);
    },
    saveJList({commit},jlist){
        commit("saveJList",jlist);
    },
    resetUserName({commit}){
        commit("resetUserName");
    },
    resetJList({commit}){
        commit("resetJList");
    },
    checkJListNull({commit}){
        commit("checkJListNull");
    }
};

const jobList={
    namespaced:true,//important
    state,
    getters,
    actions,
    mutations
};

export default jobList;