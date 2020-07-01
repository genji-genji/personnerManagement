<template>
<div class="re_c">
    <h2>输入岗位编号</h2>
    <el-input v-model="job_id" placeholder="岗位编号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="Re">搜索</el-button>
</div>

</template>

<script>
export default {
    name:"Depart_re",
    data(){
        return{
          job_id:"",
            input:'123'
        }
    },
    methods:{
        Re(){
            this.$router.push({
              name : 'Post_re_rel',
              params:{
                job_id:this.job_id,
              }
            })

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
