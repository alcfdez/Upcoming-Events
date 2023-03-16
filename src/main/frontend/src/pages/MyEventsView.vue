<script setup>
import { ref } from 'vue'
import { useMyEvents } from '../stores/storeAddEvent'

import HeadPage from  '../components/HeadPage.vue'

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
    name: 'title',
    required: true,
    label: 'Title',
    align: 'left',
    field: row => row.name,
    sortable: true
  },
  { name: 'MusicStyle', align: 'center', label: 'MusicStyle', field: 'MusicStyle', sortable: true },
  { name: 'Description', label: 'Description', field: 'Description', sortable: true },
  { name: 'date_hour', label: 'Date', field: 'date_hour' }
]



</script>
<template>
    <q-page class="bg-blue column items-center">
<HeadPage/>
<h1>My Events</h1>
  <div class="q-pa-md">
    <div class="q-pa-md">
    <q-table
      grid
      grid-header
      :rows="rows"
      :columns="columns"
      row-key="name"
      hide-header
    >
     
    </q-table>
  </div>
  </div>
  <q-footer class="footer bg-blue flex flex-center" reveal>
    <img class="logo" src="../assets/images/logo.png" />
</q-footer>
  </q-page>
</template>
