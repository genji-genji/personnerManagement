import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'
import Entry from '../components/Entry'
import Depart_new from '../components/depart/Depart_new'
import Welcome from '../components/Welcome'

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
      component:Home,
      redirect:'/Welcome',
      children:[
        {
          path:'/Welcome',
          component:Welcome
        },
        {
          path: '/2-1',
          component:Depart_new
        }
      ]
    },
    {
      path: '/Entry',
      component:Entry
    }
  ]
})
