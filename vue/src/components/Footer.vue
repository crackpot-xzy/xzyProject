<template>
  <div id="line">
    <el-divider border-style="dashed" />
  </div>
  <div id="foot">
    <h6>浙大城市学院|计算学院|计算机科学与技术|31903139@xzy</h6>
  </div>
</template>

<script>
export default {
  name: "Footer"
}
</script>

<style scoped>
#foot{
  margin-top: -20px;
  height: 25px;
  background-color: antiquewhite;
}
#line{
  margin-top: -15px;
}
h6{
  padding-top: 5px;
  text-align: center;
}
</style>