import { createStore } from 'vuex';

/* modules */
import userLogin from "./userLogin";
import jobList from "./jobList";

const store=new createStore({
  modules:{
    userLogin,
    jobList,
  }
});

export default store;