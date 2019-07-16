<template>
  <div class="kehu">
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

    <el-main>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>中签人数</span>
          <el-button style="float: right; padding: 3px 0" type="text"></el-button>
        </div>

        <el-table
          :data="tableData1"
          stripe
          style="width: 100%">

          <el-table-column
            prop="par_id"
            label="id"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_name"
            label="姓名"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_telephone"
            label="电话"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_identityid"
            label="身份证号"
            width="180">
          </el-table-column>
          
          <el-table-column
            prop="par_hasget"
            label="是否中签(1为中签，0未中签)"
            width="180">
          </el-table-column>

        </el-table>

        <div>
          <span>未中签人数</span>
        </div>
        <el-table
          :data="tableData2"
          stripe
          style="width: 100%">

          <el-table-column
            prop="par_id"
            label="id"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_name"
            label="姓名"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_telephone"
            label="电话"
            width="180">
          </el-table-column>

          <el-table-column
            prop="par_identityid"
            label="身份证号"
            width="180">
          </el-table-column>
          
          <el-table-column
            prop="par_hasget"
            label="是否中签(1为中签，0未中签)"
            width="180">
          </el-table-column>

        </el-table>

      </el-card>
    </el-main>
  </div>
</template>

<script>
import axios from 'axios'

  export default {
    created(){//显示出html之前先渲染
      // this.$store.dispatch('GET_CUSTOMERLIST')
      // store.dispatch('GET_CUSTOMERLIST').then(()=>{
      //   console.log('数据：',store.state.customerlist)
      // })

      // axios.get('/api/participant/selectAllHasGetPariticipant').then(res=>{
      //   console.log(res.data.data)
      //   this.tableData1=res.data.data;
      // })
      this.$store.dispatch('GET_HASGETLIST').then(()=>{
        this.tableData1=this.$store.state.hasgetlist;
      }),
      this.$store.dispatch('GET_HASNOTGETLIST').then(()=>{
        this.tableData2=this.$store.state.hasnotgetlist;
      })

      
    },
    methods: {

    },
    data() {
      return {
        tableData1: [],
        tableData2: []
      }
    }
  }
</script>

<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  .kehu{
    width:100%;
  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }


</style>
