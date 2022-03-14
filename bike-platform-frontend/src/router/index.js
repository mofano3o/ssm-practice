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
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "login" */ '../components/common/Dashboard'),
                    meta: { title: '首页' }
                },
                {
                    path: '/admin-user-manage',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/admin/User'),
                    meta: { title: '首页' }
                },
                {
                    path: '/rent-manage',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/user/Rent'),
                    meta: { title: '租借需求' }
                },
                {
                    path: '/order-manage',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/user/Order'),
                    meta: { title: '订单管理' }
                },
                {
                    path: '/message-manage',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/user/Message'),
                    meta: { title: '消息管理' }
                },
                {
                    path: '/admin-order-manage',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/admin/Order'),
                    meta: { title: '订单管理' }
                },
                {
                    path: '/user-info',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/user/UserInfo'),
                    meta: { title: '个人信息' }
                },
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '/register',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Register.vue'),
            meta: { title: '注册' }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});
