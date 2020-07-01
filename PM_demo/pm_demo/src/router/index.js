import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'
import Entry from '../components/Entry'
import Depart_new from '../components/depart/Depart_new'
import Welcome from '../components/Welcome'
import Depart_re from '../components/depart/Depart_re'
import Depart_re_dep from '../components/depart/Depart_re_dep'
// eslint-disable-next-line camelcase
import Select_person from '../components/depart/Select_person'
import Person_news from '../components/depart/Person_news'
import Post_new from '../components/post/Post_new'
import Post_re from '../components/post/Post_re'
import Post_re_rel from '../components/post/Post_re_rel'
import Select_post from '../components/post/Select_post'
import Select_news from '../components/post/Select_news'
import Report_new from '../components/report/Report_new'
import Report_leave from '../components/report/Report_leave'
import Report_dep from '../components/report/Report_dep'
import Report_post from '../components/report/Report_post'
import Report_people from '../components/report/Report_people'
import staff_quit from "../components/staff_quit";
import quitStaff from "../components/depart/quitStaff";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '',
      redirect: '/login'
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/Home',
      component: Home,
      redirect: '/Welcome',
      children: [
        {
          path: '/Welcome',
          component: Welcome
        },
        {
          path: '/1-1',
          component: Entry
        },
        {
          path:'/1-2',
          component: staff_quit
        },
        {
          path:'/1-3',
          component: quitStaff
        },
        {
          path: '/2-1',
          component: Depart_new
        },
        {
          path: '/2-2',
          component: Depart_re
        },
        {
          path: '/Depart_re_dep',
          component: Depart_re_dep
        },
        {
          path: '/2-3',
          component: Select_person
        },
        {
          path: '/Person_news',
          component: Person_news
        },
        {
          path: '/3-1',
          component: Post_new
        },
        {
          name:'Post_re_rel',
          path: '/Post_re_rel',
          component: Post_re_rel
        },
        {
          name: 'Post_re',
          path: '/3-2',
          component: Post_re
        },
        {
          path: '/3-3',
          component: Select_post
        },
        {
          name: 'Select_news',
          path: '/Select_news',
          component: Select_news
        },
        {
          path: '/4-1',
          component: Report_new
        },
        {
          path: '/4-2',
          component: Report_leave
        },
        {
          path: '/4-3',
          component: Report_dep
        },
        {
          path: '/4-4',
          component: Report_post
        },
        {
          path: '/4-5',
          component: Report_people
        }
      ]
    },
    {
      path: '/Entry',
      component: Entry
    }
  ]
})
