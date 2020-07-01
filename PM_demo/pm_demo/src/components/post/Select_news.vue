<template>
    <el-table
    :data="staffList"
    border
    style="width: 100%">
    <el-table-column
      prop="sid"
      label="员工号"
      width="180">
    </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="sex"
        label="性别"
        width="180">
      </el-table-column>
      <el-table-column
        prop="BIRTHDAY"
        label="生日"
        width="180">
      </el-table-column>
      <el-table-column
        prop="origin_name"
        label="来源"
        width="180">
      </el-table-column>

    <el-table-column
      prop="job_name"
      label="岗位名称"
      width="180">
    </el-table-column>

<!--    <el-table-column-->
<!--      prop=""-->
<!--      label="岗位编号"-->
<!--      width="180">-->
<!--    </el-table-column>-->
<!--     <el-table-column-->
<!--      prop="post_type"-->
<!--      label="岗位类型"-->
<!--      width="180">-->
<!--    </el-table-column>-->
  </el-table>
</template>

<script>
import {getRequest} from "../../uitls/api";

export default {

  mounted:function(){
    this.job_id=this.$route.params.job_id;
    console.log(this.job_id);

    let url=this.rootUrl+"/job/selectStaffByJob?job_id="+this.job_id;
    getRequest(url).then(back=>{
      this.staffList=back.data;
    })



  },


     data() {
      return {
        job_id:null,

        staffList:[],

        tableData: [{
          num: '1',
          name: '王小虎',
          post_num:155,
          post_name:'行政主管',
          post_type:'正式编制'
        }]
      }
    }
}
</script>

<style lang="less" scoped>

</style>
