"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[549],{549:function(s,e,r){r.r(e),r.d(e,{default:function(){return y}});var n=r(252),l=r(963);const o={class:"m-5 p-4"},t=(0,n._)("div",{class:"p-3 text-center"},[(0,n._)("h1",null,"アカウント 新規作成")],-1),a={class:"border border-secondary rounded p-3 mx-auto",style:{width:"30em"}},d={class:"row g-3 needs-validation",novalidate:""},i={key:0,class:"bg-danger bg-gradient text-white"},u=(0,n.Uk)(" 入力内容に誤りがあります。"),c=(0,n._)("br",null,null,-1),p=(0,n.Uk)(" ユーザIDとパスワードを入力しなおしてください。 "),m=[u,c,p],w=(0,n._)("label",{for:"userIdForm",class:"form-label"},"ユーザーID",-1),g=(0,n._)("label",{for:"passwordForm",class:"form-label"},"パスワード",-1),b=(0,n._)("br",null,null,-1),f={class:"mt-5 text-center"};function h(s,e,r,u,c,p){return(0,n.wg)(),(0,n.iD)("div",o,[t,(0,n._)("div",a,[(0,n._)("form",d,[c.loginFailed?((0,n.wg)(),(0,n.iD)("div",i,m)):(0,n.kq)("",!0),(0,n._)("div",null,[w,(0,n.wy)((0,n._)("input",{class:"form-control","onUpdate:modelValue":e[0]||(e[0]=s=>c.userId=s),type:"text",id:"userIdForm",required:""},null,512),[[l.nr,c.userId]])]),(0,n._)("div",null,[g,b,(0,n.wy)((0,n._)("input",{class:"form-control","onUpdate:modelValue":e[1]||(e[1]=s=>c.password=s),type:"password",id:"passwordForm",required:""},null,512),[[l.nr,c.password]])])]),(0,n._)("div",f,[(0,n._)("button",{class:"btn btn-success w-50",onClick:e[2]||(e[2]=(...s)=>p.signup&&p.signup(...s))},"新規作成")])])])}var _=r(196);_.Z.defaults.headers.post["Access-Control-Allow-Origin"]="*";var v={name:"SignupForm",data(){return{userId:"",password:"",loginFailed:!1}},methods:{signup(){let s=this.userId,e=this.password;const r=this,n={responseType:"blob"};_.Z.get("/index/login",{params:{userId:s,password:e}},n).then((s=>{console.log(s.data),r.init(s.data)})).catch((s=>{alert("アカウント作成時にエラーが発生しました"),console.log(s)})),this.$router.push({name:"showLoginInfo"})}}},I=r(744);const k=(0,I.Z)(v,[["render",h]]);var y=k}}]);
//# sourceMappingURL=549.84dab5db.js.map