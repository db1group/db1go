<template>
    <div class="form">
        <h1>{{ title }}</h1>
        <v-form ref="form" :lazy-validation="false">
            <v-text-field v-model="stock.name" label="Name" :rules="rules.name"></v-text-field>
            <v-text-field v-model="stock.dateFormated" label="Date" :rules="rules.date"></v-text-field>
            <v-text-field v-model="stock.value.start" label="Start" :rules="rules.start"></v-text-field>
            <v-text-field v-model="stock.value.end" label="End" :rules="rules.end"></v-text-field>
        </v-form>
        <v-btn color="primary" :disabled="saving" @click="save">Salvar</v-btn>
        <v-btn color="error" :disabled="saving" @click="cancel">Cancelar</v-btn>        
    </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import Stock from '../domain/stock/stock.entity';
import StockService from '../domain/stock/stock.service';
import DateHandler from '../shared/date/date-handler';

@Component
export default class Cadastro extends Vue {
    stock = new Stock({});
    saving = false;
    form: any = this.$refs.form;
    isUpdating = false;

    rules = {
        name : [
            (value: any) => !!value || 'Name is mandatory',
            (value: any) => value.length > 3 || 'Name must be more than 3 characters'
        ],
        date : [
            (value: any) => !!value || 'Date is mandatory',
            (value: any) => DateHandler.isPtBrValidDate(value) || 'Date is invalid'
        ],
        start : [
            (value: any) => !!value || 'Start is mandatory'
        ],
        end : [
            (value: any) => !!value || 'End is mandatory'
        ]
    }

    created() {
        if (this.$route.params.id) {
            this.isUpdating = true;
            StockService.getOne(this.$route.params.id)
            .then(stock => this.stock = stock);
        }
    }

    save() {    
        const form: any = this.$refs.form;
        if (form.validate()) {
            this.saving = true;
            this.saveOrUpdate()
                .then(() => this.goSearch())
                .catch(err => console.log(err))
                .finally(() => this.saving = false);            
        }
    }

    private saveOrUpdate(): Promise<any> {
        if (this.isUpdating) {
            return  StockService.update(this.stock.id, this.stock);
        }
        return StockService.save(this.stock);
    }

    cancel() {
        this.goSearch();
    }

    get title() {
        return this.isUpdating ? 'Alterando ação' : 'Nova ação';
    }

    private goSearch() {
        this.$router.push('/consulta');
    }
}
</script>
<style lang="sass" scoped>
.form
  padding: 30px
</style>