import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/views/Login";

const routes = [
  {
    path: '/',
    name: 'Login',
    component:Login,
    children:[{
      path: '/Login',
      name: 'Login',
      component:() => import('@/views/Login.vue')
    }]
  },
  {
    path: '/Home',
    name: 'Home',
    component:() => import('@/views/Home.vue')
  },
  {
    path: '/Analysis',
    name: 'Analysis',
    component:() => import('@/views/Analysis.vue')
  },
  {
    path: '/Search',
    name: 'Search',
    component:() => import('@/views/Search.vue')
  },
  {
    path: '/Upload',
    name: 'Upload',
    component:() => import('@/views/Upload.vue')
  },
  {
    path: '/Person',
    name: 'Person',
    component:() => import('@/views/Person.vue')
  },
  {
    path: '/Record',
    name: 'Record',
    component:() => import('@/views/Record.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
