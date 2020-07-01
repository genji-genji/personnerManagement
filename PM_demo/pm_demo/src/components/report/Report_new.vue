<template>
    <el-table
    :data="staffList"
    height="250"
    border
    style="width: 100%">
    <el-table-column
      prop="sid"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="department_name"
      label="部门名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="job_name"
      label="岗位名称">
    </el-table-column>
    <el-table-column
      prop="name"
      label="名称">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别">
    </el-table-column>
    <el-table-column
      prop="START_TIME"
      label="入职日期">
    </el-table-column>
<!--    <el-table-column-->
<!--      prop="edu"-->
<!--      label="学历">-->
<!--    </el-table-column>-->
  </el-table>
</template>

<script>
import {getRequest} from "../../uitls/api";

export default {

  mounted:function () {

    let url=this.rootUrl +"/staff/getNewStaffList";

    getRequest(url).then(back=>{

      this.staffList=back.data

    })

  },

  data(){
        return{

          staffList:[],

            tableData:[
                {
                    num:'1',
                    name_dep:'秘书处',
                    name_post:'总裁',
                    name:'老王',
                    sex:'男',
                    date_in:'2020.6.6',
                    edu:'博士'
                }
            ]
        }
    }
}
</script>

<style lang="less" scoped>

</style>
