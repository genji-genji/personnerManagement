<template>
  <div class="re_c">
    <h2>删除岗位</h2>
    <el-input v-model="job_id" placeholder="输入删除岗位号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="quit">删除</el-button>
  </div>

</template>
<script>
  import {deleteRequest, getRequest, postRequest} from "../../uitls/api";

  export default {
    mounted:function () {

    },
    methods:{

      quit(){
        let url_1=this.rootUrl+"/job/deleteJob?job_id="+this.job_id;
        deleteRequest(url_1).then(back=>{
          let backDate = back.data;
          this.$alert(backDate.message, backDate.result);
        })
      }

    },


    data() {
      return {
        job_id:null,
      }
    }
  }
</script>


<style lang="less" scoped>

</style>
