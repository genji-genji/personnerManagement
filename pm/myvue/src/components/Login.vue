<template>
  <el-form :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"
                @keyup.enter.native="submitClick"></el-input>
    </el-form-item>
    <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
    <el-form-item style="width: 100%">
      <el-button type="primary" @click.native.prevent="submitClick" style="width: 100%">登录</el-button>
      <!--
      <p></p>
      <el-button type="primary" @click.native.prevent="submitClick2" style="width: 100%">测试</el-button>

       <p></p>
      <el-button type="primary" @click.native.prevent="submitClick3" style="width: 100%">退出</el-button>
      -->
    </el-form-item>
  </el-form>
</template>
<script>
  import {postRequest}   from '../utils/api'
  import {putRequest}    from '../utils/api'
  import {deleteRequest} from '../utils/api'
  import {getRequest}    from '../utils/api'

  export default{
    mounted: function () {
      this.a();
    },

    data(){
      return {
        /*
         rules: {
           account: [{required: true, message: '请输入用户名', trigger: 'blur'}],
           checkPass: [{required: true, message: '请输入密码', trigger: 'blur'}]
         },
         */
        //checked: true,
        checked: false,
        loginForm: {
          username: '',//bianque',
          password: '',//bianque123'
        },
        loading: false
      }
    },

    methods: {
      a(){
        var  c =  localStorage.getItem("cccc");
        var  b =  localStorage.getItem("bbbb");
        var  a =  localStorage.getItem("aaaa");
        //this.$alert('aa--->'+ c , '信息提示');
        if(c == 'true')
        {
          this.checked = true;
          this.loginForm.username = a;
          this.loginForm.password = b;
        }
        else
        {
          this.loginForm.username = "";
          this.loginForm.password = "";
        }
      },

      submitClick: function () {
        var _this = this;

        if (this.loginForm.username == null || this.loginForm.username.length == 0
          ||  this.loginForm.password == null || this.loginForm.password.length == 0) {

          _this.$message({
            type: 'info',
            message: '用户名和密码不能为空!'
          });

          return;
        }

        var url0 = this.rootUrl+"/neusys/user/get_user?keywords=" + this.loginForm.username + "&keywords2=" + this.loginForm.password;
        //按用户名和密码查询
        getRequest(url0).then(resp=> {

          var json = resp.data;
          if (json == null || json.length == 0){
            _this.$alert('用户名 密码 不存在或错误!', '登录失败!');
          }
          else {
            _this.$store.dispatch("userLogin", true);

            //Vuex在用户刷新的时候userLogin会回到默认值false，所以我们需要用到HTML5储存
            //我们设置一个名为Flag，值为isLogin的字段，作用是如果Flag有值且为isLogin的时候，证明用户已经登录了。

            //localStorage.setItem("Flag", "isLogin");
            sessionStorage.setItem("Flag", "isLogin");

            //localStorage.setItem("name", json.realName);
            sessionStorage.setItem("name", json.realName);
            sessionStorage.setItem("useType", json.useType);
            sessionStorage.setItem("useID", json.id);

            //_this.$alert('欢迎 json.useType=== '+ json.useType , '登录成功!');

            if(_this.checked == true)
            {
              //_this.$alert('需要保存'+ this.loginForm.username , '信息提示');

              localStorage.setItem("aaaa", this.loginForm.username);
              localStorage.setItem("bbbb", this.loginForm.password);
              localStorage.setItem("cccc", true);
            }else{

              localStorage.setItem("cccc", false);
            }
            //登录成功后跳转到指定页面
            _this.$router.replace({path: '/home'});
          }
        });
      },
    }
  }
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
