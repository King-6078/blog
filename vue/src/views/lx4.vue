<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

    <el-form-item label="id" prop="id">
      <el-input v-model="ruleForm.id"></el-input>
    </el-form-item>

    <el-form-item label="姓名" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>

    <el-form-item label="年龄" prop="age">
      <el-input v-model="ruleForm.age"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        id:'',
        name: '',
        age: ''
      },
      rules: {
        id: [
          { required: true, message: '请输入id', trigger: 'blur' },
        ],
        name: [
          { required: true, message: '请输入名字', trigger: 'blur' },
        ],
        age: [
          { required: true, message: '请输入年龄', trigger: 'blur' },
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this=this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8082/lx/save',this.ruleForm).then(function (resp){
            if(resp.data=='success'){
              _this.$alert(''+_this.ruleForm.name+'添加成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/lx1')
                }
              })
/*              _this.$message({
                message: '恭喜你，添加成功',
                type: 'success'
              });*/
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