"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[640],{640:function(s,e,t){t.r(e),t.d(e,{default:function(){return F}});var o=t(252),r=t(963);const n={class:"m-5 p-4"},l=(0,o._)("div",{class:"p-3 text-center"},[(0,o._)("h1",null,"ユーザーID ログイン")],-1),a={class:"border border-secondary rounded p-3 mx-auto",style:{width:"30em"}},i={class:"row g-3 needs-validation",novalidate:""},d={key:0,class:"bg-danger bg-gradient text-white"},u=(0,o.Uk)(" 入力内容に誤りがあります。"),c=(0,o._)("br",null,null,-1),p=(0,o.Uk)(" ユーザIDとパスワードを入力しなおしてください。 "),g=[u,c,p],h=(0,o._)("label",{for:"userIdForm",class:"form-label"},"ユーザーID",-1),m=(0,o._)("label",{for:"passwordForm",class:"form-label"},"パスワード",-1),b=(0,o._)("br",null,null,-1),w={class:"text-center"},v={class:"mt-5 text-center"};function f(s,e,t,u,c,p){return(0,o.wg)(),(0,o.iD)("div",n,[l,(0,o._)("div",a,[(0,o._)("form",i,[c.loginFailed?((0,o.wg)(),(0,o.iD)("div",d,g)):(0,o.kq)("",!0),(0,o._)("div",null,[h,(0,o.wy)((0,o._)("input",{class:"form-control","onUpdate:modelValue":e[0]||(e[0]=s=>c.userId=s),type:"text",id:"userIdForm",required:""},null,512),[[r.nr,c.userId]])]),(0,o._)("div",null,[m,b,(0,o.wy)((0,o._)("input",{class:"form-control","onUpdate:modelValue":e[1]||(e[1]=s=>c.password=s),type:"password",id:"passwordForm",required:""},null,512),[[r.nr,c.password]])]),(0,o._)("div",w,[(0,o._)("button",{class:"btn btn-success",onClick:e[2]||(e[2]=(...s)=>p.login&&p.login(...s))},"ログイン")])])]),(0,o._)("div",v,[(0,o._)("button",{class:"btn btn-success w-50",onClick:e[3]||(e[3]=(...s)=>p.signup&&p.signup(...s))},"新規登録はこちらから")])])}var _=t(196);_.Z.defaults.headers.post["Access-Control-Allow-Origin"]="*";var I={name:"LoginForm",data(){return{userId:"",password:"",loginFailed:!1}},methods:{login(){let s=this.userId,e=this.password;const t=this,o={responseType:"blob"};_.Z.get("/index/login",{params:{userId:s,password:e}},o).then((s=>{console.log(s.data),t.init(s.data)})).catch((s=>{alert("ログインエラーが発生しました"),console.log(s)}))},init(s){let e=s.userName,t=s.companyMemo;console.log(s),console.log(e),console.log(t),this.$store.dispatch("userLogin/saveUserId",this.userId),this.$store.dispatch("jobList/saveUserName",e),this.$store.dispatch("jobList/saveJList",t);let o=this.$store.getters["jobList/getUserName"];""==o?this.loginFailed=!0:(this.$store.dispatch("userLogin/changeIsLogged"),this.$router.push({name:"HomeView"}))},signup(){this.$router.push({name:"SignUp"})}}},k=t(744);const y=(0,k.Z)(I,[["render",f]]);var F=y}}]);
//# sourceMappingURL=640.41098fe3.js.map