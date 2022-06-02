import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name:'所有书籍',
    component: () => import('../views/Index'),
    redirect:"/allBook",
    children:[
      {
        path: '/allBook',
        name:'查看书籍',
        component: () => import('../views/AllBook')
      }
    ]
  },
  {
    path: '/',
    name:'修改书籍',
    component: () => import('../views/Index'),
    children:[
      {
        path: '/addBook',
        name:'增加书籍',
        component: () => import('../views/AddBook')
      },
      {
        path: '/updateBook',
        name:'修改 / 删除书籍',
        component: () => import('../views/UpdateBook')
      },
      {
        path: '/edit',
        name:'图书编辑器',
        component: () => import('../views/EditView')
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
