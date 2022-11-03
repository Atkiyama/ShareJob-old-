<template>
    <div class="home">
        <div class="p-3">
            <h2>{{userName}} 様</h2>
        </div>
        <JobList :array="result"/>
    </div>
</template>

<script>
import JobList from '../components/JobList.vue';

// Test for nonLoginDemo (import axios library)
import axios from 'axios';
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

export default {
    name: "HomeView",
    data() {
        return {
            userName:"",
            items: null,
            result: null
        };
    },
    mounted() {
        const isLogged = this.$store.getters["userLogin/getIsLogged"];
        if (!isLogged) {
            this.$router.push({ name: "LoginForm" })
        }

        // Test for nonLoginDemo
        let getUserId = this.$store.getters["userLogin/getUserId"];
        const vue = this;//important
        const option={responseType: "blob"};
        axios.get('/index/login',{
            params:{
                userId:getUserId,
                password:'id1'
            }
        },option).then(response=>{
            response.data.text().then(str=>{vue.testInit(str);});
        }).catch(err=>{
            alert("ログインエラーが発生しました");
            console.log(err);
        });

        /*
        // get userName & jobList from ../store/jobList/index.js
        const vue = this;
        vue.init();
        */
    },
    methods: {
        testInit(str) {// Method for nonLoginDemo Test
            // register userName & jobList
            let name=JSON.parse(str).userName;
            let jlist=JSON.parse(str).items;
            //console.log(JSON.parse(str).items);
            this.$store.dispatch("jobList/saveUserName",name);
            this.$store.dispatch("jobList/saveJList",jlist);
            this.init();
        },
        init() {
            // Load userName & jobList registed
            this.userName=this.$store.getters["jobList/getUserName"];
            this.items=this.$store.getters["jobList/getJList"];
            this.reset();
        },
        reset() {
            this.result = this.items;
        }
    },
    components: { JobList }
}
</script>
