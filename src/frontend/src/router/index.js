import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'TopView',
    component:()=>import('../views/TopView.vue')
  },
  {
    path: '/home',
    name: 'HomeView',
    component: ()=>import('../views/HomeView.vue')
  },
  {
    path: '/login',
    name: 'LoginForm',
    component: ()=>import('../views/LoginForm.vue')
  },
  {
    path: '/logout',
    name: 'LogoutView',
    component:()=>import('../views/LogoutView.vue')
  },
  {
    path: '/sign-up',
    name: 'SignUp',
    component:()=>import('../views/SignUp.vue')
  },
  {
    path: '/profile',
    name: 'ProfileView',
    component:()=>import('../views/ProfileView.vue')
  },
  {
    path: '/showLoginInfo',
    name: 'showLoginInfo',
    component:()=>import('../views/ShowLoginInfo.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
