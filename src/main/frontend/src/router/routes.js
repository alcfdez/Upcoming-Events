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
        { path: 'addEvent',name:'addEvent', component: () => import('pages/FormAddPage.vue') },
        { path: 'register',name:'register', component: () => import('pages/auth/RegisterView.vue') },
        { path: 'favorites',name:'favorites', component: () => import('pages/FavoritesPage.vue') },
        { path: 'dashboard',name:'dashboard', component: () => import('pages/Dashboard.vue'), meta: { requiresAuth : true } }
      ]
    },
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
