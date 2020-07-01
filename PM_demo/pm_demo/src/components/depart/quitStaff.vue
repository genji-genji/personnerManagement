<template>
  <div class="re_c">
    <h2>员工离职</h2>
    <el-input v-model="staff_id" placeholder="输入离职员工号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="quit">删除</el-button>
  </div>

</template>
<script>
  import {getRequest, postRequest} from "../../uitls/api";

    export default {
      mounted:function () {

      },
      methods:{

        quit(){
          let url_1=this.rootUrl+"/staff/quitStaff?sid="+this.staff_id;
          postRequest(url_1).then(back=>{
            let backDate = back.data;
            this.$message(backDate.result, backDate.message);
          })
        }

      },


      data() {
        return {
          staff_id:null,
        }
      }
    }
</script>


<style lang="less" scoped>

</style>
