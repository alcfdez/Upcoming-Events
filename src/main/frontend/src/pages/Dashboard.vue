<script setup>
import SliderComponent from 'src/components/SliderComponent.vue';
import HeadPage from  '../components/HeadPage.vue' 
</script>

<template>
  <q-page class="bg-blue column items-center">
    <HeadPage/>
    <SliderComponent/>

    
<q-footer class="footer bg-blue flex flex-center" reveal>
    <img class="logo" src="../assets/images/logo.png" />
</q-footer>
  </q-page>

</template>

