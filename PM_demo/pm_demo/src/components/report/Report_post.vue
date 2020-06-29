<template>
    <el-table
    :data="tableData"
    height="250"
    border
    style="width: 100%">
    <el-table-column
      prop="num"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name_dep"
      label="部门名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name_old"
      label="原岗位名称">
    </el-table-column>
    <el-table-column
      prop="name_new"
      label="新岗位名称">
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
      prop="date_in"
      label="调动日期">
    </el-table-column>
    <el-table-column
      prop="why"
      label="调动原因">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
    data(){
        return{
            tableData:[
                {
                    num:'1',
                    name_dep:'秘书处',
                    name_new:'科长',
                    name_old:'干事',
                    name:'老王',
                    sex:'男',
                    date_in:'2020.6.6',
                    why:'博士'
                }
            ]
        }
    }
}
</script>

<style lang="less" scoped>

</style>