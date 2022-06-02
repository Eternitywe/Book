<template>
  <div>
    <table>
      <tr>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
      </tr>
      <tr v-for="item in this.books">
        <td>{{item.id}}</td>
        <td>{{item.name}}</td>
        <td>{{item.author}}</td>
        <td>{{item.publish}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BookMessage",
  data(){
    return{
      books:[]
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/book/findAll').then(function(resp){
      console.log(resp.data)
      _this.books = resp.data;
    })
  }
}
</script>

<style scoped>

</style>