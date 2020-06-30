<template>
  <el-container>
    <el-header class="cate_mana_header">
      <el-input
        placeholder="通过姓名搜索"
        prefix-icon="el-icon-search"
        v-model="keywords" style="width: 200px" size="mini">
      </el-input>

      <el-input
        placeholder="通过身份证号搜索"
        prefix-icon="el-icon-search"
        v-model="keywords2" style="width: 200px" size="mini">
      </el-input>

      <el-button type="primary" icon="el-icon-search" size="mini" style="margin-left: 3px" @click="searchClick">搜索
      </el-button>

      <el-button type="primary" icon="el-icon-search" size="mini" style="margin-left: 3px" @click="newDept()">新增人员
      </el-button>
    </el-header>

    <el-main class="cate_mana_main">
      <el-table
        ref="multipleTable"
        :data="categories"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange" v-loading="loading">
        <el-table-column
          type="selection"
          width="55" align="left">
        </el-table-column>
        <el-table-column
          label="编号"
          prop="id"
          width="120" align="left">
        </el-table-column>
        <el-table-column
          label="姓名"
          prop="personName"
          width="120" align="left">
        </el-table-column>

        <el-table-column
          label="身份证号"
          prop="cc"
          width="120" align="left">
        </el-table-column>

        <el-table-column
          label="民族"
          prop="aa"
          width="120" align="left">
        </el-table-column>

        <el-table-column
          label="城市"
          prop="bb"
          width="120" align="left">
        </el-table-column>
        
        <el-table-column label="操作" align="left">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="danger" :disabled="this.selItems.length==0" style="margin-top: 10px;width: 100px;"
                 @click="deleteAll" v-if="this.categories.length>0">批量删除
      </el-button>
      <div class="blog_table_footer">
     <span></span>
      <el-pagination
        background
        :page-size="pageSize" :current-page.sync="currentPage01"
        layout="prev, pager, next"
        :total="totalCount" @current-change="currentChange" v-show="this.categories.length>0">
      </el-pagination>
    </div>
</el-main>

<!-- 新增人员弹框---start -->
        <el-dialog title="新增人员" :visible.sync="dialogFormVisible" width="550px" align="center">
             <el-input
        placeholder="请输入姓名"
        v-model="personName" style="width: 200px;">
      </el-input>

      <el-input
        placeholder="请输入身份证号码"
        v-model="sfzh" style="width: 200px;">
      </el-input>
     

      <el-select v-model="nid" placeholder="请选择民族" style="width: 150px;">
             <el-option
                v-for="item in categories3"
                :key="item.id"
                :label="item.nationName"
                :value="item.id">
              </el-option>
      </el-select>

      <el-select v-model="cid" placeholder="请选择城市" style="width: 150px;">
             <el-option
                v-for="item in categories2"
                :key="item.id"
                :label="item.cityName"
                :value="item.id">
              </el-option>
      </el-select>
  <el-main class="cate_mana_header">
     <el-button type="primary" size="medium" style="margin-left: 10px" @click="addNewCate">新增人员</el-button>
  </el-main>
</el-dialog>
<!-- 新增人员弹框---end -->


</el-container>
</template>

<script>
  import {postRequest}   from '../utils/api'
  import {putRequest}    from '../utils/api'
  import {deleteRequest} from '../utils/api'
  import {getRequest}    from '../utils/api'
  
  export default{
    methods: {
       addNewCate(){
        var _this = this;
        if (this.personName == null || this.personName.length == 0
           || this.sfzh == null || this.sfzh.length == 0
           || this.nid == null || this.nid.length == 0
           || this.cid == null || this.cid.length == 0)
        {
            _this.$message({
              type: 'info',
              message: '4项数据不能为空!'
            });
        } 
        else {
        this.loading = true;
        postRequest('/gj_admin/person/', {personName: this.personName, nid: this.nid, cid: this.cid, sfzh: this.sfzh, xb: this.myVal2, ah: this.myVal, csrq: this.value1}).then(resp=> {
          if (resp.status == 200) {
            var json = resp.data;
            _this.$message({type: json.status, message: json.msg});
            _this.personName = '';
            _this.sfzh = '';
            _this.nid = '';
            _this.cid = '';
            _this.loadBlogs(1, _this.pageSize);;
          }
          _this.loading = false;
        }, resp=> {
          if (resp.response.status == 403) {
            _this.$message({
              type: 'error',
              message: resp.response.data
            });
          }
          _this.loading = false;
        });
      }},
      searchClick(){
        this.loadBlogs(1, this.pageSize);
      },
      loadBlogs(page, count){
        var _this = this;
        var url = "/gj_admin/person/all2?page=" + page + "&count=" + count + "&keywords=" + this.keywords + "&keywords2=" + this.keywords2;
        getRequest(url).then(resp=> {
          _this.loading = false;
          if (resp.status == 200) {
            _this.categories = resp.data.list;
            _this.totalCount = resp.data.totalCount;
            _this.currentPage01 = page ;
          } else {
            _this.$message({type: 'error', message: '数据加载失败!'});
          }
        }, resp=> {
          _this.loading = false;
          if (resp.response.status == 403) {
            _this.$message({type: 'error', message: resp.response.data});
          } else {
            _this.$message({type: 'error', message: '数据加载失败!'});
          }
        }).catch(resp=> {
          //压根没见到服务器
          _this.loading = false;
          _this.$message({type: 'error', message: '数据加载失败!'});
        })
      },
      //翻页
      currentChange(currentPage){
        this.currentPage01 = currentPage;
        this.loading = true;
        this.loadBlogs(currentPage, this.pageSize);
      },
      deleteAll(){
        var _this = this;
        this.$confirm('确认删除这 ' + this.selItems.length + ' 条数据?', '提示', {
          type: 'warning',
          confirmButtonText: '确定',
          cancelButtonText: '取消'
        }).then(()=> {
          var selItems = _this.selItems;
          var ids = '';
          for (var i = 0; i < selItems.length; i++) {
            ids += selItems[i].id + ",";
          }
          _this.deleteCate(ids.substring(0, ids.length - 1));
        }).catch(() => {
          //取消
          _this.loading = false;
        });
      },
      handleSelectionChange(val) {
        this.selItems = val;
      },
      newDept(){
        this.dialogFormVisible = true;
      },
      handleEdit(index, row){
        var _this = this;
        this.$prompt('请输入新名称', '编辑', {
          confirmButtonText: '更新',
          inputValue: row.personName,
          cancelButtonText: '取消'
        }).then(({value}) => {
          //value就是输入值
          if (value == null || value.length == 0) {
            _this.$message({
              type: 'info',
              message: '数据不能为空!'
            });
          } else {
            _this.loading = true;
            putRequest("/gj_admin/person/", {id: row.id, personName: value}).then(resp=> {
              let json = resp.data;
              _this.$message({
                type: json.status,
                message: json.msg
              });
              _this.loadBlogs(1, _this.pageSize);
            }, resp=> {
              if (resp.response.status == 403) {
                _this.$message({
                  type: 'error',
                  message: resp.response.data
                });
              }
              _this.loading = false;
            });
          }
        });
      },
      handleDelete(index, row){
        let _this = this;
        this.$confirm('确认删除 ' + row.personName + ' ?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          _this.deleteCate(row.id);
        }).catch(() => {
          //取消
          _this.loading = false;
        });
      },
      deleteCate(ids){
        var _this = this;
        this.loading = true;
        //删除
        deleteRequest("/gj_admin/person/" + ids).then(resp=> {
          var json = resp.data;
          _this.$message({
            type: json.status,
            message: json.msg
          });
          _this.loadBlogs(1,_this.pageSize);
        }, resp=> {
          _this.loading = false;
          if (resp.response.status == 403) {
            _this.$message({
              type: 'error',
              message: resp.response.data
            });
          } else if (resp.response.status == 500) {
            _this.$message({
              type: 'error',
              message: '该项目下尚有内容，删除失败!'
            });
          }
        })
      },
      getCategories(){
        let _this = this;
        getRequest("/gj_admin/nation/all").then(resp=> {
          _this.categories3 = resp.data;
        });
      },
      getCategories2(){
        let _this = this;
        getRequest("/gj_admin/city/all").then(resp=> {
          _this.categories2 = resp.data;
        });
      },
    },
    mounted: function () {

      this.getCategories();
      this.getCategories2();
      ///*
      var _this = this;
      this.loading = true;
      this.loadBlogs(1, this.pageSize);
      
      window.bus.$on('blogTableReload', function () {
        _this.loading = true;
        _this.loadBlogs(_this.currentPage01, _this.pageSize);
      })//*/
    },
    data(){
      return {
        currentPage01:2,
        cateName: '',
        cityName: '',
        nationName: '',
        sfzh: '',
        selItems: [],
        categories: [],
        loading: false,
        totalCount: 2,
        pageSize: 3,
        keywords: '',
        keywords2: '',
        dialogFormVisible: false,
        personName: '',
        categories2: [],
        categories3: [],
        nid: '',
        cid: ''
      }
    }
  }
</script>
