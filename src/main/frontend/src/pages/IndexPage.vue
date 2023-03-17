<script setup>
import { reactive, onBeforeMount } from 'vue';
import SliderComponent from 'src/components/SliderComponent.vue';
import HeadPage from  '../components/HeadPage.vue'
import ConcertList  from  '../components/ConcertList.vue'
import { useAuthStore }  from "src/stores/authStore"

const auth = useAuthStore();
console.log(auth.roles[0])

</script>

<template>
  <q-page class="bg-blue column items-center">
    <HeadPage />
    <SliderComponent />
    <ConcertList :event="events" :user-roles="auth.roles"/>
    <footer class="footer bg-blue flex flex-center" reveal>
      <img class="logo" src="../assets/images/logo.png" />
    </footer>
  </q-page>
</template>

<style lang="scss" scoped>
@use "../css/mixins.scss" as m;

</style>

