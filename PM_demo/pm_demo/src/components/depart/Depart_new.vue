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

      

      <el-table-column prop="phone" label="电话">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.phone" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.phone}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="email" label="传真">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.email" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.email}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="date" label="成立日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.date" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.date}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
　　　　　　<el-button type="info" @click="modifyUser(scope.row.phone)">新建</el-button>
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
       phone:"1561564165",
       email:"@45949",
       date:"2020.6.6"
     }],
        options:[
          {
            value:1,
            label:'公司'
          },
          {
            value:2,
            label:'部门'
          },
        ]

      }
    }
}

</script>

<style lang="less" scoped>

</style>