<script setup>
import axios from "axios";
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import AuthService from "src/services/auth/AuthService";

let usernameModel = ref();
let passwordModel = ref();
let passwordRepeatModel= ref();

const router = useRouter();

const $q = useQuasar();

const submitData = async () => {
  const authService = new AuthService();
  try {
    const response = await authService.register(
      usernameModel.value,
      passwordModel.value
    );
      Notify.create({
      color: "positive",
      message: "You have successfully created your account. Welcome, " + usernameModel.value,
      position: "top"
    })
  } catch (error) {
    console.error(error);
    Notify.create({
      color: "negative",
      message: "This username already exists",
      position: "top",
    });
}
  onReset();
}

const onReset = () => {
  (usernameModel.value = ""), (passwordModel.value = ""), (passwordRepeatModel.value = "");
};
</script>

<template>
  <q-page class="row justify-center text-center bg-blue">
    <q-img
      src="https://thred.com/wp-content/uploads/2023/03/danny-howe-bn-D2bCvpik-unsplash-1920x1120.jpg"
      spinner-color="white"
      class="col-0 col-xl-7 col-lg-7 col-md-7"
      height="100vh"
    />

    <div class="container-form column col-5 justify-between">
      <div class="column container-icons space-between col-1">
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
        class="form q-gutter-lg self-end"
      >
        <span class="text-white text-h3 text-weight-bold">Create account</span>
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
          v-model="passwordRepeatModel"
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
            (val) => (val && val === passwordModel) || 'Passwords do not match',
          ]"
        />

        <q-breadcrumbs-el
          label="Already have an account?"
          to="/login"
          class="q-m-xl pointer"
          color="white"
        />

        <div class="row justify-between">
          <q-btn
            unelevated
            outlined
            rounded
            label="Sign In"
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
  height: 85vh;
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
