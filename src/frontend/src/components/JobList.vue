<template>
    <div class=".container">
        <div class="p-3 mb-3">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr class="table-active">
                        <th width="10%">仕事ID</th>
                        <th width="30%">仕事名</th>
                        <th width="20%">場所</th>
                        <th width="15%">受付開始</th>
                        <th width="15%">締切</th>
                    </tr>
                    <tr v-for="(arr,index) in array" :key=index>
                        <td>{{arr.id}}</td>
                        <td>{{arr.title}}</td>
                        <td>{{arr.place}}</td>
                        <td>{{arr.start}}</td>
                        <td>{{arr.rimit}}</td>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
</template>
<script>
export default ({
    props:['array'],
})
</script>