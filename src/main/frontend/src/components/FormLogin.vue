<script setup>
import axios from "axios";
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import AuthService from "src/services/auth/AuthService";
import { useAuthStore }  from "src/stores/authStore"

const auth = useAuthStore();


let usernameModel = ref();
let passwordModel = ref();
const router = useRouter();
const $q = useQuasar();

const submitData = async () => {
  const authService = new AuthService();
  try {
    const role = await authService.login(
      usernameModel.value,
      passwordModel.value
    );
     Notify.create({
       color: "positive",
       message: "Welcome " + usernameModel.value + ", your role is: " + role,
      position: "top"
    })
  auth.setRole(role);
  auth.setUsername(usernameModel.value);
  auth.setIsAuthenticated();
  console.log(auth.isAuthenticate, auth.roles, auth.username);
  router.push("/")
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
      src="https://images.unsplash.com/photo-1514525253161-7a46d19cd819?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y29uY2llcnRvfGVufDB8fDB8fA%3D%3D&w=1000&q=80"
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
        class="form q-gutter-sm self-end"
      >
        <span class="text-white text-h3 text-weight-bold">Log in</span>
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

        <q-breadcrumbs-el
          to="/register"
          label="No account?"
          class="q-m-xl pointer"
          color="white"
        />

        <div class="row justify-between">
          <q-btn
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
