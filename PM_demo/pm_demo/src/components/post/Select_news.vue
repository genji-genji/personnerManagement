<template>
    <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="num"
      label="员工号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="post_name"
      label="岗位名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="post_num"
      label="岗位编号"
      width="180">
    </el-table-column>
     <el-table-column
      prop="post_type"
      label="岗位类型"
      width="180">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
     data() {
      return {
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