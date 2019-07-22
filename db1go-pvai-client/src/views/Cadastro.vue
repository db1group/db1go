<template>
  <div>
    <v-card>
      <v-card-title primary-title>
        <div>
          <h3 class="headline mb-0">New</h3>
        </div>
      </v-card-title>
      <v-form class="form" ref="form" v-model="valid" lazy-validation>
        <v-text-field v-model="stock.name" label="Name" :rules="rules.name"></v-text-field>
        <v-text-field
          v-model="stock.formatedDate"
          mask="##/##/####"
          label="Date"
          :rules="rules.date"
        ></v-text-field>
        <v-text-field 
          v-model="stock.value.start" 
          label="Star value" 
          :rules="rules.number">
        </v-text-field>
        <v-text-field 
          v-model="stock.value.end" 
          label="End value" 
          :rules="rules.number">
        </v-text-field>
        <v-btn @click="salvar" color="primary">Save</v-btn>
      </v-form>
      <v-snackbar v-model="snackbar" :multi-line="true" :timeout="6000" :top="true">
        {{ message }}
        <v-btn color="pink" flat @click="snackbar = false">Close</v-btn>
      </v-snackbar>
    </v-card>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import Stock from '@/domain/stock/stock.entity.ts';
import StockService from '@/domain/stock/stock.service';
import Rules from '@/shared/rules.commom';

@Component({})
export default class Cadastro extends Vue {
  valid = false;

  stock = new Stock({});

  rules = new Rules();

  ref: any = this.$refs;

  snackbar = false;

  message = '';

  salvar() {
    if (this.ref.form.validate()) {
      StockService
        .save(this.stock)
        .then(res => this.$router.push('/home'))
        .catch((err) => {
          this.message = err.response.data.message;
          this.snackbar = true;
        });
    }
  }
}
</script>
<style lang="sass" scoped>
.v-form
  padding: 20px
</style>
