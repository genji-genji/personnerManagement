<template>
   <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

      <el-table-column prop="num" label="编号" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="department_id" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.num}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="department_name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

        <el-table-column prop="type" label="类型">
          <template slot-scope="scope">
          <el-select v-model="type_id" placeholder="请选择">
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
              <el-input v-if="scope.row.isOK" v-model="department_phone" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.phone}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="email" label="传真">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="department_bt" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.email}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

<!--      <el-table-column prop="date" label="成立日期">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="scope.row.date" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.date}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
　　　　　　<el-button type="info" @click="modifyUser">新建</el-button>
　　　　</template>
　　</el-table-column>
    </el-table>
</template>

<script>
import {postRequest} from "../../uitls/api";

export default {
     methods: {
      dbclick(row, event, column){
      row.isOK =!row.isOK
    },

       modifyUser(){
         let url_1=this.rootUrl+"/department/addDepartment?department_id="+this.department_id+"&department_name="+this.department_name+"&department_phone="+this.department_phone+
           "&department_bt="+this.department_bt+"&type_id="+this.type_id+"&department_type="+this.department_type;
         postRequest(url_1).then(back=>{
           let backdata=back.data;
           if (backdata===null||backdata===0){
             this.$alert("错误","失败");
           }
           else {
             this.$alert(backdata.result,backdata.message);
           }
         })
       },
    },

    data() {
      return {

        department_id:null,
        department_name:null,
        department_phone:null,
        department_bt:null,
        department_type:"战术",
        type_id: null,


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
            label:'支援'
          },
          {
            value:2,
            label:'战术'
          },
        ]

      }
    }
}

</script>

<style lang="less" scoped>

</style>
