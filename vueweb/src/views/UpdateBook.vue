<template>
<div>
  <template>
    <el-table
        :data="tableData"
        stripe
        style="width: 100%">
      <el-table-column
          prop="id"
          label="图书编号"
          width="180">
      </el-table-column>
      <el-table-column
          prop="name"
          label="书名"
          width="180">
      </el-table-column>
      <el-table-column
          prop="author"
          label="作者">
      </el-table-column>
      <el-table-column
          prop="publish"
          label="出版社">
      </el-table-column>
      <el-table-column
          prop="price"
          label="图书价格">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="eidt(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </template>
  <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      style="margin-top: 10px"
      @current-change="page"
      page-size="8">
  </el-pagination>
</div>
</template>

<script>
export default {
  name: "UpdateBook",
  created() {
    const _this = this;
    axios.get("http://localhost:8181/book/findAll/1/8").then(function (resp){
      // console.log(resp)
      _this.tableData = resp.data.content;
      _this.total = resp.data.totalElements;
    })
  },
  data(){
    return{
      total:null,
      tableData: null
    }
  },
  methods:{
    page(currentPage){
      const _this = this;
      axios.get('http://localhost:8181/book/findAll/'+currentPage+'/8').then(function (resp){
        // console.log(resp)
        _this.tableData = resp.data.content;
        _this.total = resp.data.totalElements;
      })
    },
    eidt(row) {
      //console.log(row);
      this.$router.push({
        path: '/edit',
        query:{
          id:row.id
        }
      });
    },
    deleteBook(row){
      const _this = this;
      axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function (resp){
          _this.$alert('删除《'+row.name+'》图书信息成功', '消息', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload();
            }
          });
      })
    }
  }
}
</script>

<style scoped>

</style>