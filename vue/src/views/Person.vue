<template>
  <Header></Header>
  <h2>个人信息</h2>
  <div style="display: flex;justify-content: center;margin-top: 30px">
    <h4>昵称：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="input1"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>账户：</h4>
    <el-input disabled
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="input1"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>密码：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="input1"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>地址：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="input1"
        clearable>
    </el-input>
  </div>
  <div style="display: flex;justify-content: center;margin-top: 10px">
    <h4>邮箱：</h4>
    <el-input
        style="width: 250px;height: 35px"
        placeholder=""
        v-model="input1"
        clearable>
    </el-input>
  </div>
  <el-button type="primary" style=" margin-left:690px;margin-top:15px;margin-bottom:180px;width: 100px">修改</el-button>
  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
export default {
  name: "Person",
  components: {Footer,Header},
  data(){
    return{
      input1:'',
      input2:'',
      input3:'',
      input4:'',
      input5:'',

    }
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