<script setup>

import { defineComponent } from 'vue'
import SliderComponent from 'src/components/SliderComponent.vue';
import ConcertList from 'src/components/ConcertList.vue';

</script>


<template>
  <q-page class="bg-blue column items-center">
    <SliderComponent />
    <ConcertList />


    <footer class="footer bg-blue flex flex-center" reveal>
      <img class="logo" src="../assets/images/logo.png" />
    </footer>
  </q-page>
</template>


