<template>
    <div class="login_container">
        <div class="login_box">
            <div class="avatar_img">
                <img src="../assets/logo.jpg" alt="">
            </div>
            <div>
                <!-- 登录表单 -->
                <el-form ref="loginRef" :model="loginform" :rules="loginFormRules" label-width="80px" class="login_form">
                    <!-- 用户名 -->
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="loginform.username" class="ip" prefix-icon="el-icon-user-solid"></el-input>
                    </el-form-item>
                    <!-- 密码 -->
                    <el-form-item label="密码" prop="password">
                        <el-input v-model="loginform.password" class="ip" prefix-icon="el-icon-lock" type="password"></el-input>
                    </el-form-item>
                    <!-- 按钮区域 -->
                    <el-form-item class="btns">
                        <el-button type="primary" @click="login">登录</el-button>
                        <el-button type="info" @click="resetLogin">重置</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>>

<script>
export default {
    name:"Login",
    data(){
        return{
            //登录表单数据绑定对象
            loginform:{
                username:'',
                password:''
            },
            //表单的验证规则
            loginFormRules:{
                username:[{required: true, message:"请输入用户名",trigger:"blur"}],
                password:[{required: true, message:"请输入密码",trigger:"blur"}]
            }
        }
    },
    methods:{
        resetLogin(){
            this.$refs.loginRef.resetFields();
            // console.log(this)
        },
        login(){
            //  this.$refs.loginRef.validate(async valid => {
            //      if(!valid) return;
            //      const {data: res} =await this.$http.post("login",this.loginform);
            //      console.log(res)
            // // 编程式导航跳转
            this.$router.push("/home");
            //  });

        }
    }
}
</script>

<style lang="less" scoped>
.login_container{
    background-color: #F8E8D8;
    height: 100%;
}

.login_box{
    width: 450px;
    height: 300px;
    background-color: #e8e1d1;
    border-radius: 3px;
    position:absolute;
    top:50%;
    left: 50%;
    transform: translate(-50%,-50%);

    .avatar_img{
        height: 130px;
        width: 130px;
        border: 1px,solid purple;
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 0 10px gray;
        position: absolute;
        left: 50%;
        transform: translate(-50%,-50%);
        img{
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }
    }
}

.btns{
    display: flex;
    justify-content: center;
}

.login_form{
     position: absolute;
     bottom: 0;
     width: auto;
     left: 10%;
}

.ip{
    background-color: transparent;
}
</style>