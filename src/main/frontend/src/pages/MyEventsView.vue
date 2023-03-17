<script setup>
import { ref } from "vue";
import { useMyEvents } from "../stores/storeAddEvent";

import HeadPage from "../components/HeadPage.vue";

const { state, showAddedEvents } = useMyEvents();

function addEvent(event) {
  showAddedEvents(event);
}

const addMyEvent = async (props) => {
  axios({
    method: "POST",
    url: "http://localhost:8080/api/users/subscribe/" + props.id,
  })
    .then((res) =>
      Notify.create({
        type: "positive",
        message: "Signed up for the event successfully!",
        icon: "fa-solid fa-circle-check",
        position: "top",
      })
    )
    .catch(
      q.create({
        color: "negative",
        message: "This event already exists",
        position: "top",
      })
    );
};

const url = "http://localhost:8080/";

const columns = [
  {
    name: "title",
    required: true,
    label: "Title",
    align: "left",
    field: (row) => row.name,
    sortable: true,
  },
  {
    name: "MusicStyle",
    align: "center",
    label: "MusicStyle",
    field: "MusicStyle",
    sortable: true,
  },
  {
    name: "Description",
    label: "Description",
    field: "Description",
    sortable: true,
  },
  { name: "date_hour", label: "Date", field: "Date" },
];

const rows = [
  {
    name: "Concierto de Manolo punketo",
    MusicStyle: "Rock",
    Description: "Concierto de manolo",
    Date: "2021-06-01",
  },
  {
    name: "Madonna in live",
    MusicStyle: "Pop",
    Description: "Concierto de Madonna",
    Date: "2024-06-01",
  },
  {
    name: "Concierto de Estopa",
    MusicStyle: "Rock",
    Description: "Estopa en concierto",
    Date: "2023-06-01",
  },
  {
    name: "Concierto de Kase-O",
    MusicStyle: "Rap",
    Description: "Gira mundial del gran rapero Kase-o",
    Date: "2023-06-01",
  },
];
</script>
<template>
  <q-page class="bg-blue column items-center">

    <q-header class="header row flex-center q-pa-lg bg-primary" reveal>
      <div class="container_head">
        <q-breadcrumbs-el
          icon="fas fa-sign-out-alt"
          to="/"
          style="font-size: 2em"
          color="white"
          @click="logout"
        />
        <span class="title_header text-h2">MUSIC EVENTS</span>
        <q-breadcrumbs-el
          icon="fa-solid fa-house"
          to="/"
          style="font-size: 2em"
        />

      </div>
    </q-header>

    <h1 class="text-h1 text-white">My Events</h1>
    <div class="q-pa-md">
      <div class="q-pa-md">
        <q-table
          grid
          :rows="rows"
          :columns="columns"
          row-key="name"
          hide-header
          card-class="bg-info text-white"
        >
        </q-table>
      </div>
    </div>
    <q-footer class="footer bg-blue flex flex-center" reveal>
      <img class="logo" src="../assets/images/logo.png" />
    </q-footer>
  </q-page>
</template>

<style>
@use "../css/mixins.scss" as m;

.container_head {
  width: 80%;
  display: flex;
  justify-content: space-between;
  @include m.mv(1200px) {
    width: 90%;
  }
}
.title_header {
  font-family: $font-title;
  @include m.mv(1200px) {
    font-size: 2em;
  }
}

.q-breadcrumbs__el-icon {
  @include m.mv(1200px) {
    font-size: 1em;
  }
}
</style>
