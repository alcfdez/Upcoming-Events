<script setup>
import SliderComponent from 'src/components/SliderComponent.vue';
import HeadPage from  '../components/HeadPage.vue'
import ConcertList  from  '../components/ConcertList.vue'
</script>


<template>
  <q-page class="bg-blue column items-center">
    <HeadPage />
    <SliderComponent />
    <ConcertList />
    <footer class="footer bg-blue flex flex-center" reveal>
      <img class="logo" src="../assets/images/logo.png" />
    </footer>
  </q-page>
</template>


