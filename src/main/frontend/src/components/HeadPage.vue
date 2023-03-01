<script setup>
import { ref } from 'vue';
import { Notify, useQuasar } from "quasar";
import { useRouter } from 'vue-router';
import SliderComponent from 'src/components/SliderComponent.vue';
import HeadPage from  '../components/HeadPage.vue'


const router = useRouter();

const $q= useQuasar();
const redirectToLogin = () => {
  router.push({path: 'form'})
}

</script>

<template>

 
        <q-header class="header row justify-between items-center q-pa-lg  bg-primary"  reveal >
        <q-icon name="fa-solid fa-home" size="lg" color="white" />

        <span class="title_header text-h2">MUSIC EVENTS</span>
        <q-icon name="fa-solid fa-user" to= "/form" size="lg" color="white" />

      </q-header>

</template>

<style lang="scss" scoped>

 
  .title_header {
    font-family: $font-title;
    }

  </style>
