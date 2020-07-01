<template>
   <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

      <el-table-column prop="post_num" label="编号" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.post_num" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.post_num}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="post_name" label="名称" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.post_name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.post_name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

        <el-table-column prop="type" label="类型">
          <template slot-scope="scope">
          <el-select v-model="scope.row.value" placeholder="请选择">
            <el-option
             v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
　　　　　　<el-button type="info" @click="modifyUser(scope.row.column)">新建</el-button>
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
       post_num: "1",
       isOK: true,
       post_name: "张三",
       post_type: "上海市普陀区金沙江路 1518 弄",
     }],
     options:[{
       value:1,
       label:"管理",
     },
     {
       value:2,
       label:"技术"
     },
     {
       value:3,
       label:"营销"
     },
     {
       value:4,
       label:"市场"
     }
     ]
      }
    }
}


</script>

<style lang="less" scoped>

</style>