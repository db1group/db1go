<template>
  <div>
    <v-card class="options" height="30px" flat>
      <v-bottom-nav :value="true" absolute color="transparent">
        <v-btn color="teal" flat value="refresh" @click="findAllStocks">
          <span>Refresh</span>
          <v-icon>refresh</v-icon>
        </v-btn>
      </v-bottom-nav>
    </v-card>
    <v-data-table
      :headers="headers"
      :items="stocks"
      :hide-actions="true"
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
          <td class="text-xs-center">{{ props.item.value.start }}</td>
          <td class="text-xs-center">{{ props.item.value.end }}</td>
        </tr>
      </template>
    </v-data-table>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import StockService from '../domain/stock/stock.service';
import Stock from '../domain/stock/stock.entity';

@Component({})
export default class Consulta extends Vue {
  stocks: Stock[] = [];

  readonly headers = [
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

  created() {
    this.findAllStocks();
  }

  findAllStocks() {
    StockService.getAll().then(stocks => this.stocks = stocks);
  }
}
</script>
<style lang="sass" scoped>
.options
  margin: 20px 0

</style>
