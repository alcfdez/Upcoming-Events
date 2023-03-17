<script setup>
  import { defineComponent, ref } from 'vue'
  import FormLogin from 'src/components/FormLogin.vue';
  import AuthService from 'src/services/auth/AuthService';

  const username = ref("");
  const password = ref("");

const submitData = async () =>{
    const authService = new AuthService();
    const response = await authService.login(username.value, password.value);
}
</script>

<template>
  <FormLogin />
</template>
