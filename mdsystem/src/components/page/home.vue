<!--这是上面的一行-->
<template>
    <div class="home">
      <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
      <i class="el-icon-setting" style="margin-right: 15px"></i>
      <el-dropdown-menu slot="dropdown">
      <el-dropdown-item>查看</el-dropdown-item>
      <el-dropdown-item>新增</el-dropdown-item>
      <el-dropdown-item>删除</el-dropdown-item>
      </el-dropdown-menu>
      </el-dropdown>
      <span>嗯哼哈吼嘻</span>
      </el-header>
    </div>
</template>

<script>
    export default {
        name: "home"
    }
</script>

<style scoped>

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  .home{
    width:100%;
  }
</style>
