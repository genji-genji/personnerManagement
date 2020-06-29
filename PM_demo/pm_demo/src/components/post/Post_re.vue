<template>
<div class="re_c">
    <h2>输入岗位编号</h2>
    <el-input v-model="input" placeholder="岗位编号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="Re">搜索</el-button>
</div>
    
</template>

<script>
export default {
    name:"Depart_re",
    data(){
        return{
            input:'123'
        }
    },
    methods:{
        Re(){
            console.log('16531')
            this.$router.push("/Post_re_rel");
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