<script setup>
import axios from "axios";
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import AuthService from "src/services/auth/AuthService";

let toggle = ref(false);

const toggleButton = () => {
  toggle.value = !toggle.value;
}

let usernameModel = ref();

let passwordModel = ref();

const router = useRouter();

const $q = useQuasar();

const submitData = async () => {
  console.log(usernameModel.value);
  console.log(passwordModel.value);
  const authService = new AuthService();
  try {
    const response = await authService.login(usernameModel.value, passwordModel.value);
    console.log("BIENVENID@ " + usernameModel.value);
  } catch (error) {
    console.error(error);
    Notify.create({
      color: "negative",
      message: "Authentication failed",
      position: "top",
    });
  }
  onReset();
};

const onReset = () => {
  (usernameModel.value = ""), (passwordModel.value = "");
};
</script>

<template>
  <q-page class="row justify-center text-center bg-blue">
    <q-img
      src="../assets/images/concierto-form.jpg"
      spinner-color="white"
      class="col-0 col-xl-7 col-lg-7 col-md-7"
      height="100vh"
    />

    <div class="container-form column col-5 justify-between">
      <div class="column container-icons space-between col-2">
        <q-breadcrumbs-el
          icon="fa-solid fa-house"
          class="q-mt-xl pointer gt-sm"
          color="white"
          to="/"
          style="font-size: 2em"
        />

        <q-img
          src="../assets/images/logo.png"
          class="self-end q-mt-lg col-sm-12 logo"
        />
      </div>

      <q-form
        @submit="submitData"
        @reset="onReset"
        class="form q-gutter-sm self-end"
      >
        <span v-if="!toggle" class="text-white text-h3 text-weight-bold">Log in</span>
        <span v-if="toggle" class="text-white text-h3 text-weight-bold">Create account</span>
        <q-input
          v-model="usernameModel"
          label="Enter your username"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="text"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          lazy-rules="ondemand"
          bg-color="red"
          class="q-mt-xl"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />

        <q-input
          v-model="passwordModel"
          label="Enter your password"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="password"
          lazy-rules="ondemand"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />

          <q-input
          v-if="toggle"
          v-model="passwordModel"
          label="Repeat your password"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="password"
          lazy-rules="ondemand"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />

         <q-breadcrumbs-el
         v-if="!toggle"
         @click="toggleButton"
         label="No account?"
          class="q-m-xl pointer"
          color="white"
        />

         <q-breadcrumbs-el
         v-if="toggle"
         @click="toggleButton"
         label="Have an account?"
          class="q-m-xl pointer"
          color="white"
        />

        <div class="row justify-between">
          <q-btn
            v-if="toggle"
            unelevated
            outlined
            rounded
            label="Sign In"
            type="submit"
            color="blue-1"
            class="col-5 q-py-md pointer"
          />

          <q-btn
            v-if="!toggle"
            unelevated
            outlined
            rounded
            label="Log in"
            type="submit"
            color="blue-1"
            class="col-5 q-py-md pointer"
          />

          <q-btn
            outlined
            rounded
            label="Reset"
            type="reset"
            color="white"
            flat
            class="col-5 q-py-md btn-reset pointer"
          />
        </div>
      </q-form>
    </div>
  </q-page>
</template>

<style lang="scss" scoped>
.btn-reset {
  border: 1px solid $brown;
  color: white;
}

.container-form {
  height: 75vh;
}

.form {
  width: 85%;
  margin: 0 auto;
}

.container-icons {
  margin: 0 auto;
  width: 84%;
}

.q-breadcrumbs__el {
  color: white;
}
.pointer {
  cursor: pointer;
  &:hover {
    opacity: 0.7;
  }
}
.logo {
  width: 16em;
  height: 6em;
}

</style>
