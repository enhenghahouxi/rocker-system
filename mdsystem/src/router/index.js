import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path:'/login',
      component: resolve => require(['../components/page/Login.vue'], resolve),
      meta: { title: '登录'}
    },
    {
      path:'/dashboard',
      component:resolve =>require(['../components/page/dashboard.vue'],resolve),
      meta:{title:'首页'},
      children:[
        {
          path:'',
          component: resolve => require(['../components/page/home.vue'], resolve),
          meta: { title: '主页'}
        },
        {
          path:'/participantinformationdefinition',
          component: resolve => require(['../components/page/participantinformationdefinition.vue'], resolve),
          meta: { title: '参与人信息定义表'}
        },
        {
          path:'/participantinformationimport',
          component: resolve => require(['../components/page/participantinformationimport.vue'], resolve),
          meta: { title: '参与人信息导入表'}
        },
        {
          path:'/showcontentdefinition',
          component: resolve => require(['../components/page/showcontentdefinition.vue'], resolve),
          meta: { title: '大屏幕显示内容定义表'}
        },
        {
          path:'/start',
          component: resolve => require(['../components/page/start.vue'], resolve),
          meta: { title: '开始摇号'}
        },
        {
          path:'/setwin',
          component: resolve => require(['../components/page/setwin.vue'], resolve),
          meta: { title: '设置单次中签人数表'}
        },
        
      ]
    },

    // {
    //   path:'/home',
    //   component:resolve =>require(['../components/common/Home.vue'],resolve),
    //   meta:{title:'HOME'}
    // },
    ]

})
