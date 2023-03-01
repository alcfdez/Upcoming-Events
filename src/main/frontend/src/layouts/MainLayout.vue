<script>
import { defineComponent, ref } from 'vue'
import IndexPageVue from 'src/pages/IndexPage.vue';
import Dashboard from 'src/pages/Dashboard.vue';
import FormPage from 'src/pages/FormPage.vue';
import ErrorNotFound from 'src/pages/ErrorNotFound.vue';


const linksList= [

  {
    title:'Index',
    caption:'index',
    link:'index'
  },

  {
    title:'Dashboard',
    caption:'dasboard',
    link:'dashboard'
  },

  {
    title:'Form',
    caption:'form',
    link:'form'
  },

  {
    title:'Error',
    caption:'error',
    link:'error'
  },

]

</script>




<template>
  <q-layout view="hHh lpR fFf">
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>


