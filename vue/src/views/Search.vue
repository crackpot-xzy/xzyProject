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
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="selectDateByTime"><el-icon><CaretLeft /></el-icon>条件查询</el-button>
    <el-button type="warning" style=" margin-left:10px;margin-top:-5px;width: 100px" @click="selectAllDate"><el-icon><List /></el-icon>查询全部</el-button>
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
        prop="created"
        label="日期"
        width="180">
    </el-table-column>
    <el-table-column
        prop="text"
        :show-overflow-tooltip="true"
        label="评论">
    </el-table-column>
  </el-table>
  <el-pagination
      class="pagination"
      @current-change="handleCurrentChange"
      :current-page="pagination.currentPage"
      :page-size="pagination.pageSize"
      background
      layout="total,prev,pager, next,jumper"
      style="margin-top: 10px;justify-content: center;"
      :total="pagination.total"
  >
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
      flag:0,
      tableData: [],
      pagination: {//分页相关模型数据
        currentPage: 1,//当前页码
        pageSize:20,//每页显示的记录数
        total:0,//总记录数
        text: "",
        created: "",
      }
    }
  },
  methods: {
    indexMethod(index) {
      return index+1;
    },
    //根据时间分页查询
    selectAllDate(){
        this.flag=0;
        axios.get("http://localhost:8081/Search/selectDate/"+this.pagination.currentPage+"/"+this.pagination.pageSize)
            .then((res)=>{
              this.tableData = res.data.data.records;
              console.log(res.data.data);
              this.pagination.currentPage = res.data.data.current;
              this.pagination.total = res.data.data.total;
              // this.$message.success(res.data.msg)
            }).finally()
    },
    selectDateByTime(){
        this.flag=1;
        axios.get("http://localhost:8081/Search/selectDate/"+this.pagination.currentPage+"/"+this.pagination.pageSize+"/"+this.time)
            .then((res)=>{
              this.tableData = res.data.data.records;
              console.log(res.data.data);
              this.pagination.currentPage = res.data.data.current;
              this.pagination.total = res.data.data.total;
              // this.$message.success(res.data.msg)
            }).finally()
    },
    deleteDate(){
      axios.get("http://localhost:8081/Search/delete")
          .then((res)=>{
            this.$message.success(res.data.msg);
          }).finally()
    },
    //切换页码
    handleCurrentChange(currentPage) {
      //修改页码值为当前选中的页码值
      this.pagination.currentPage = currentPage;
      //执行查询
      if (this.flag===0){
        this.selectAllDate();
      }else{
        this.selectDateByTime();
      }

    },
  }
}
</script>

<style scoped>
</style>