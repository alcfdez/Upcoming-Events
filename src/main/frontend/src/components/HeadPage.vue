<script setup>
import { ref } from 'vue';
import { Notify, useQuasar } from "quasar";
import { useRouter } from 'vue-router';
import { useAuthStore }  from "src/stores/authStore"
import AuthService from "src/services/auth/AuthService";


const auth = useAuthStore();
const roles = ref(auth.roles[0]);
console.log(auth.roles[0])

const router = useRouter();

const $q= useQuasar();

const logout = async () => {
  const authService = new AuthService();
  try {
    const response = await authService.logout();
  } catch (error) {
    console.error(error);
}
}
</script>

<template>
        <q-header class="header  row flex-center q-pa-lg  bg-primary"  reveal >
        <div class="container_head">
        <q-breadcrumbs-el icon="fas fa-sign-out-alt" to= "/" v-if="roles !== undefined" style="font-size:2em;" color="white" @click="logout" />
        <q-breadcrumbs-el icon="fa-solid fa-house" to="/" v-else style="font-size:2em;" />

        <span class="title_header text-h2">MUSIC EVENTS</span>
        <q-breadcrumbs-el icon="fa-solid fa-user" to= "/login" v-if="roles === undefined" style="font-size:2em;" color="white" />
        <q-breadcrumbs-el icon="fa-solid fa-user" to= "/favorites" v-if="roles === 'ROLE_USER'" style="font-size:2em;" color="white" />
        <q-breadcrumbs-el icon="fa-solid fa-calendar-plus" v-else-if="roles==='ROLE_ADMIN'" to= "/addEvent" style="font-size:2em;" color="white" />
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
