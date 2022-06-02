<template>
  <div id="app">
    <el-container>
      <el-header>
        <div id="users">
          <el-dropdown>
            <el-avatar  icon="el-icon-user-solid"></el-avatar>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item>设置中心</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu router :default-openeds="['0','1']">
            <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''">
              <template slot="title">
                <i class="el-icon-setting"></i>
                <span slot="title">{{item.name}}</span>
              </template>
              <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path" :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style>
*{
  margin: 0;
  padding: 0;
}
#users{
  margin-top: 7px;
  float: right;
  margin-right: 10px;
}
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
  line-height: 650px;
  height: 650px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 10px;
}

body > .el-container {
  margin-bottom: 40px;
}

</style>

<script>
export default {

}
</script>