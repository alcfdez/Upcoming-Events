<script setup>
import { ref, defineProps, reactive, onBeforeMount } from "vue";
import axios from "axios";
import EventsService from "../services/EventsService.js";
import { useAuthStore } from "src/stores/authStore";
import { Notify, useQuasar } from "quasar";

const auth = useAuthStore();
console.log(auth.roles[0]);
const $q = useQuasar();

const service = new EventsService();
const events = reactive(service.getEvents());

onBeforeMount(async () => {
  await service.fetchAll();
  console.log(events.value);
});

const props = defineProps({
  event: Object,
  userRoles: Array,
});

const roles = ref(props.userRoles[0]);

const columns = [
  {
    name: "title",
    required: true,
    label: "Title",
    field: "title",
    align: "center",
    sortable: true,
  },

  { name: "MusicStyle", align: "left", label: "Music Style", field: "style" },

  {
    name: "Description",
    align: "center",
    label: "Description",
    field: "description",
    sortable: true,
  },
  {
    name: "date_hour",
    align: "center",
    label: "Date",
    field: "date_hour",
    sortable: true,
  },
  {
    name: "max_participants",
    align: "center",
    label: "Capacity",
    field: "max_participants",
    sortable: true,
  },
  { name: "Actions", align: "left", label: "Actions", field: "Actions" },
];

const deleteEvent = async (props, rows) => {
  try {
    axios.delete("http://localhost:8080/api/events/" + props.id).then((res) => {
      const index = events.value.findIndex((row) => row.id === props.id);
      events.value.splice(index, 1);
    });
  } catch (err) {
    console.log(err);
  }
};

const addEvent = async (props) => {
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
        message: "This username already exists",
        position: "top",
      })
    );
};

const url = "http://localhost:8080/";
</script>

<template>
  <div class="list q-pa-md">
    <div id="example-3">
      <q-table
        class="bg-grey-4"
        :rows="events"
        :columns="columns"
        row-key="name"
        :grid="$q.screen.lt.md"
      >
        <template #body-cell-MusicStyle="{ row }">
          <q-td align="center">
            <img
              :src="'http://localhost:8080/' + row.style"
              onerror="this.src='https://images.twinkl.co.uk/tw1n/image/private/t_630/image_repo/49/d6/t-t-16131-music-title-display-lettering-_ver_1.jpg'"
            />
          </q-td>
        </template>

        <template #body-cell-Actions="{ row }">
          <q-td align="center">
            <q-btn
              push
              color="white"
              text-color="primary"
              label="LOGIN"
              v-if="roles === undefined"
              to="/login"
            />
            <q-btn
              push
              color="white"
              text-color="primary"
              label="Edit"
              class="q-mr-md"
              v-if="roles === 'ROLE_ADMIN'"
            />
            <q-btn
              push
              color="red"
              label="delete"
              @click="deleteEvent(row)"
              v-if="roles === 'ROLE_ADMIN'"
            />
            <q-btn
              push
              color="white"
              text-color="primary"
              v-if="roles === 'ROLE_USER'"
              @click="addEvent(row)"
              label="add"
            />
          </q-td>
        </template>
      </q-table>
    </div>
  </div>
</template>
<style lang="scss">
@use "../css/mixins.scss" as m;
.q-pa-md {
  width: 80vw;
  @include m.mv(1200px) {
    width: 90vw;
  }
  .q-table {
    thead {
      background-color: #d9d9d9;
    }
    th {
      text-align: center;
      font-size: 1.5em;
      @include m.mv(1200px) {
        font-size: 1em;
      }
    }
    tbody {
      background-color: #b7b7b7;

      td {
        overflow-x: auto;
        font-size: 1.2em;
        font-weight: 500;
        @include m.mv(1200px) {
          font-size: 0.8em;
        }
        @include m.mv(800px) {
          font-size: 0.6em;
        }
        &:nth-child(1) {
          background-color: #9e0404;
          color: white;
          max-width: 10em;
          white-space: pre-wrap;
        }
        &:nth-child(3) {
          white-space: pre-wrap;
          max-width: 20em;
        }
        & {
          overflow-x: auto;
        }

        &::-webkit-scrollbar {
          height: 6px;
        }

        &::-webkit-scrollbar-thumb {
          background-color: #999;
        }

        &::-webkit-scrollbar-track {
          background-color: #ddd;
        }
      }
    }
  }
}
.q-btn {
  @include m.mv(1000px) {
    font-size: 1em;
  }
}

img {
  height: 3em;
  width: 8em;
}
</style>
