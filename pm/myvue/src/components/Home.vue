<template>
  <el-container class="home_container">
    <el-header class="gao-el-header">
      <div class="home_title" >医院HIS系统</div>
      <div class="home_userinfoContainer" >
        <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link home_userinfo">
          {{currentUserName}}<i class="el-icon-arrow-down el-icon--right home_userinfo"></i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="sysMsg"><el-button type="text"  @click="showHideMenu(false)" >
              {{patientsButtonText}}
            </el-button></el-dropdown-item>
            <el-dropdown-item command="MyArticle">我的设置</el-dropdown-item>
            <el-dropdown-item command="MyHome">个人主页</el-dropdown-item>
            <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container >
      <el-aside width="200px" v-if="showMenu" >
        <!-- 左侧边菜单 开始   挂号收费  && item.name=='门诊医生'
                      v-if="!item.hidden &&  item.name.indexof(menu01)
         -->
        <el-menu
          default-active="0"
          class="el-menu-vertical-demo" style="background-color: #ECECEC" router  @select="addTab">
          <template v-for="(item,index) in this.$router.options.routes"
                    v-if="!item.hidden && (item.name == menu01 || menu01 == 'root')">
            <el-submenu :index="index+''" v-if="item.children.length>1" :key="index">
              <template slot="title">
                <i :class="item.iconCls"></i>
                <span>{{item.name}}</span>
              </template>
              <!-- 左侧边菜单 子菜单开始-->
              <el-menu-item v-for="child in item.children" v-if="!child.hidden" :index="child.path" :key="child.path">
                {{child.name}}
              </el-menu-item>
              <!-- 左侧边菜单 子菜单结束-->
            </el-submenu>
            <template v-else>
              <el-menu-item :index="item.children[0].path">
                <i :class="item.children[0].iconCls"></i>
                <span slot="title">{{item.children[0].name}}</span>
              </el-menu-item>
            </template>
          </template>
        </el-menu>
        <!-- 左侧边菜单 结束-->
      </el-aside>

      <el-container>
        <el-main class="gao-el-main">
          <el-tabs v-model="editableTabsValue" type="card" editable @edit="handleTabsEdit" @tab-click="showContent">
            <el-tab-pane
              :key="item.name"
              v-for="(item, index) in editableTabs"
              :label="item.title"
              :name="item.name"
              :route="item.route"
            >
              <router-view />
            </el-tab-pane>
          </el-tabs>
        </el-main>
      </el-container>
    </el-container>
  </el-container>
</template>
<script>
  import {getRequest} from '../utils/api'
  export default{
    methods: {
      handleCommand(command){
        var _this = this;
        if (command == 'logout') {
          this.$confirm('注销登录吗?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(function () {
            getRequest("/logout")
            _this.currentUserName = '游客';
            //localStorage.removeItem("Flag");
            sessionStorage.removeItem("Flag");
            _this.$router.replace({path: '/login'});
          }, function () {
            //取消
          })
        }
      },
      handleTabsEdit(targetName, action) {
        if (action === 'remove') {
          let tabs = this.editableTabs;
          let activeName = this.editableTabsValue;
          if (activeName === targetName) {
            tabs.forEach((tab, index) => {
              // console.log(tab.name, targetName, tab.name === targetName);
              if (tab.name === targetName) {
                let nextTab = tabs[index + 1] || tabs[index - 1];
                if (nextTab) {
                  activeName = nextTab.name;
                }
              }
            });
          }
          this.editableTabsValue = activeName;
          this.editableTabs = tabs.filter(tab => tab.name !== targetName);
          this.$router.push(activeName);
        }
      },
      showContent(tag) {
        this.$router.push(tag.name);
      },
      findCompontByPath(path) {
        for (let r of this.$router.options.routes) {
          if (r.children) {
            let a = r.children.find(c => c.path == path);
            if (a) {
              return a;
            }
          }
        }
        return null;
      },
      addTab(index) {
        if (index) {
          let componet = this.findCompontByPath(index);
          // console.log(componet);
          if (componet) {
            if (!this.editableTabs.some(t => t.name == componet.path)) {
              this.editableTabs.push({
                title: componet.name,
                name: componet.path,
                route: componet.path
              });
            }
            this.editableTabsValue = componet.path;
            this.$router.push(componet.path);
          }
        }
      },
      // 显示/隐藏
      showHideMenu () {
        this.showMenu = !this.showMenu;
        if(this.showMenu){
          this.patientsButtonText="隐藏菜单";
        }else{
          this.patientsButtonText="显示菜单";
        }
      }
    },

    mounted: function () {
      let _this = this;
      //页面加载时,将常数项放置到 localStorage 中
      getRequest(this.rootUrl +'/neusys/constantItem/all2?keywords=')
        .then(function (res) {
          let array = [];
          array = res.data.list;
          // console.log(array);
          localStorage.setItem('ConstantsObj',JSON.stringify(array));
        }).catch(function (err) {
        console.log(err);
      });
      let ss =sessionStorage.getItem("name");
      let useType = sessionStorage.getItem("useType");
      //_this.$alert('UseType:'+ UseType , 'UseType');
      if (useType == '0')
        _this.menu01='root';
      if (useType == '1')
        _this.menu01='系统信息';
      if (useType == '2')
        _this.menu01='挂号收费';
      if (useType == '3')
        _this.menu01='门诊医生';
      if (useType == '4')
        _this.menu01='医技医生';
      if (useType == '5')
        _this.menu01='药房操作员';
      if (useType == '6')
        _this.menu01='财务管理员';
      if (ss == null || ss.length == 0)
        _this.currentUserName = '游客';
      else
        _this.currentUserName = ss;
    },
    data(){
      return {
        patientsButtonText:'隐藏菜单',
        showMenu: true,
        currentUserName: '',
        editableTabsValue: '2',
        editableTabs: [],
        tabIndex: 2,
        menu01: '',  //挂号收费 门诊医生
      }
    }
  }
</script>
<style scoped>
  .home_container {
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }

  .gao-el-header {
    background-color: #20a0ff;
    color: #333;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .gao-el-aside {
    background-color: #ECECEC;
  }

  .gao-el-main {
    background-color: #fff;
    color: #000;
    text-align: left;
  }

  .home_title {
    color: #fff;
    font-size: 22px;
    display: inline;
  }

  .home_userinfo {
    color: #fff;
    cursor: pointer;
  }

  .home_userinfoContainer {
    display: inline;
    margin-right: 20px;
    text-align: right;
  }
</style>
