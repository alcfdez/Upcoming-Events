import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from "../stores/authStore.js"


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes : [
    {
      path: '/',
      component: () => import('layouts/MainLayout.vue'),
      children: [
        { path: '',  name: 'index', component: () => import('pages/IndexPage.vue') },
        { path: 'login',name:'formLogin', component: () => import('pages/auth/LoginView.vue'),  },
        { path: 'formAdd',name:'formAdd', component: () => import('pages/FormAddPage.vue') },
        { path: 'dashboard',name:'dashboard', component: () => import('pages/Dashboard.vue'), meta: { requiresAuth : true } }
      ]
    },

    // Always leave this as last one,

    // but you can also remove it
    {
      path: '/:catchAll(.*)*',
      component: () => import('pages/ErrorNotFound.vue')
    }
  ]

})

router.beforeEach( async (to,from)=>{
      const auth = useAuthStore();

    })




export default router
