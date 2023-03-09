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
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px"><el-icon><CaretLeft /></el-icon>查询</el-button>
      <el-date-picker
          v-model="value2"
          type="date"
          placeholder="按操作日期查询"
          :size="size"
          style="margin-left: 40px;margin-bottom: 5px;width:200px"
      />
    <el-button type="primary" style=" margin-left:10px;margin-top:-5px;width: 100px"><el-icon><CaretLeft /></el-icon>查询</el-button>
    <el-button type="warning" style=" margin-left:10px;margin-top:-5px;width: 100px"><el-icon><List /></el-icon>查看全部</el-button>
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
    <el-table-column
        sortable
        prop="emo"
        label="情感"
        width="180">
    </el-table-column>
    <el-table-column
        sortable
        prop="edit"
        label="操作日期"
        width="180">
    </el-table-column>
  </el-table>
  <el-pagination
      background
      layout="prev, pager, next"
      style="justify-content: center;margin-top: 10px"
      :total="1000">
  </el-pagination>
  <Footer></Footer>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
export default {
  name: "Record",
  components: {Footer, Header},
  data() {
    return {
      value1: '',
      value2: '',
      size:'',
      input1: '',
      tableData: [
          {
            date: '2016-05-02',
            name: '王小虎',
            txt: '湖南师范大学考研有没有考951的uu啊，公有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的有考951的uu啊，公共课得160，333我感觉改的   共课得160，333我感觉改的挺宽容的，我感觉951太让我心碎了，只空了一道15分的题，题目都是会的，结果比45分没写的333分还低🙃349还有缘复试吗',
            emo: 'good',
            edit: '2016-01-01',
          },
      ]
    }
  },
  methods: {
    indexMethod(index) {
      return index+1;
    }
  }
}
</script>

<style scoped>

</style>