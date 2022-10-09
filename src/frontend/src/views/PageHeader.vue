<template>
    <header>
        <nav class="navbar navbar-expand-lg bg-success">
            <div class="container-fluid mt-2">
                <div class="d-flex ms-auto">
                    <p v-if="checkIsLogged()">
                        <router-link to="/home" class="btn btn-outline-light me-3">ホーム</router-link>
                        <router-link to="/profile" class="btn btn-outline-light me-3">プロフィール</router-link>
                        <router-link to="/logout" class="btn btn-outline-light flex-shrink-0">ログアウト</router-link>
                    </p>
                    <p v-else>
                        <router-link to="/login" class="btn btn-outline-light flex-shrink-0">ログイン / 新規登録</router-link>
                    </p>
                </div>
            </div>
        </nav>
    </header>
</template>

<script>
export default {
    data () {
        return {
            title: "PageHeader"
        }
    },
    created(){
        this.checkIsLogged();
    },
    methods:{
        checkIsLogged(){
            let isLogged=this.$store.getters["userLogin/getIsLogged"];
            if(isLogged){
                return true;
            }else{
                return false;
            }
        }
    }
}
</script>
