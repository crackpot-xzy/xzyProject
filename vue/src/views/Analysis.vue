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
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px"><el-icon><CaretLeft /></el-icon>条件分析</el-button>
    <el-button type="warning" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="getAll"><el-icon><List /></el-icon>分析全部</el-button>
    <el-button type="success" style=" margin-left:10px;margin-top:-5px;width: 120px"><el-icon><Management /></el-icon>分析结果保存</el-button>

  </div>
  <div style="height: 540px;display: flex;margin-top: 15px">
<!--    margin-right: auto;margin-left: auto-->
    <div id="echartsWordcloud" style="height: 540px;width: 800px;"></div>
    <div id="echartsPie" style="height: 540px;width: 800px;"></div>
<!--    <div style="background-color: paleturquoise;height: 540px;width: 500px"></div>-->
  </div>
  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
import axios from "axios";
export default {
  name: "Analysis",
  components: {Footer, Header},
  data() {
    return {
      value1: '',
      dataList: [],
    }
  },

  methods: {
    getAll() {
      this.getAllKeyWords();
    },
    getAllKeyWords() {
      this.$message.info("进行中...");
      axios.get("http://localhost:8081/Analysis/all")
          .then((res) => {
            console.log(res.data);
            this.dataList = res.data.data;
            this.$message.success(res.data.msg);
            this.initCloudEcharts(res.data.data);
            this.initPieEcharts(res.data.data);
          }).finally()
    },
    getAllKeyWordsByTime() {
      this.$message.info("进行中...");
      axios.get("http://localhost:8081/Analysis/byTime/")
          .then((res) => {
            console.log(res.data);
            this.dataList = res.data.data;
            this.$message.success(res.data.msg);
            this.initCloudEcharts(res.data.data);
            this.initPieEcharts(res.data.data);
          }).finally()
    },

    initCloudEcharts(data) {
      // echarts-wordcloud
      let echartsWordcloud = this.$echarts.init(document.getElementById("echartsWordcloud"));
      let option = {
        series: [
          {
            type: "wordCloud",
            //用来调整词之间的距离
            gridSize: 10,
            //用来调整字的大小范围
            sizeRange: [28, 70],
            rotationRange: [0,0],
            // 字体颜色
            textStyle: {
              fontFamily: '微软雅黑',
              color: function () {
                var colors = ['#fda67e', '#81cacc', '#cca8ba', "#88cc81", "#82a0c5", '#fddb7e', '#735ba1', '#bda29a', '#6e7074', '#546570', '#c4ccd3'];
                return colors[parseInt(Math.random() * 10)];
              }
            },
            //位置相关设置
            left: "center",
            top: "center",
            right: null,
            bottom: null,
            width: "100%",
            height: "100%",
            //数据
            data: data
          }
        ]
      };
      echartsWordcloud.setOption(option);
    },

    initPieEcharts(data){
      let echartsPie = this.$echarts.init(document.getElementById("echartsPie"));
      let option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          // orient: 'vertical',
          top: '1%',
          left: 'center',
          itemHeight: 20,
          //内容过多，设置分页
          type:'scroll',
          pageButtonPosition:'end',
          pageIconColor:'#3ba1ff',
          pageIconInactiveColor:'#7f7f7f',
          pageIconSize:15,

        },
        series: [
          {
            name: data.name,
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: data
          }
        ]
      };
      echartsPie.setOption(option);
    },
    getSort(data){

    }
  }
}
</script>

<style scoped>

</style>