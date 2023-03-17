<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import axios from "axios";
let titleModel = ref();
let descriptionModel = ref();
let dateModel = ref();
let capacityModel = ref();
let musicStyleModel = ref();
const $q = useQuasar();
const onSubmit = async () => {
  axios({
    method: "POST",
    url: "http://localhost:8080/api/events/add",
    data: {
      title: titleModel.value,
      date_hour: dateModel.value,
      max_participants: parseInt(capacityModel.value),
      description: descriptionModel.value,
      actual_participants: 200,
      style: musicStyleModel.value,
    },
  })
    .then((res) =>
      $q.notify({
        type: "positive",
        message: "Event added successfully!",
        icon: "fa-solid fa-circle-check",
      })
    )
    .catch((err) => console.log(err));
  onReset();
};
const onReset = () => {
  (titleModel.value = ""),
    (descriptionModel.value = ""),
    (dateModel.value = ""),
    (capacityModel.value = ""),
    (musicStyleModel.value = "");
};
const options = [
  "dance",
  "pop",
  "rock",
  "latina",
  "alternativa",
  "hiphop",
  "metal",
];
</script>
<template>
  <q-page class="row justify-center text-center bg-blue">
    <q-img
      src="../assets/images/concierto-form.jpg"
      spinner-color="white"
      class="col-7 gt-xs"
      height="100vh"
    />
    <div class="container-form column col-5">
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
          class="self-end q-mt-lg  logo"
        />
      </div>
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="form q-gutter-sm self-end"
      >
        <span class="text-white text-h3 text-weight-bold"
          >Register New Event</span
        >
        <q-input
          v-model="titleModel"
          label="Enter event name"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="text"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          lazy-rules="ondemand"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
            (val) =>
              (val && val.length <= 40) ||
              'This field cannot have more than 40 characters',
          ]"
        />
        <q-input
          v-model="descriptionModel"
          label="Description"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="text"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          lazy-rules="ondemand"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />
        <q-input
          v-model="dateModel"
          label=""
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="date"
          :input-style="{
            color: 'white',
            fontSize: '1.3em',
            marginBottom: '1.1em',
          }"
          lazy-rules="ondemand"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />
        <q-input
          v-model="capacityModel"
          label="Total Capacity"
          label-color="white"
          outlined
          rounded
          text-color="white"
          color="white"
          type="text"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
          lazy-rules="ondemand"
          bg-color="red"
          class="q-mt-lg"
          :rules="[
            (val) => (val && val.length > 1) || 'This field is required',
          ]"
        />
        <q-select
          rounded
          standout
          v-model="musicStyleModel"
          :options="options"
          label="Select an event"
          bg-color="red"
          label-color="white"
          :input-style="{ color: 'white', fontSize: '1.7em' }"
        />
        <div class="row justify-between">
          <q-btn
            unelevated
            outlined
            rounded
            label="Submit"
            type="submit"
            color="blue-1"
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
@use "../css/mixins.scss" as m;
.btn-reset {
  border: 1px solid $brown;
  color: white;
}
.container-form {
  display: flex;
  align-items: center;
  @include m.mv(630px) {
    margin: auto;
  }
}
.form {
  margin: auto;
}
.container-icons {
  display: flex;
  justify-content: space-between;
  width: 73%;
  height: 11vh;
}
.q-mt-xl {
  margin-top: 1vh;
}
.text-h3 {
  font-size: 7vh;
}
.q-mt-lg {
  margin-top: 1vh;
}
.q-breadcrumbs__el {
  width: 3vw;
  color: white;
}
.column {
  display: flex;
  justify-content: center;
}
.q-icon {
  display: flex;
  justify-content: center;
  max-height: 6vh;
}
.pointer {
  cursor: pointer;
  &:hover {
    opacity: 0.7;
  }
}
.row,
.column,
.flex {
  display: flex;
}
.img__container {
  height: 10vh;
}
.logo {
  max-width: 15vw;
  max-height: 15vh;
  @include m.mv(1200px) {
    margin: 0 auto;
    width: 50%;
    height: 50%;
    margin-top: 0;
    margin-bottom: 0;
  }
  @include m.mv(900px) {
    margin-top: 1em;
    margin-bottom: 0;
  }
}
.title {
  @include m.mv(1200px) {
    font-size: 1.5em;
  }
}
</style>
