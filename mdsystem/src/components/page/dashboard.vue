<!--这是最左边的目录-->
<template>
  <div>
    <el-container style="height: 800px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

        <el-menu :default-openeds="['1', '5']" router >
          <template>
            
          </template>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>参与人信息导入</template>
            <el-menu-item-group>
              <el-menu-item index="participantinformationdefinition">参与人信息导入定义</el-menu-item>
              <el-menu-item index="participantinformationimport">参与人信息导入</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>显示</template>
            <el-menu-item-group>
              <el-menu-item index="showcontentdefinition">大屏显示内容定义</el-menu-item>
              <el-menu-item index="start">开始摇号</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>设置中签人数</template>
            <el-menu-item-group>
              <el-menu-item index="setwin">设置单次中签人数</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          
        </el-menu>
      </el-aside>

      <el-container>
        <router-view></router-view>
        <!--<el-header style="text-align: right; font-size: 12px">-->
          <!--<el-dropdown>-->
            <!--<i class="el-icon-setting" style="margin-right: 15px"></i>-->
            <!--<el-dropdown-menu slot="dropdown">-->
              <!--<el-dropdown-item>查看</el-dropdown-item>-->
              <!--<el-dropdown-item>新增</el-dropdown-item>-->
              <!--<el-dropdown-item>删除</el-dropdown-item>-->
            <!--</el-dropdown-menu>-->
          <!--</el-dropdown>-->
          <!--<span>王小虎</span>-->
        <!--</el-header>-->

        <!--<el-main>-->
          <!---->
          <!--&lt;!&ndash;<el-table :data="tableData">&ndash;&gt;-->
            <!--&lt;!&ndash;<el-table-column prop="date" label="日期" width="140">&ndash;&gt;-->
            <!--&lt;!&ndash;</el-table-column>&ndash;&gt;-->
            <!--&lt;!&ndash;<el-table-column prop="name" label="姓名" width="120">&ndash;&gt;-->
            <!--&lt;!&ndash;</el-table-column>&ndash;&gt;-->
            <!--&lt;!&ndash;<el-table-column prop="address" label="地址">&ndash;&gt;-->
            <!--&lt;!&ndash;</el-table-column>&ndash;&gt;-->
          <!--&lt;!&ndash;</el-table>&ndash;&gt;-->
        <!--</el-main>-->
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {//只导出一个默认模块
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>

<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
.el-menu{
  color: #800324;
  border-right: #12169d;
}
  .el-aside {
    color: #28679d;
  }
</style>
