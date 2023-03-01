<script setup>
// import { ref } from 'vue';
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
  <q-page class="bg-blue column items-center">
    <HeadPage/>
    <SliderComponent/>


<q-footer class="footer bg-blue flex flex-center" reveal>
    <img class="logo" src="../assets/images/logo.png" />
</q-footer>
  </q-page>

</template>

