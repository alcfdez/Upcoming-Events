<script setup>
import { ref } from 'vue';
import { Notify, useQuasar } from "quasar";
import { useRouter } from 'vue-router';



const router = useRouter();

const $q= useQuasar();


</script>

<template>
        <q-header class="header  row flex-center q-pa-lg  bg-primary"  reveal >
        <div class="container_head">
        <q-breadcrumbs-el icon="fa-solid fa-house" to="/" style="font-size:2em;" />

        <span class="title_header text-h2">MUSIC EVENTS</span>
        <q-breadcrumbs-el icon="fa-solid fa-user" to= "/formAdd" style="font-size:2em;" color="white" class="icon" />
      </div>
      </q-header>
</template>

<style lang="scss" scoped>
  @use "../css/mixins.scss" as m;


 .container_head{
    width: 80%;
    display: flex;
    justify-content: space-between;
    @include m.mv(1200px){
            width: 90%;
          }
 }
  .title_header {
    font-family: $font-title;
    @include m.mv(1200px){
            font-size: 2em;
          }
    }

.q-breadcrumbs__el-icon {
  @include m.mv(1200px){
            font-size:1em;
          }}

  </style>
