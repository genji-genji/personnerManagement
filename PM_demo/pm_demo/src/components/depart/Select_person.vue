<template>
<div class="re_c">
    <h2>输入人员编号</h2>
    <el-input v-model="input" placeholder="人员编号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="Re">搜索</el-button>
</div>

</template>

<script>
export default {
    name:"Depart_re",
    data(){
        return{
            input:''
        }
    },
    methods:{
        Re(){
            console.log('16531')
            this.$router.push("/Person_news");
        }

    }
}
</script>

<style lang="less" scoped>
.re_c{
    width: 50%;
    transform: translate(50%,50%);
}

</style>
