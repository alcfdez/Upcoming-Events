<script>
import { ref } from 'vue'

const columns = [
  {
    name: 'Events',
    required: true,
    label: 'Events',
    align: 'center',
    field: row => row.Events,
    format: val => `${val}`,
    sortable: true
  },

  { name: 'imagen', align: 'center', label: 'Imagen', field: 'imagen', sortable: false, format: (val) => 'imagen' },
  { name: 'Description', align: 'center', label: 'Description', field: 'Description', sortable: true },
  { name: 'Date', align: 'center', label: 'Date', field: 'Date' },
  { name: 'MaxCrowd', align: 'center', label: 'MaxCrowd', field: 'MaxCrowd' },
  { name: 'Button', align: 'center', label: 'Button', field: 'Button' }
]

const rows = [
  {
    imagen: "https://cdn.quasar.dev/img/avatar.png",
    Events: 'Frozen Yogurt',
    pic: 159,
    Description: 6.0,
    Date: 24,
    MaxCrowd: 4.0,
    imageIndex: 0
  },
  {
    imagen: "https://i0.wp.com/losmejoresrock.com/wp-content/uploads/2022/12/bon-jovi-1992.jpg?fit=561%2C324&ssl=1",
    Events: 'Ice cream sandwich',
    pic: 237,
    Description: 9.0,
    Date: 37,
    MaxCrowd: 4.3
  },
  {
    imagen: "/src/assets/images/ALT-J.jpg",
    Events: 'Eclair',
    pic: 262,
    Description: 16.0,
    Date: 23,
    MaxCrowd: 6.0
  },
  {
    Events: 'Cupcake',
    pic: 305,
    imageIndex: 0,
    Description: 3.7,
    Date: 67,
    MaxCrowd: 4.3
  },
  {
    imageIndex: 1,
    Events: 'Gingerbread',
    pic: 356,
    Description: 16.0,
    Date: 49,
    MaxCrowd: 3.9
  },
  {
    Events: 'Jelly bean',
    pic: 375,
    Description: 0.0,
    Date: 94,
    MaxCrowd: 0.0
  },
  {
    Events: 'Lollipop',
    pic: 392,
    Description: 0.2,
    Date: 98,
    MaxCrowd: 0
  },
  {
    Events: 'Honeycomb',
    pic: 408,
    Description: 3.2,
    Date: 87,
    MaxCrowd: 6.5
  },
  {
    Events: 'Donut',
    pic: 452,
    Description: 25.0,
    Date: 51,
    MaxCrowd: 4.9
  },
  {
    Events: 'KitKat',
    pic: 518,
    Description: 26.0,
    Date: 65,
    MaxCrowd: 7
  }
]

export default {
  setup() {
    return {
      selected: ref([]),
      columns,
      rows
    }
  }
}
</script>

<template>
  <div class="q-pa-md">
    <q-table class="bg-grey-4" :rows="rows" :columns="columns" row-key="name" selection="multiple"
      v-model:selected="selected">

      <template #body-cell-imagen="{ row }">
        <q-img :src="row.imagen" />
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
// q-table{
//   display: flex;

// }
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
