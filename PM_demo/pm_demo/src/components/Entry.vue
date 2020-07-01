<template>
   <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

      <el-table-column prop="num" label="员工号" width="180">
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

      <el-table-column prop="sex" label="性别">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.sex" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.sex}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="date" label="出身日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.date" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.date}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="ID" label="身份证号">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.ID" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.ID}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="dep" label="部门">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.dep" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.dep}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="date_in" label="入职日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.date_in" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.date_in}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="date_work" label="工作日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.date_work" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.date_work}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="type_work" label="工作形式">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.type_work" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.type_work}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

        <el-table-column prop="address" label="人员来源">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.address" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.adress}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="text_start" label="试用期开始日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.text_start" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.text_start}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="atext_end" label="试用期结束日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="scope.row.text_end" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.text_end}}</span>
            </el-form-item>
          </el-form>
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
import {postRequest} from "../uitls/api";

export default {

     methods: {
       modifyUser(){
        let _this=this;
         postRequest(this.rootUrl+"/staff/assStaff?sid="+_this.scope.row.num+"&sex="+_this.scope.row.sex+"&name="+_this.scope.row.name+"&birthday="+_this.row.date
         +"&id_no="+_this.scope.row.ID+
           "&origin_id="+_this.scope.row.address+"&form_id="+_this.scope.row.type_work+"&department_id="+_this.scope.row.dep+"&job_id="+_this.scope.row.job_id
         +"&statu_id="+1).then(back=>{

           let backDate=back.data;
           _this.$message(backDate.result,backDate.message);


         });

       },



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
       sex: "男",
       date: "",
       ID: "",
       dep: "",
       date_in: "",
       date_work: "",
       work: "",
       adress: "",
       test_start: "",
       text_end : "",
       job_id: "",


     }]
      }
    }
}


</script>

<style lang="less" scoped>

</style>
