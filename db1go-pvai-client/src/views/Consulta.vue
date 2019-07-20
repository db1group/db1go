<template>
  <div>
    <v-card class="options" height="30px" flat>
      <v-bottom-nav :active.sync="bottomNav" :value="true" absolute color="transparent">
        <v-btn color="teal" flat value="refresh">
          <span>Refresh</span>
          <v-icon>refresh</v-icon>
        </v-btn>
      </v-bottom-nav>
    </v-card>

    <v-data-table
      v-model="selected"
      :headers="headers"
      :items="desserts"
      hide-actions="true"
      select-all
      item-key="name"
      class="elevation-1"
    >
      <template v-slot:headers="props">
        <tr>
          <th v-for="header in props.headers" :key="header.text">{{ header.text }}</th>
        </tr>
      </template>
      <template v-slot:items="props">
        <tr>
          <td>{{ props.item.name }}</td>
          <td class="text-xs-center">{{ props.item.date }}</td>
          <td class="text-xs-center">{{ props.item.startValue }}</td>
          <td class="text-xs-center">{{ props.item.endValue }}</td>
        </tr>
      </template>
    </v-data-table>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class Consulta extends Vue {
  headers = [
    {
      text: 'Name',
      align: 'left',
      value: 'name',
    },
    {
      text: 'Date',
      value: 'date',
    },
    {
      text: 'Start value',
      value: 'startValue',
    },
    {
      text: 'End value',
      value: 'endValue',
    },
  ];

  desserts = [
    {
      name: 'Will',
      date: '2016-06-03',
      startValue: 10,
      endValue: 24,
    },
    {
      name: 'João',
      date: '2016-06-03',
      startValue: 10,
      endValue: 24,
    },
    {
      name: 'Frozen',
      date: '2016-06-03',
      startValue: 10,
      endValue: 24,
    },
  ];
}
</script>
<style lang="sass" scoped>
.options
  margin: 20px 0

</style>
