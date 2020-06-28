import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'',
      redirect:'/login'
    },
    {
       path: '/login',
       component:Login
     },
     {
      path: '/Home',
      component:Home
    }
  ]
})
