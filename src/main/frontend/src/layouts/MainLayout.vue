<script setup>
import { defineComponent, ref } from 'vue'
import IndexPageVue from 'src/pages/IndexPage.vue';
import Dashboard from 'src/pages/Dashboard.vue';
import FormPage from 'src/pages/auth/loginView.vue';
import ErrorNotFound from 'src/pages/ErrorNotFound.vue';
</script>

<template>
  <q-layout view="hHh lpR fFf">
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>


