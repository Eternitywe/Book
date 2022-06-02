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
          label="图书价格(/元)">
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
  name: "AllBook",
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
    }
  }
}
</script>

<style scoped>

</style>