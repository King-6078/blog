import Vue from 'vue'
import VueRouter from 'vue-router'
import LX1 from '../views/lx1'
import LX2 from '../views/lx2'
import LX4 from '../views/lx4'
import INDEX from '../views/index'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: "首页",
    component: INDEX,
    show:true
  },
  {
    path: "/",
    name: "博客管理",
    component: INDEX,
    show:true,
    children: [
      {
        path: "lx1",
        name: "查询博客",
        component: LX1
      },
      {
        path: "lx4",
        name: "添加博客",
        component: LX4
      }
    ]
  },
  {
    path: "/lx2",
    component: LX2,
    show:false
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
