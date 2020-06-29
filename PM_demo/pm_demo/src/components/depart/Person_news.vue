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
      prop="sex"
      label="性别">
    </el-table-column>
    <el-table-column
      prop="date"
      label="出生日期">
    </el-table-column>
    <el-table-column
      prop="ID"
      label="身份证号">
    </el-table-column>
    <el-table-column
      prop="dep"
      label="部门">
    </el-table-column>
    <el-table-column
      prop="date_in"
      label="入职日期">
    </el-table-column>
    <el-table-column
      prop="date_work"
      label="工作日期">
    </el-table-column>
    <el-table-column
      prop="type_work"
      label="工作形式">
    </el-table-column>
    <el-table-column
      prop="address"
      label="人员来源">
    </el-table-column>
    <el-table-column
      prop="text_start"
      label="试用期开始日期">
    </el-table-column>
    <el-table-column
      prop="text_end"
      label="试用期结束日期">
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
          sex: '上man',
          date:'2020.8.8',
          ID:'1561',
          dep:'秘书处',
          date_in:'2020.1.1',
          date_work:'2020.3.3',
          type_work:'正式职工',
          address:'云南',
          text_start:'2020.5.5',
          text_end:'20206.6'
        }]
      }
    }
}
</script>

<style lang="less" scoped>
    
</style>