<template>
    <div class=".container">
        <div class="p-3 mb-3">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr class="table-active">
                        <th width="35%">企業名</th>
                        <th width="65%">メモ</th>
                    </tr>
                    <tr v-for="(arr,index) in array" :key=index>
                        <td>{{arr.name}}</td>
                        <td>{{arr.memo}}</td>
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