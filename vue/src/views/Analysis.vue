<template>
  <Header></Header>
  <div class="block">
    <el-date-picker
        style="margin-top: 20px;margin-left: 80px;margin-bottom: -10px"
        v-model="value1"
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
    </el-date-picker>
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px">舆情分析</el-button>
    <el-button type="success" style=" margin-left:10px;margin-top:-5px;width: 100px">分析结果保存</el-button>

  </div>
  <div style="height: 540px;display: flex;margin-top: 15px">
    <div style="background-color: floralwhite;height: 540px;width: 500px"></div>
    <div style="background-color: blue;height: 540px;width: 500px"></div>
    <div style="background-color: paleturquoise;height: 540px;width: 500px"></div>
  </div>
  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
export default {
  name: "Analysis",
  components: {Footer,Header},
  data(){
    return{
      value1:'',
    }
  }
}
</script>

<style scoped>

</style>