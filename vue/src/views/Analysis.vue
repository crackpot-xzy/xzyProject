<template>
  <Header></Header>
  <div class="block">
    <el-date-picker
        style="margin-top: 20px;margin-left: 80px;margin-bottom: -10px"
        v-model="time"
        value-format="YYYY-MM-DD hh:mm:ss"
        type="datetimerange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
    </el-date-picker>
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="getByTime"><el-icon><CaretLeft /></el-icon>条件分析</el-button>
    <el-button type="warning" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="getAll"><el-icon><List /></el-icon>分析全部</el-button>
    <el-button type="success" style=" margin-left:10px;margin-top:-5px;width: 120px" @click="saveToRecord"><el-icon><Management /></el-icon>分析结果保存</el-button>

  </div>

  <div style="height: 540px;display: flex;margin-top: 15px">
    <!--    margin-right: auto;margin-left: auto-->
    <div class="charts" id="echartsHot" style="height: 540px;width: 780px;"></div>
    <div class="charts" id="echartsEmo" style="height: 540px;width: 780px;"></div>
  </div>

  <div style="height: 540px;display: flex;margin-top: 15px;margin-bottom: 10px">
    <div class="charts" id="echartsWordcloud" style="height: 540px;width: 780px;"></div>
    <div class="charts" id="echartsPie" style="height: 540px;width: 780px;margin-left: 10px"></div>
  </div>

  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
import axios from "axios";
import store from "@/store";
export default {
  name: "Analysis",
  components: {Footer, Header},
  data() {
    return {
      time: '',
      //热度指数最大刻度
      max:1000,
    }
  },

  methods: {
    getAll() {
      this.$message.info("进行中...");
      this.getAllKeyWords();
      this.getAllHot();
      this.getAllEmo();
    },
    getByTime() {
      this.$message.info("进行中...");
      this.getKeyWordsByTime();
      this.getHotByTime();
      this.getEmoByTime();
    },
    saveToRecord(){
      axios.get("http://localhost:8081/Analysis/save").then((res)=>{
        console.log(res.data);
        this.$message.success(res.data.msg);
      })
    },
    // 热度
    getAllHot(){
      axios.get("http://localhost:8081/Analysis/all/hot").then((res)=>{
        console.log(res.data);
        this.initHotEcharts(res.data.data);
        this.$message.success(res.data.msg);
      })
    },
    getHotByTime(){
      axios.get("http://localhost:8081/Analysis/byTime/hot/"+this.time).then((res)=>{
        console.log(res.data);
        this.initHotEcharts(res.data.data);
        this.$message.success(res.data.msg);
      })
    },
    // 关键词、词频 对应饼图和词云图
    getAllKeyWords() {
      axios.get("http://localhost:8081/Analysis/all")
          .then((res) => {
            console.log(res.data);
            this.initCloudEcharts(res.data.data);
            this.initPieEcharts(res.data.data);
            this.$message.success(res.data.msg);
          }).finally()
    },
    getKeyWordsByTime() {
      axios.get("http://localhost:8081/Analysis/byTime/"+this.time)
          .then((res) => {
            console.log(res.data);
            this.initCloudEcharts(res.data.data);
            this.initPieEcharts(res.data.data);
            this.$message.success(res.data.msg);
          }).finally()
    },
    //情感分析
    getAllEmo(){
      axios.get("http://localhost:8081/Analysis/all/emo/"+store.state.id)
          .then((res) => {
            console.log(res.data);
            this.initEmoEcharts(res.data.data);
            this.$message.success(res.data.msg);
          }).finally()
    },
    getEmoByTime(){
      axios.get("http://localhost:8081/Analysis/byTime/emo/"+this.time+"/"+store.state.id)
          .then((res) => {
            console.log(res.data);
            this.initEmoEcharts(res.data.data);
            this.$message.success(res.data.msg);
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
    initHotEcharts(data){
      let echartsHot = this.$echarts.init(document.getElementById("echartsHot"));
      let option = {
        series: [
          {
            type: 'gauge',
            center: ['50%', '60%'],
            startAngle: 200,
            endAngle: -20,
            min: 0,
            max: this.max,
            splitNumber: 10,
            itemStyle: {
              color: '#FFAB91'
            },
            progress: {
              show: true,
              width: 30
            },
            pointer: {
              show: false
            },
            axisLine: {
              lineStyle: {
                width: 30
              }
            },
            axisTick: {
              distance: -45,
              splitNumber: 5,
              lineStyle: {
                width: 2,
                color: '#999'
              }
            },
            splitLine: {
              distance: -52,
              length: 14,
              lineStyle: {
                width: 3,
                color: '#999'
              }
            },
            axisLabel: {
              distance: -20,
              color: '#999',
              fontSize: 20
            },
            anchor: {
              show: false
            },
            title: {
              show: false
            },
            detail: {
              valueAnimation: true,
              width: '60%',
              lineHeight: 40,
              borderRadius: 8,
              offsetCenter: [0, '-15%'],
              fontSize: 60,
              fontWeight: 'bolder',
              formatter: '{value} °C',
              color: 'inherit'
            },
            data: [
              {
                value: data,
              }
            ]
          },
          {
            type: 'gauge',
            center: ['50%', '60%'],
            startAngle: 200,
            endAngle: -20,
            min: 0,
            max: this.max,
            itemStyle: {
              color: '#FD7347'
            },
            progress: {
              show: true,
              width: 8
            },
            pointer: {
              show: false
            },
            axisLine: {
              show: false
            },
            axisTick: {
              show: false
            },
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            },
            detail: {
              show: false
            },
            data: [
              {
                value: data,
              }
            ]
          }
        ]
      };
      echartsHot.setOption(option);
    },
    initEmoEcharts(data){
      let echartsEmo = this.$echarts.init(document.getElementById("echartsEmo"));
      let option = {
        xAxis: {
          type: 'category',
          data: ['Good', 'Neutral', 'Bad']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data:data,
            itemStyle: {
              normal: {
                label: {
                  show: true, //开启显示数值
                  position: 'top', //数值在上方显示
                  textStyle: {  //数值样式
                    fontSize: 14  //字体大小
                  }
                },
                color: function(params){
                  var colorList = ['#749f83', '#61a0a8','#c23531'];
                  return colorList[params.dataIndex]
                }
              }
            },
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(180, 180, 180, 0.2)'
            }
          }
        ]
      };
      echartsEmo.setOption(option);
    }
  }
}
</script>

<style scoped>
/*覆盖效果*/
.charts:Hover{
  border:2px dashed navajowhite;
  border-radius: 15px;
  box-shadow: 8px 8px 5px floralwhite;
}
</style>