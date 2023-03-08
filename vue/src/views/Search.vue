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
        end-placeholder="结束日期"
    >
    </el-date-picker>
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="selectDate">查询</el-button>
    <el-button type="danger" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="deleteDate"><el-icon><DeleteFilled /></el-icon>清空数据</el-button>
  </div>
  <el-table
      :data="tableData"
      border
      stripe
      style="width: 90%;height:500px;margin-left: auto;margin-right: auto;margin-top: 25px;">
    <el-table-column
        label="序号"
        width="180"
        type="index"
        fixed
        :index="indexMethod">
    </el-table-column>
    <el-table-column
        sortable
        prop="date"
        label="日期"
        width="180">
    </el-table-column>
    <el-table-column
        prop="txt"
        :show-overflow-tooltip="true"
        label="评论">
    </el-table-column>
  </el-table>
  <el-pagination
      background
      layout="prev, pager, next"
      style="margin-left: 500px;margin-top: 10px"
      :total="1000">
  </el-pagination>
  <Footer></Footer>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import axios from "axios";
export default {
  name: "Search",
  components: {Footer, Header},
  data() {
    return {
      time: {
      },
      tableData: [
          {
        date: '2016-05-02',
        name: '王小虎',
        txt: '湖南师范大学考研有没有考951的uu啊，公有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的   共课得160，333我感觉改的挺宽容的，我感觉951太让我心碎了，只空了一道15分的题，题目都是会的，结果比45分没写的333分还低🙃349还有缘复试吗'
      },
        {
        date: '2016-06-02',
        name: '',
        txt: '湖，只空了一道15分的题，题目都是会的，结果比45分没写的333分还低🙃349还有缘复试吗'
      }, {
        date: '2016-05-02',
        name: '王小虎',
        txt: '湖南师范大学考研有没有考951的uu啊，公共课得160，333我感觉改的挺宽容的，我感觉951太让我心碎了，只空了一道15分的题，题目都是会的，结果比45分没写的333分还低🙃349还有缘复试吗'
      }
      ]
    }
  },
  methods: {
    indexMethod(index) {
      return index+1;
    },
    selectDate(){
      axios.post("http://localhost:8081/Search/selectDate",this.time)
          .then((res)=>{
            this.$message.success(res.data.msg);
          }).finally()
    },
    deleteDate(){
      axios.get("http://localhost:8081/Search/delete")
          .then((res)=>{
            this.$message.success(res.data.msg);
          }).finally()
    },
  }
}
</script>

<style scoped>

</style>