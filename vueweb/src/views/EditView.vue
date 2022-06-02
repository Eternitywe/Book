<template>
  <div id="editBook">
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="图书编号" prop="id">
        <el-input v-model="ruleForm.id" readonly="true"></el-input>
      </el-form-item>
      <el-form-item label="图书名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publish">
        <el-input v-model="ruleForm.publish"></el-input>
      </el-form-item>
      <el-form-item label="图书页数" prop="pages">
        <el-input v-model="ruleForm.pages"></el-input>
      </el-form-item>
      <el-form-item label="图书价格" prop="price">
        <el-input v-model="ruleForm.price"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "EditView",
  data() {
    return {
      ruleForm: {
        id:'',
        name: '',
        author: '',
        publish: '',
        pages: '',
        price: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入图书名称', trigger: 'blur' }
        ],
        author: [
          { required: true, message: '请填写作者笔名', trigger: 'blur' }
        ],
        publish: [
          { required: true, message: '请输入图书出版社', trigger: 'blur' }
        ],
        pages: [
          { required: true, message: '请输入图书总页数', trigger: 'blur' }
        ],
        price: [
          { required: true, message: '请输入图书价格', trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    open4() {
      this.$message({
        showClose: true,
        message: '添加图书信息失败...请重新添加',
        type: 'error'
      });
    },
    open2() {
      this.$message({
        showClose: true,
        message: "添加图书信息成功...",
        type: 'success'
      });
    },
    submitForm(formName) {
      const _this = this;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.put('http://localhost:8181/book/update',this.ruleForm).then(function (resp){
            //console.log(resp);
            if (resp.data == 'success'){
              _this.$alert('修改《'+_this.ruleForm.name+'》图书信息成功', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$refs[formName].resetFields();
                  _this.$router.push('/allBook');
                }
              });

            }else{
              _this.open4();
              _this.$refs[formName].resetFields();
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
  created(){
    //alert(this.$route.query.id)
    const _this = this;
    axios.get('http://localhost:8181/book/findById/'+this.$route.query.id).then(function (resp){
      _this.ruleForm = resp.data;
    })
  }
}
</script>

<style scoped>

</style>