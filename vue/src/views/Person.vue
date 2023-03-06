<template>
  <Header></Header>
  <h2>个人信息</h2>
  <div :model="person">
  <div style="display: flex;justify-content: center;margin-top: 30px">
    <h4>昵称：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="person.name"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>账户：</h4>
    <el-input disabled
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="person.account"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>密码：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="person.password"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>地址：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="person.address"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>邮箱：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="person.email"
        clearable>
    </el-input>
  </div>
  <div style="text-align: center">
    <el-button type="primary" style="margin-top:15px;margin-bottom:180px; width: 100px">修改</el-button>
  </div>
  </div>
  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
import store from "@/store";
export default {
  name: "Person",
  components: {Footer,Header},
  data(){
    return{
      person:{
        name:store.state.name,
        password:store.state.password,
        account:store.state.account,
        address:store.state.address,
        email:store.state.email,
      },
    }
  },
  methods:{

  }
}
</script>

<style scoped>
h4{
  margin-top: 5px;
  color: dimgrey;
}
h2{
  text-align: center;
  margin-top: 45px;
  color: dimgrey;
}
</style>