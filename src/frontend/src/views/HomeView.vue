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
        /*
        const getUserId = this.$store.getters["userLogin/getUserId"];
        //ToDo:G_URLをbackの仕事情報管理APIにget request送るためのurlに書き換える
        let G_URL="https://script.google.com/macros/s/AKfycbzCcVLeQuaxhdV1c_9IpxY7lYaR0v35uTReyicBzDvhHMTElM04G4JtzOs45zQ_LGyY/exec";
        G_URL=G_URL+"?userId="+getUserId;
        const vue = this;//important
        const option={responseType: "blob"};
        axios.get(G_URL,option).then(response => {
            response.data.text().then(str => { vue.init(str);});
        }).catch(e => {
            alert("エラーが発生しました");
            console.log(e);
        });
        */
        const vue = this;
        vue.init();
    },
    methods: {
        init() {
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
