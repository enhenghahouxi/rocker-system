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
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="200px" class="demo-ruleForm">
        <el-form-item label="参与人姓名" prop="participantname">
          <el-input type="text" v-model="ruleForm.participantname"></el-input>
        </el-form-item>
        <el-form-item label="参与人电话" prop="participanttelephone">
          <el-input type="text" v-model="ruleForm.participanttelephone"></el-input>
        </el-form-item>
        <el-form-item label="参与人身份证号" prop="participantidentifyid">
          <el-input type="text" v-model="ruleForm.participantidentifyid"></el-input>
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
            participantname: '',
            participantphone: '',
            participantidentifyid: ''
          }
        }
      },
      methods: {
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let _this= this;
              this.axios.get('/api/participant/participantinformationimport',{
                params:{
                  participantname:_this.ruleForm.participantname,
                  participanttelephone:_this.ruleForm.participanttelephone,
                  participantidentifyid:_this.ruleForm.participantidentifyid
                }
              }).then(response=>{
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
