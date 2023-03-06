<template >
  <el-page-header id="header" icon="null" content="网络舆情分析系统">
    <template #title>
      <el-icon><ChromeFilled/></el-icon>
    </template>
  </el-page-header>
  <el-menu
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      router
      :default-active="$route.path"
  >
    <el-menu-item index="/home"><el-icon><HomeFilled /></el-icon>首页</el-menu-item>
    <el-menu-item index="/Person"><el-icon><UserFilled /></el-icon>个人信息</el-menu-item>
    <el-menu-item index="/upload"><el-icon><UploadFilled /></el-icon>信息采集</el-menu-item>
    <el-menu-item index="/Search"><el-icon><Histogram /></el-icon>数据查询</el-menu-item>
    <el-menu-item index="/Analysis"><el-icon><Platform /></el-icon>舆情分析</el-menu-item>
    <el-menu-item index="/Record"><el-icon><Checked /></el-icon>历史记录</el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="/Login" @click="clean">
      <el-icon><SwitchButton /></el-icon>
      退出系统
    </el-menu-item>
  </el-menu>

</template>

<script >
import store from "@/store";

export default {
  name: "Header",
  methods:{
    clean(){
      store.commit("clean");
      // this.$message.info("123"+store.state.userId+1)
    },
  }
}
</script>
<style scoped>
#header{
  background-color: antiquewhite;
}
.el-menu-demo{
  background-color: floralwhite;
}
.flex-grow {
  flex-grow: 1;
}
</style>