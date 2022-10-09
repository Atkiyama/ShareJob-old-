<template>
    <div class="m-5 p-4 text-center">
        <div class="p-3">
            <h1>ログアウト</h1><br/>
            <h5>本当にログアウトしますか？</h5>
        </div>
        <div class="d-grid gap-2 d-md-block mx-auto mt-3">
            <button class="btn btn-danger me-3" v-on:click="logout">ログアウト</button>
            <button class="btn btn-secondary" v-on:click="cancel">キャンセル</button>
        </div>
    </div>
</template>
<script>
export default{
    name:'LogoutView',
    data(){
        return{};
    },
    methods:{
        logout(){
            this.$store.dispatch("userLogin/saveUserId","");
            this.$store.dispatch("userLogin/changeIsLogged");
            this.$router.push({name:'TopView'});
        },
        cancel(){
            this.$router.push({name:'HomeView'});
        }
    }
}
</script>