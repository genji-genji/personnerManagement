<template>

  <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

      <el-table-column prop="num" label="编号" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="job_id" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.num}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column prop="name" label="名称" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="job_name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

<!--      <el-table-column prop="type" label="类型">-->
<!--          <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="type_id" style="width:100%;hight:100%" placeholder=""></el-input>-->
<!--              <span v-else>{{scope.row.type}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

    <el-table-column prop="type" label="类型">
      <template slot-scope="scope">
        <el-select v-model="type_id" placeholder="请选择">
          <el-option
            v-for="item in job_type"
            :key="item.type_id"
            :label="item.type_name"
            :value="item.type_id">
          </el-option>
        </el-select>
      </template>
    </el-table-column>

    <el-table-column prop="num" label="现有人数" width="180">
      <template slot-scope="scope">
        <el-form :model="scope.row">
          <el-form-item size="mini" label-width="66px">
            <el-input disabled v-if="scope.row.isOK" v-model="current_number" style="width:100%;hight:100%"></el-input>
            <span v-else>{{scope.row.num}}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>
    <el-table-column prop="num" label="最大人数" width="180">
      <template slot-scope="scope">
        <el-form :model="scope.row">
          <el-form-item size="mini" label-width="66px">
            <el-input  v-if="scope.row.isOK" v-model="max_number" style="width:100%;hight:100%"></el-input>
            <span v-else>{{scope.row.num}}</span>
          </el-form-item>
        </el-form>
      </template>
    </el-table-column>


      <el-table-column label="操作" align="center" min-width="100">
　　　　<template slot-scope="scope">
<!--        <el-button type="info" @click="select()">查询</el-button>-->
　　　　　<el-button type="info" @click="modifyUser()">修改</el-button>
　　　　</template>
　　</el-table-column>
    </el-table>
</template>

<script>
  import {getRequest, putRequest} from "../../uitls/api";

export default {

  mounted:function () {
    this.job_id=this.$route.params.job_id

    let url_1=this.rootUrl+"/job/getJobTypeList";

    getRequest(url_1).then(back=>{
      this.job_type=back.data;
    });

    let url=this.rootUrl+"/job/getJobById?job_id="+this.job_id;
    getRequest(url).then(back=>{
      let backdate=back.data;

      this.job_id=backdate.job_id;
      this.job_name=backdate.job_name;
      this.current_number=backdate.current_number;
      this.max_number=backdate.max_number;
      this.type_id=backdate.type_id;

    });
  },

  methods: {
      dbclick(row, event, column){
      row.isOK =!row.isOK
    },

    // select(){
    //     let url=this.rootUrl+"/job/getJobById?job_id="+this.job_id;
    //   getRequest(url).then(back=>{
    //     let backdate=back.data;
    //
    //     this.job_id=backdate.job_id;
    //     this.job_name=backdate.job_name;
    //     this.current_number=backdate.current_number;
    //     this.max_number=backdate.max_number;
    //     this.type_id=backdate.type_id;
    //
    //   });
    // },
    modifyUser(){
      let url=this.rootUrl+"job/updateJob?job_id="+this.job_id+"&job_name="+this.job_name+"&max_number="+this.max_number+"&type_id="+this.type_id;
      putRequest(url).then(back=>{
        let backdata=back.data;

        if(backdata===null||backdata===0){
          this.$alert("错误","更新失败");
        }
        else {
          this.$alert(backdata.result,backdata.message);
        }})

    },
    },

    data() {
      return {

        job_id :1,
        job_name:"",
        current_number: 0,
        max_number:0,
        type_id: 0,

        job_type:[],

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
