<template>
  <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

      <el-table-column prop="num" label="编号" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.num" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.num}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="type" label="类型">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.type" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.type}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>


      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
　　　　　　<el-button type="info" @click="modifyUser(scope.row.phone)">修改</el-button>
　　　　</template>
　　</el-table-column>
    </el-table>
</template>

<script>
export default {
     methods: {
      dbclick(row, event, column){
      row.isOK =!row.isOK
    }
    },

    data() {
      return {
       tableData: [
     {
       num: "1",
       isOK: true,
       name: "张三",
       type: "上海市普陀区金沙江路 1518 弄",
     }]
      }
    }
}

</script>

<style lang="less" scoped>

</style>