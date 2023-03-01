<script setup>
import { ref } from 'vue';
import { Notify, useQuasar } from "quasar";
import { useRouter } from 'vue-router';



const router = useRouter();

const $q= useQuasar();


</script>

<template>

 
        <q-header class="header  row flex-center q-pa-lg  bg-primary"   >
        <div class="container_head">
        <q-breadcrumbs-el icon="fa-solid fa-house" to="/form" style="font-size:2em;" />

        <span class="title_header text-h2">MUSIC EVENTS</span>
        <q-breadcrumbs-el icon="fa-solid fa-user" to= "/form" style="font-size:2em;" color="white" />
      </div>
      </q-header>

</template>

<style lang="scss" scoped>


 .container_head{
    width: 80%;
    display: flex;
    justify-content: space-between;
 }
  .title_header {
    font-family: $font-title;
    }

  </style>
