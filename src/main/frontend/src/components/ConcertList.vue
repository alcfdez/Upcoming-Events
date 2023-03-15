<script setup>
import { ref, defineProps, reactive, onBeforeMount } from "vue";
import axios from 'axios'
// const selected = ref([]);
import EventsService from "../services/EventsService.js"
import { useAuthStore }  from "src/stores/authStore"

const auth = useAuthStore();
console.log(auth.roles[0])

const service = new EventsService;
const events = reactive(service.getEvents());

onBeforeMount(async () => {
  await service.fetchAll();
  console.log(events.value)
})
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

function getSelectedString(rows) {
  return selected.value.length === 0
    ? ""
    : `${selected.value.length} record${
        selected.value.length > 1 ? "s" : ""
      } selected of ${rows}`;
}

 const deleteEvent= async (props, rows) => {
  console.log(props.id)
    try {
      axios
        .delete("http://localhost:8080/api/events/" + props.id)
        .then((res) => {
          const index = events.value.findIndex((row) => row.id === props.id);
          events.value.splice(index, 1);
        });
    } catch (err) {
      console.log(err);
    }
  }
</script>

<template>
  <div class="list q-pa-md">
    <q-table
      class="bg-grey-4"
      :rows="events"
      :columns="columns"
      row-key="name"
      :selected-rows-label="getSelectedString"
      selection="multiple"
      v-model:selected="selected"
    >
      <!-- <template #body-cell-imagen="{ rows }">
        <q-img :src="rows" />
      </template> -->

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
            label="add"
          />
        </q-td>
      </template>

      <template v-slot:header-selection="scope">
        <q-toggle v-model="scope.selected" />
      </template>

      <template v-slot:body-selection="scope">
        <q-toggle v-model="scope.selected" />
      </template>
    </q-table>
  </div>
</template>
<style lang="scss">
.q-pa-md {
  width: 80vw;
  .q-table {
    thead {
      background-color: #d9d9d9;
    }
    th {
      text-align: center;
      font-size: 1.5em;
    }
    tbody {
      background-color: #b7b7b7;

      td {
        overflow-x: auto;
        font-size: 1.2em;
        font-weight: 500;
        &:nth-child(2) {
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
          height: 6px; /* Altura de la barra */
        }

        &::-webkit-scrollbar-thumb {
          background-color: #999; /* Color de la barra */
        }

        &::-webkit-scrollbar-track {
          background-color: #ddd; /* Color del fondo de la barra */
        }
      }
    }
  }
}
.q-img {
  height: 15vh;
  width: 15vw;
}
</style>
