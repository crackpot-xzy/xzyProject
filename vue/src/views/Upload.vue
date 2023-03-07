<template>
  <Header></Header>
  <div style="height: 560px">
    <el-tabs type="border-card"
             style="width: 700px;margin-top: 50px;margin-right: auto;margin-left: auto;height: 450px;background-color: whitesmoke"
    >
      <el-tab-pane label="人工输入">

        <div style="display: flex;justify-content: center;margin-top: 30px" :model="inputByU">
          <h4>文本：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="请输入文本信息"
              v-model="inputByU.text"
              clearable>
          </el-input>
        </div>
        <div style="display: flex;justify-content: center;margin-top: 5px">
          <h4>编号：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="文本编号"
              v-model="inputByU.id"
              clearable>
          </el-input>
        </div>
        <div style="display: flex;justify-content: center;margin-top: 5px">
          <h4>点赞：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="点赞数"
              v-model="inputByU.attitudes"
              clearable>
          </el-input>
        </div>
        <div style="display: flex;justify-content: center;margin-top: 5px">
          <h4>评论：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="评论数"
              v-model="inputByU.comments"
              clearable>
          </el-input>
        </div>
        <div style="display: flex;justify-content: center;margin-top: 5px">
          <h4>转发：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="转发数"
              v-model="inputByU.reposts"
              clearable>
          </el-input>
        </div>
        <div style="display: flex;justify-content: center;margin-top: 5px">
          <h4>时间：</h4>
          <el-input
              style="width: 250px;height: 35px;"
              placeholder="时间"
              v-model="inputByU.time"
              clearable>
          </el-input>
        </div>
        <div>
          <el-button type="primary" style="margin-left: 280px;margin-top:30px;width: 100px" @click="userTo">确认</el-button>
        </div>
      </el-tab-pane>
      <el-tab-pane label="表格导入">
        <el-upload
            style="margin-top: 100px;width: 350px;margin-left: 160px"
            class="upload-demo"
            drag
            action="https://jsonplaceholder.typicode.com/posts/"
            multiple>
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">在此处上传.csv文件</div>
        </el-upload>
      </el-tab-pane>
      <el-tab-pane label="爬取数据">
        <div style="margin-top: 100px">
        <h4>系统支持爬虫脚本自动爬取网页数据。</h4>
        <h4>如：可在weiboSpider目录的settings.py文件中进行相应配置，
          并在该目录下运行‘scrapy crawl search’命令，程序将会把爬取的微博数据直接写入数据库中，点击下方按钮会将爬取的数据导入待处理的数据表中。</h4>
          <div>
            <el-button type="primary" style="margin-left: 280px;margin-bottom:10px;width: 100px" @click="spiderTo">导入爬取数据</el-button>
          </div>
          <h4 >（用户也可根据需求自行配置相应脚本程序。）</h4>
        </div>
      </el-tab-pane>
    </el-tabs>
  </div>
  <Footer></Footer>
</template>

<script>
import Footer from "@/components/Footer";
import Header from "@/components/Header";
import axios from "axios";
import store from "@/store";
import router from "@/router";

export default {
  name: "Upload",
  components: {Footer,Header},
  data(){
    return{
      inputByU:{
        id:'',
        text: '',
        attitudes:'0',
        comments: '0',
        reposts: '0',
        time:'',
      }
    }
  },
  methods:{
    spiderTo(){
      axios.get("http://localhost:8081/Upload/SpiderTo")
          .then((res)=>{
              this.$message.success(res.data.msg);
          }).finally()
    },
    userTo(){
      axios.post("http://localhost:8081/Upload/UserTo",this.inputByU).then((res)=>{
        if(res.data.flag){
          this.$message.success(res.data.msg);
        }else{
          this.$message.error(res.data.msg);
        }
      }).finally()
    }
  }
}
</script>

<style scoped>
h4{
  margin-top: 5px;
  color: dimgray;
  text-align: center;
}
</style>