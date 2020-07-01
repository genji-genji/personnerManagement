<template>
   <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

<!--      <el-table-column prop="num" label="员工号" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="0px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="num" style="width:50%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.num}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column prop="name" label="名称" width="100">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="0px">
              <el-input v-if="scope.row.isOK" v-model="name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="sex" label="性别">
          <template slot-scope="scope">
          <el-select v-model="sex" placeholder="请选择">
            <el-option
             v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column prop="date" label="出身日期">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="0px">
              <el-input v-if="scope.row.isOK" v-model="date" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.date}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="ID" label="身份证号">
          <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="0px">
              <el-input v-if="scope.row.isOK" v-model="ID" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.ID}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

<!--      <el-table-column prop="dep" label="部门">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="30px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="dep" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.dep}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

     <el-table-column prop="department" label="部门">
       <template slot-scope="scope">
         <el-select v-model="dep" placeholder="请选择"  >
           <el-option
             v-for="item in department"
             :key="item.department_id"
             :label="item.department_name"
             :value="item.department_id">
           </el-option>
         </el-select>
       </template>
     </el-table-column>

     <el-table-column prop="job" label="岗位">
       <template slot-scope="scope">
         <el-select v-model="job_id" placeholder="请选择"  >
           <el-option
             v-for="item in job"
             :key="item.job_id"
             :label="item.job_name"
             :value="item.job_id">
           </el-option>
         </el-select>
       </template>
     </el-table-column>

<!--      <el-table-column prop="date_in" label="入职日期">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="d" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.date_in}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column prop="date_work" label="工作日期">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="scope.row.date_work" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.date_work}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column prop="type_work" label="工作形式">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="30px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="type_work" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.type_work}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->


     <el-table-column prop="form" label="工作形式">
       <template slot-scope="scope">
         <el-select v-model="type_work" placeholder="请选择"  >
           <el-option
             v-for="item in form"
             :key="item.FORM_id"
             :label="item.FORM_name"
             :value="item.FORM_id">
           </el-option>
         </el-select>
       </template>
     </el-table-column>

        <el-table-column prop="address" label="人员来源">
          <template slot-scope="scope">
          <el-select v-model="address" placeholder="请选择">
            <el-option
             v-for="item in origin"
            :key="item.origin_id"
            :label="item.origin_name"
            :value="item.origin_id">
            </el-option>
          </el-select>
        </template>
      </el-table-column>

     <el-table-column prop="last" label="试用期长度(月)" width="100">
       <template slot-scope="scope">
         <el-form :model="scope.row">
           <el-form-item size="mini" label-width="30px">
             <el-input v-if="scope.row.isOK" v-model="last" style="width:100%;hight:100%"></el-input>
             <span v-else>{{scope.row.last}}</span>
           </el-form-item>
         </el-form>
       </template>
     </el-table-column>

<!--      <el-table-column prop="text_start" label="试用期开始日期">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="scope.row.text_start" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.text_start}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column prop="text_end" label="试用期结束日期">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="scope.row.text_end" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.text_end}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
　　　　　　<el-button type="info" @click="modifyUser(scope.row.column)">新建</el-button>
　　　　</template>
　　</el-table-column>
    </el-table>
</template>

<script>
import {postRequest} from "../uitls/api";
import {getRequest} from "../uitls/api";

export default {

  mounted: function () {

    this.refresh();

  },







  methods: {
       modifyUser() {
         let _this = this;

         if (_this.sex === 2) {
           _this.sex_2 = "女"
         }


         // console.error(_this.sex);
         // console.error(_this.sex_2);
         let url = this.rootUrl + "/staff/addStaff?sid=" + _this.num + "&sex=" + _this.sex_2 + "&name=" + _this.name + "&birthday=" + _this.date
           + "&id_no=" + _this.ID +
           "&origin_id=" + _this.address + "&form_id=" + _this.type_work + "&department_id=" + _this.dep + "&job_id=" + _this.job_id + "&last=" + _this.last
           + "&statu_id=" + 1;
         postRequest(url).then(back => {

           let backDate = back.data;
           _this.$message(backDate.result, backDate.message);


         });

       },
    refresh(){
      //   获取岗位信息
      let url_1=this.rootUrl+"/job/getJobList";
      getRequest(url_1).then(back=>{
        this.job=back.data;
      });

      let url_2=this.rootUrl+"/department/getDepartmentList";
      getRequest(url_2).then(back=>{
        this.department =back.data;
      });

      let url_3=this.rootUrl+"/staff/getFormList";
      getRequest(url_3).then(back=>{
        this.form=back.data;
      });
      let url_4=this.rootUrl+"/staff/getOriginList";
      getRequest(url_4).then(back=>{
        this.origin=back.data;
      })

    },

      dbclick(row, event, column){
      row.isOK =!row.isOK
    }
    },


    data() {
      return {
        num: "",
        isOK: true,
        name: "",
        sex: 1,
        sex_2:"男",
        date:"",
        ID:"",
        dep:1,
        date_in:"",
        date_work:"",
        type_work:1,
        address:1,
        text_start:"",
        text_end:"",
        job_id: 1,
        last: 0,

       tableData: [
     {
       num: "",
       isOK: true,
       name: "",

       date:"",

       sex: "",

       ID:"",
       dep:"",
       date_in:"",
       date_work:"",
       type_work:"",
       address:"",
       text_start:"",
       text_end:"",
       last:0,
       job_id: "",


     }],

        job:[],
        department: [],
        origin: [],
        form: [],


     options:[
       {
       value:1,
       label:'男'
     },
     {
       value:2,
       label:'女'
     }],
     choose:[
       {
       id:'a',
       label:'校园招聘'
     },
     {
       id:'b',
       label:'社会招聘'
     },
     {
       id:'c',
       label:'其他'
     }]
      }

    }
}


</script>

<style lang="less" scoped>

</style>
