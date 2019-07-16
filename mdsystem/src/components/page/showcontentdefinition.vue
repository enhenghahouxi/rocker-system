<template>
  <div class="kehulb">
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
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="300px" class="demo-ruleForm">

        <el-form-item label="大屏幕显示内容定义" prop="type1">
          <el-checkbox-group v-model="ruleForm.type1">
            <el-checkbox label="显示中签人的信息" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>

        <el-form-item label="" prop="type2">
          <el-checkbox-group v-model="ruleForm.type2">
            <el-checkbox label="显示未中签的人的信息" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </div>
</template>

<script>


  export default {
    data() {
      return {
        ruleForm:{
          type1: [],
          type2:[]
        },
        rules:{

        }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let _this= this;
            this.axios.get('/api/participant/showcontentdefinition?showcontentdefinition1='
            +_this.ruleForm.type1
            +'&showcontentdefinition2='+_this.ruleForm.type2
            ).then(response=>{
              console.log(response);
              if(response.data.code===1){
               this.$message({
                 message:response.data.message,
               })
              }else{
                  this.$message(
                    {
                          message:response.data.message,
                      type:'error'
                    })
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    
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
