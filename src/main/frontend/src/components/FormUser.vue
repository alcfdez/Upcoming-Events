<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import axios from "axios";

let usernameModel = ref();

let passwordModel = ref();

const router = useRouter();

const $q = useQuasar();

const onSubmit = async () => {
  onReset();
};

const onReset = () => {
  usernameModel.value = "",
  passwordModel.value = ""
};
</script>

<template>
  <q-page class="row justify-center text-center bg-blue-1">
    <q-img
      src="../assets/images/concierto-form.jpg"
      spinner-color="white"
      class="col-0 col-xl-7 col-lg-7 col-md-7 "
      height="100vh"
    />

    <div class="container-form column col-5 justify-between">

<div class="column container-icons space-between col-2 ">
    <q-icon name="fa-solid fa-house" class="q-mt-xl pointer gt-sm" size="lg" color="white"/>
      <q-img
        src="../assets/images/logo.png"
        class="self-end q-mt-lg col-sm-12 logo"

      />
  </div>

      <q-form @submit="onSubmit" @reset="onReset" class="form q-gutter-sm  self-end ">
        <span class="text-white text-h3 text-weight-bold">Log-in</span>
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

        <q-btn
            label="New Here?"
            type="submit"
            color="white"
            class="q-py-md text-center button-new"
            flat
          />

        <div class="row justify-between">
          <q-btn
            unelevated
            outlined
            rounded
            label="Submit"
            type="submit"
            color="blue"
            class="col-5 q-py-md"
          />

          <q-btn
            outlined
            rounded
            label="Reset"
            type="reset"
            color="white"
            flat
            class="col-5 q-py-md btn-reset"
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

.container-form{
  height: 75vh;
}

.form{
  width: 85%;
  margin: 0 auto;
}

.container-icons{
  margin: 0 auto;
  width: 84%;
}

.pointer{
  cursor: pointer;
  &:hover{
  opacity: .7;
  }
}
.logo{
  width: 16em;
  height: 6em;
}


</style>
