<template>
  <h1>基于自然语言处理的网络舆情分析系统</h1>
    <div id="main">
      <el-tabs type="border-card">
        <el-tab-pane ref="login" :model="formData" label="登录">
          <div style="display: flex;justify-content: center;margin-top: 40px">
            <h4>账号：</h4>
            <el-input
                style="width: 250px;height: 35px"
                placeholder="请输入账号"
                v-model="formData.account"
                clearable>
            </el-input>
          </div>
          <div style="display: flex;justify-content: center;margin-top: 10px">
            <h4>密码：</h4>
            <el-input
                style="width: 250px;height: 35px;"
                placeholder="请输入密码"
                v-model="formData.password"
                show-password>
            </el-input>
          </div>

          <div>
            <el-button type="warning" style="margin-left: 180px;margin-top:30px;width: 100px"
            @click="Login"
            >登录</el-button>
          </div>
        </el-tab-pane>

        <el-tab-pane label="注册" :model="signData">
          <div style="display: flex;justify-content: center;margin-top: 20px">
            <h4>账号：</h4>
            <el-input
                style="width: 250px;height: 35px"
                placeholder="请输入手机号注册账户"
                v-model="signData.account"
                clearable>
            </el-input>
          </div>
          <div style="display: flex;justify-content: center;margin-top: 10px">
            <h4>密码：</h4>
            <el-input
                style="width: 250px;height: 35px;"
                placeholder="请设置密码"
                v-model="signData.password"
                show-password>
            </el-input>
          </div>
          <div style="display: flex;justify-content: center;margin-top: 10px">
            <h4>确认：</h4>
            <el-input
                style="width: 250px;height: 35px;"
                placeholder="请再次输入密码确认"
                v-model="signData.passwordTo"
                show-password>
            </el-input>
          </div>
          <div>
            <el-button type="warning" style="margin-left: 180px;margin-top:10px;width: 100px"
            @click="Sign"
            >注册</el-button>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
</template >

<script >
import router from "@/router";
import axios from "axios";
import store from "@/store";
// const axios = require('axios');
  export default {
     name: "Login",
    methods:{
      Login(){
        axios.post("http://localhost:8081/Login",this.formData)
            .then((res)=>{
              if(res.data.flag){
                this.$message.success(res.data.msg);
                store.commit("set",res.data.data);
                // this.$message.info("info:"+store.state.userId);
                router.push('/Home')
              }else{
                this.$message.error(res.data.msg)
              }
            }).finally()
      },
      Sign(){
        axios.post("http://localhost:8081/Sign",this.signData)
            .then((res)=>{
              if(res.data.flag){
                this.$message.success(res.data.msg);
              }else{
                this.$message.error(res.data.msg)
              }
            }).finally()
      },
    },
    data() {
      return {
        formData:{
          account:'',
          password:'',
        },
        signData:{
          account: '',
          password: '',
          passwordTo: '',
        },
      }
    }
  }
</script>

<style scoped>
#main{
  width: 500px;
  height: 350px;
  margin-top: 10px;
  margin-bottom: auto;
  margin-left: auto;
  margin-right: auto;
}
.el-tabs{
  width: 500px;
  height: 350px;
}
h1{
  margin-top: 120px;
  text-align: center;
  color: burlywood;
}
h4{
  margin-top: 5px;
  color: burlywood;
}
</style>