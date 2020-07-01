<template>
   <el-table :data="tableData" border style="width: 100%;margin:0 auto" @row-dblclick="dbclick" >

<!--      <el-table-column prop="post_num" label="编号" width="180">-->
<!--        <template slot-scope="scope">-->
<!--          <el-form :model="scope.row">-->
<!--            <el-form-item size="mini" label-width="66px">-->
<!--              <el-input v-if="scope.row.isOK" v-model="scope.row.post_num" style="width:100%;hight:100%"></el-input>-->
<!--              <span v-else>{{scope.row.post_num}}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column prop="post_name" label="名称" width="180">
        <template slot-scope="scope">
          <el-form :model="scope.row">
            <el-form-item size="mini" label-width="66px">
              <el-input v-if="scope.row.isOK" v-model="job_name" style="width:100%;hight:100%"></el-input>
              <span v-else>{{scope.row.post_name}}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

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


     <el-table-column prop="max" label="最大人数" width="180">
       <template slot-scope="scope">
         <el-form :model="scope.row">
           <el-form-item size="mini" label-width="66px">
             <el-input v-if="scope.row.isOK" v-model="max_number" style="width:100%;hight:100%"></el-input>
             <span v-else>{{scope.row.post_name}}</span>
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
  import {getRequest, postRequest} from "../../uitls/api";

export default {


  mounted:function () {
    let url_1=this.rootUrl+"/job/getJobTypeList";
    getRequest(url_1).then(back=>{
      this.job_type=back.data;
    });
  },


  methods: {

    modifyUser(){
      let _this=this;
      let url=this.rootUrl+"/job/addJob?job_name="+this.job_name+"&type_id="+this.type_id+"&max_number="+this.max_number;
      postRequest(url).then(back => {

        let backDate = back.data;
        _this.$message(backDate.result, backDate.message);




      });
    },

    dbclick(row, event, column) {
      row.isOK = !row.isOK
    }
  },


  data() {
    return {
      tableData: [
        {
          post_num: "1",
          isOK: true,
          post_name: "张二",
          post_type: "上海市普陀区金沙江路 1518 弄",
        }],
      job_type: [],
      job_name: "",
      type_id:1,
      current_number:0,
      max_number:0,


    }
  }
}

</script>

<style lang="less" scoped>

</style>
