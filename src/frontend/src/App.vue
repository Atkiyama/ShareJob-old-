<template>
  <div id="app" class=".container">
    <PageHeader/>
    <router-view/>
  </div>
</template>

<script>
import PageHeader from './views/PageHeader.vue';

export default{
    name: "App",
    components: { PageHeader }
}
</script>

