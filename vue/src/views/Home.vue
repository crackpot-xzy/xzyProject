<template>
  <Header></Header>
  <div>
  <div id="lunbo">
    <el-carousel :interval="1500" type="card" height="400px">
      <el-carousel-item v-for="item in imgItem" :key="item.src">
        <img :src="item" style="width:100%;height: 380px;padding-top: 15px"/>
      </el-carousel-item>
    </el-carousel>
  </div>
    <div id="wenben">
      <h1 class="txt">欢迎使用网络舆情分析系统</h1>
      <li>简单易用</li>
      <li>舆情分析</li>
      <li>辅助决策</li>
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  name: "Home",
  components: {Footer, Header},
  data(){
    return{
      imgItem:[
          require('@/assets/img1.png'),
          require('@/assets/img2.jpg'),
          require('@/assets/img3.jpg')
      ]
    }
  }
}

</script>

<style scoped>

#wenben{
  height:180px;
  text-align: center;
  color: dimgray;
}
#lunbo{
  margin-left: 10px;
  margin-right: 10px;
}
li{
  padding-bottom: 12px;
  font-size: larger;
}
h1{
  margin-top: 0px;
}
</style>