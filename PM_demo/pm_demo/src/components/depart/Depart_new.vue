<template>
<el-table
    :data="tableData"
    height="250"
    border
    style="width: 100%">
    <el-table-column
      prop="name"
      label="名称"
      width="180">
    </el-table-column>
    <el-table-column
      prop="desc"
      label="描述"
      width="180">
    </el-table-column>
    <el-table-column
      prop="choose"
      label="是否必须">
    </el-table-column>
  </el-table> 
</template>

<script>
export default {
    data(){
        return {
            tableData:[{
                name:'老何',
                desc:'秘书处',
                choose:'是'
            }]
        }
    }
    
}
</script>

<style lang="less" scoped>

</style>