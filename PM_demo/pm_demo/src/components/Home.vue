<template>
    <el-container class="home_container">
        <!-- 头部区 -->
        <el-header>
            <div class="home_header">
                <img src="../assets/logo.jpg" alt="">
                <span>人事管理系统</span>
            </div>
        </el-header>
        <!-- 主体区域 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside width="200px">
                <!-- 侧边栏菜单 -->
                <el-menu background-color="#888880" text-color="#fff" active-text-color="#409eff" router >
                    <!-- 1级菜单 -->
                    <el-submenu index="1">
                        <!-- 一级菜单模板区 -->
                        <template slot="title">
                            <i class="el-icon-s-custom"></i>
                            <span>入职管理</span>
                        </template>
                         <!-- 二级菜单 -->
                         <el-menu-item index="1-1">
                             <template slot="title">
                            <i class="el-icon-alarm-clock"></i>
                            <span>异动管理</span>
                        </template>
                         </el-menu-item>
                         <el-menu-item index="1-2">
                             <template slot="title">
                            <i class="el-icon-tickets"></i>
                            <span>信息管理</span>
                        </template>
                         </el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <!-- 一级菜单模板区 -->
                        <template slot="title">
                            <i class="el-icon-s-home"></i>
                            <span>部门管理</span>
                        </template>
                         <!-- 二级菜单 -->
                         <el-menu-item index="2-1">
                             <template slot="title">
                            <i class="el-icon-plus"></i>
                            <span>新建部门</span>
                        </template>
                         </el-menu-item>
                         <el-menu-item index="2-2">
                            <template slot="title">
                                <i class="el-icon-edit"></i>
                                <span>修改部门</span>
                            </template>
                         </el-menu-item>
                         <el-menu-item index="2-3">
                            <template slot="title">
                                <i class="el-icon-search"></i>
                                <span>员工查询</span>
                            </template>
                        </el-menu-item>
                    </el-submenu>
                    <el-submenu index="3">
                        <!-- 一级菜单模板区 -->
                        <template slot="title">
                            <i class="el-icon-s-check"></i>
                            <span>岗位管理</span>
                        </template>
                         <!-- 二级菜单 -->
                         <el-menu-item index="3-1">
                             <template slot="title">
                            <i class="el-icon-plus"></i>
                            <span>新建岗位</span>
                        </template>
                         </el-menu-item>
                         <el-menu-item index="3-2">
                             <template slot="title">
                            <i class="el-icon-edit"></i>
                            <span>修改岗位</span>
                        </template>
                         </el-menu-item>
                         <el-menu-item index="3-3">
                             <template slot="title">
                            <i class="el-icon-search"></i>
                            <span>查询员工</span>
                        </template>
                         </el-menu-item>
                    </el-submenu>
                    <el-submenu index="4">
                        <!-- 一级菜单模板区 -->
                        <template slot="title">
                            <i class="el-icon-s-grid"></i>
                            <span>报表管理</span>
                        </template>
                         <!-- 二级菜单 -->
                         <el-menu-item index="4-1">
                             <template slot="title">
                            <i class="el-icon-plus"></i>
                            <span>新聘报表</span>
                        </template>
                         </el-menu-item>
                         <el-menu-item index="2-2">
                             <template slot="title">
                            <i class="el-icon-minus"></i>
                            <span>离职报表</span>
                        </template>
                         </el-menu-item>
                          <el-menu-item index="4-3">
                             <template slot="title">
                            <i class="el-icon-rank"></i>
                            <span>部门调动报表</span>
                        </template>
                         </el-menu-item>
                          <el-menu-item index="4-4">
                             <template slot="title">
                            <i class="el-icon-sort"></i>
                            <span>岗位调动报表</span>
                        </template>
                         </el-menu-item>
                          <el-menu-item index="4-5">
                             <template slot="title">
                            <i class="el-icon-tickets"></i>
                            <span>人事月报</span>
                        </template>
                         </el-menu-item>
                    </el-submenu>     
                </el-menu>
            </el-aside>
            <!-- 右侧内容 -->
            <el-main>
                <div class="div_main">
                    <router-view></router-view>
                    <!-- <el-button type="warning" icon="el-icon-warning">异动管理</el-button>
                    <el-button type="warning" icon="el-icon-info">信息管理</el-button> -->
                </div>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    
}
</script>

<style lang="less" scoped>
.home_container{
    height: 100%;
}
.home_header{
    img{
            width: 9%;
            height:100%;
            border-radius: 50%;
        }
}
.el-header{
    background-color: #F8E8D8;
    display: flex;
    justify-content: space-between;
    padding-left: 0%;
    color:#888880;
    font-size: 30px;
    >div {
        display: flex;
        align-items: center;
        span{
            margin-left: 130px;
        }
    }
}
.el-aside{
    background-color: #888880;
    height: 100%;
    .el-menu{
        border-right: none;
    }
}
.el-main{
    background-color: #e8e1d1;
}
.div_main{
    text-align: center;
    font-size: 30px;
}
</style>