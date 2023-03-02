<script setup>
import { ref, defineProps } from 'vue';

const props = defineProps({
		event: {
			type: Object,
		}
	});

  console.log(props.event)
  const rows = [
   "https://cdn.quasar.dev/img/avatar.png"
  ,
    "https://i0.wp.com/losmejoresrock.com/wp-content/uploads/2022/12/bon-jovi-1992.jpg?fit=561%2C324&ssl=1"
  ,
    "/src/assets/images/ALT-J.jpg"
  ]

const columns = [
  {
    name: 'title',
    required: true,
    label: 'title',
    field: "title",
    align: 'center',
    format: val => `${val}`,
    sortable: true
  },

  { name: "rows" , align: 'center', label: 'Imagen', field:"rows"},
  { name: 'Description', align: 'center', label: 'Description', field: 'description', sortable: true },
  { name: 'date_hour', align: 'center', label: 'Date', field: 'date_hour', sortable: true  },
  { name: 'max_participants', align: 'center', label: 'Capacity', field: 'max_participants' },
  { name: 'Button', align: 'center', label: 'Button', field: 'Button' }
]
</script>

<template>
  <div class="q-pa-md">
    <q-table class="bg-grey-4" :rows="props.event" :columns="columns" row-key="name" selection="multiple"
      v-model:selected="selected">

      <template #body-cell-imagen="{ rows }">
        <q-img :src="rows" />
      </template>

      <template #body-cell-Button>
        <q-td align="center" >
          <q-btn push color="white" text-color="primary" label="Add" />
          <q-btn push color="white" text-color="primary" label="Edit" />
          <q-btn push color="red" text-color="primary" label="delete" />
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
}

td:nth-child(2) {
  background-color: #9E0404;
}

thead {
  background-color: #D9D9D9;
}

tbody {
  background-color: #B7B7B7;
}

.q-table__bottom {
  background-color: white;
}
</style>
