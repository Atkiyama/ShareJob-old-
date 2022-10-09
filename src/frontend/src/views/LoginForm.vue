<template>
    <div class="m-5 p-4">
        <div class="p-3 text-center">
            <h1>ユーザーID ログイン</h1>
        </div>
        <div class="border border-secondary rounded p-3 mx-auto" style="width:30em">
            <form class="row g-3 needs-validation" novalidate>
            <div class="bg-danger bg-gradient text-white" v-if="loginFailed">
                入力内容に誤りがあります。
                ユーザIDとパスワードを入力しなおしてください。
            </div>
            <div>
                <label for="userIdForm" class="form-label">ユーザーID</label>
                <input class="form-control" v-model="userId" type="text" id="userIdForm" required>
                <div class="invalid-feedback">正しいユーザーIDを入力してください</div>
            </div>
            <div>
                <label for="passwordForm" class="form-label">パスワード</label><br/>
                <input class="form-control" v-model="password" type="password" id="passwordForm" required>
                <div class="invalid-feedback">正しいパスワードを入力してください</div>
            </div>
            <div class="text-center">
                <button class="btn btn-success" v-on:click="login">ログイン</button>
            </div>
            </form>
        </div>
        <div class="mt-5 text-center">
            <button class="btn btn-success w-50" v-on:click="signup">新規登録はこちらから</button>
        </div>
    </div>
</template>

<script>
import * as axios from 'axios'

export default{
    name: 'LoginForm',
    data(){
        return {
            userId:"",
            password:"",
            loginFailed:false
        };
    },
    methods:{
        login(){
            //ToDo:P_URLをbackのログイン管理APIにget request送るためのurlに書き換える
            let P_URL="https://script.google.com/macros/s/AKfycbwzOKNeN4csEdR0A--YJzNZ0v60m89ZiDzpbDdz-CFQFDjSdvCRBKg5o0zr4Mz1oDXuhw/exec";
            P_URL=P_URL+"?userId="+this.userId+"&password="+this.password;
            const vue = this;//important
            const option={responseType: "blob"};
            axios.get(P_URL,option).then(response=>{
                response.data.text().then(str=>{vue.init(str);});
            }).catch(e=>{
                alert("ログインエラーが発生しました");
                console.log(e);
            });
        },
        init(str){
            let res=JSON.parse(str).judge;
            //console.log(JSON.parse(str).judge);
            if(res=="true"){//認証成功
                this.$store.dispatch("userLogin/saveUserId",this.userId);
                this.$store.dispatch("userLogin/changeIsLogged");
                this.$router.push({name:'HomeView'});
            }else{//認証失敗
                this.loginFailed=true;
            }
        },
        signup(){
            this.$router.push({name:'SignUp'});
        }
    }
}
</script>
