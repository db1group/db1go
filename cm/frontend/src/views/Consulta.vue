<template>
  <div class="consulta">
    <h1>Consulta de Ações</h1>
    <v-simple-table>
      <thead>
        <tr>
          <th class="text-left">Nome</th>
          <th class="text-left">Data</th>
          <th class="text-left">Valor Inicial</th>
          <th class="text-left">Valor Final</th>
          <th class="text-center">Opções</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(stock, index) in stocks" :key="index">
          <td>{{ stock.name }}</td>
          <td>{{ stock.dateFormated }}</td>
          <td>{{ stock.value.start }}</td>
          <td>{{ stock.value.end }}</td>
          <td class="text-center">   
            <v-icon small class="mr-2" @click="edit(stock.id)">edit</v-icon>
            <v-icon small @click="remove(stock.id)">delete</v-icon>
          </td>
        </tr>
      </tbody>
    </v-simple-table>
  </div>
</template>
<script lang='ts'>
import { Vue, Component } from 'vue-property-decorator';
import Stock from '../domain/stock/stock.entity';
import StockService from '../domain/stock/stock.service';

@Component
export default class Consulta extends Vue {
  stocks: Stock[] = [];

  created() {
    this.findAllStocks();
  }

  findAllStocks() {
    StockService.getAll().then(stocks => this.stocks = stocks);
  }

  edit(id: string) {
    this.$router
      .push(`/cadastro/${id}`);
  }

  remove(id: string) {
    StockService
      .remove(id)
      .then(() => this.findAllStocks())
      .catch(err => console.log(err));
  }
}
</script>
<style lang='sass' scoped>
.consulta
  padding: 30px
</style>
