<template>

  <div class="login">

    <el-form :model="loginForm" status-icon :rules="rules" ref="loginForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="账号" prop="sysname">
        <el-input type="text" v-model="loginForm.sysname"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="syspassword">
        <el-input type="syspassword" v-model="loginForm.syspassword" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
        <el-button @click="resetForm('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>

  export default {
    data() {

      return {
       loginForm: {
          sysname: 'admin',
          syspassword: 'admin',

        },
        rules: {
          sysname: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],
          syspassword: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],

        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let _this= this;
            this.axios.get('/api/systemuser/selectSystem',{
              params:{
                sys_name:_this.loginForm.sysname,
                sys_password:_this.loginForm.syspassword
              }
            }).then(response=>{
              console.log(response);
              if(response.data.code===1){
               this.$message({
                 message:response.data.message,
               })
                this.$router.push({path:'/dashboard'})//跳转到/dashboard 主界面
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

</style>
