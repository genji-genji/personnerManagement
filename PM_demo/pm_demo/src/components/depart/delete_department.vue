<template>
  <div class="re_c">
    <h2>删除部门</h2>
    <el-input v-model="department_id" placeholder="输入删除部门号"></el-input>
    <el-button type="primary" icon="el-icon-search" @click="quit">删除</el-button>
  </div>

</template>

<script>
    export default {
        name: "delete_department",

      data(){
          return {
            department_Id: null,
          }
      }
    }

</script>

<style lang="less" scoped>

</style>
