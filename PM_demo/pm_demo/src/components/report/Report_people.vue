<template>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="date"
      label="部门名称"
      width="150">
    </el-table-column>
    <el-table-column label="人数统计">
      <el-table-column
        prop="num_start"
        label="月初人数"
        width="120">
      </el-table-column>
      <!-- <el-table-column label="地址"> -->
        <el-table-column
          prop="num_end"
          label="月末人数"
          width="120">
        </el-table-column>
        <el-table-column
          prop="num_new"
          label="本月新入职"
          width="120">
        </el-table-column>
        <el-table-column
          prop="num_leave"
          label="本月离职人数"
          width="300">
        </el-table-column>
        <el-table-column
          prop="num_in"
          label="本月调入"
          width="120">
        </el-table-column>
        <el-table-column
          prop="num_out"
          label="本月调出"
          width="120">
        </el-table-column>
      </el-table-column>
    <!-- </el-table-column> -->
    <el-table-column label="学历统计">
      <el-table-column
        prop="edu_1"
        label="研究生"
        width="120">
      </el-table-column>
      <!-- <el-table-column label="地址"> -->
        <el-table-column
          prop="edu_2"
          label="本科"
          width="120">
        </el-table-column>
        <el-table-column
          prop="edu_3"
          label="大专"
          width="120">
        </el-table-column>
        <el-table-column
          prop="edu_4"
          label="高中及以下"
          width="300">
        </el-table-column>
      </el-table-column>
    <!-- </el-table-column> -->
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '秘书处',
          num_start: 50,
          num_end: 50,
          num_new: 100,
          num_leave: 100,
          num_in: 500,
          num_out:1000,
          edu_1:100,
          edu_2:600,
          edu_3:400,
          edu_4:600
        }]
      }
    }
  }
</script>

<style lang="less" scoped>

</style>