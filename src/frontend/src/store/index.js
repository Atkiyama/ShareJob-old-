import { createStore } from 'vuex';

/* modules */
import userLogin from "./userLogin";

const store=new createStore({
  modules:{
    userLogin
  }
});

export default store;