<template>
  <div class="re_c">
    <h2>输入试用期员工id</h2>
    <el-input v-model="sid" placeholder="试用期员工id"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="Re">搜索</el-button>
  </div>

</template>

<script>
  export default {
    name:"Depart_re",
    data(){
      return{
        sid:"",
        input:'123'
      }
    },
    methods:{
      Re(){
        this.$router.push({
          name : 'Post_re_rel',
          params:{
            sid:this.sid,
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
