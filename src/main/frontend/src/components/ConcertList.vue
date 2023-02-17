<script>
import { ref } from 'vue'

const columns = [
  {
    name: 'Events',
    required: true,
    label: 'Events',
    align: 'left',
    field: row => row.Events,
    format: val => `${val}`,
    sortable: true
  },
  { name: 'pic', align: 'center', label: 'pic', field: 'pic', sortable: true },
  { name: 'Description', label: 'Description', field: 'Description', sortable: true },
  { name: 'Date', label: 'Date', field: 'Date' },
  { name: 'MaxCrowd', label: 'MaxCrowd', field: 'MaxCrowd'},
  { name: 'Button', label: 'Button', field: 'Button'}
]

const rows = [
  {
    Events: 'Frozen Yogurt',
    pic: 159,
    Description: 6.0,
    Date: 24,
    MaxCrowd: 4.0,
    Button: 87
  },
  {
    Events: 'Ice cream sandwich',
    pic: 237,
    Description: 9.0,
    Date: 37,
    MaxCrowd: 4.3,
    Button: 129
  },
  {
    Events: 'Eclair',
    pic: 262,
    Description: 16.0,
    Date: 23,
    MaxCrowd: 6.0,
    Button: 337
  },
  {
    Events: 'Cupcake',
    pic: 305,
    Description: 3.7,
    Date: 67,
    MaxCrowd: 4.3,
    Button: 413
  },
  {
    Events: 'Gingerbread',
    pic: 356,
    Description: 16.0,
    Date: 49,
    MaxCrowd: 3.9,
    Button: 327
  },
  {
    Events: 'Jelly bean',
    pic: 375,
    Description: 0.0,
    Date: 94,
    MaxCrowd: 0.0,
    Button: 50
  },
  {
    Events: 'Lollipop',
    pic: 392,
    Description: 0.2,
    Date: 98,
    MaxCrowd: 0,
    Button: 38
  },
  {
    Events: 'Honeycomb',
    pic: 408,
    Description: 3.2,
    Date: 87,
    MaxCrowd: 6.5,
    Button: 562
  },
  {
    Events: 'Donut',
    pic: 452,
    Description: 25.0,
    Date: 51,
    MaxCrowd: 4.9,
    Button: 326
  },
  {
    Events: 'KitKat',
    pic: 518,
    Description: 26.0,
    Date: 65,
    MaxCrowd: 7,
    Button: 54
  }
]

export default {
  setup () {
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
    <q-table
      :rows="rows"
      :columns="columns"
      row-key="name"
      selection="multiple"
      v-model:selected="selected"
    >
      <template v-slot:header-selection="scope">
        <q-toggle v-model="scope.selected" />
      </template>

      <template v-slot:body-selection="scope">
        <q-toggle v-model="scope.selected" />
      </template>
    </q-table>
  </div>
</template>