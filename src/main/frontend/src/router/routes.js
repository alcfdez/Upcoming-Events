import { toNumber } from '@vue/shared';
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
        { path: 'login',name:'login', component: () => import('pages/auth/LoginView.vue'),  },
        { path: 'addEvent',name:'addEvent', component: () => import('pages/FormAddPage.vue'), meta: { requiresAuth : true } },
        { path: 'register',name:'register', component: () => import('pages/auth/RegisterView.vue') },
        { path: 'favorites',name:'favorites', component: () => import('pages/FavoritesPage.vue'), meta: { requiresAuth : true } },
        { path: 'dashboard',name:'dashboard', component: () => import('pages/Dashboard.vue'), meta: { requiresAuth : true } },
        { path: 'api/logout',name:'logout', component: () => import('pages/IndexPage.vue'), meta: { requiresAuth : true } }
      ]
    },
    {
      path: '/:catchAll(.*)*',
      component: () => import('pages/ErrorNotFound.vue')
    }
  ]

})

router.beforeEach( async (to,from)=>{
  const auth = useAuthStore;
     if(to.meta.requiresAuth && !auth.isAuthenticate){
        return {name: ''}
     }
    }
    )

export default router
