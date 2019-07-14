<template>
  <div>
    <v-card>
      <v-card-title primary-title>
        <div>
          <h3 class="headline mb-0">New</h3>
        </div>
      </v-card-title>
      <v-form class="form" ref="form" v-model="valid" lazy-validation>
        <v-text-field label="Name"></v-text-field>
        <v-text-field label="Date"></v-text-field>
        <v-text-field label="Star value"></v-text-field>
        <v-text-field label="End value"></v-text-field>
        <v-btn color="primary">Save</v-btn>
      </v-form>
    </v-card>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';

@Component({})
export default class Cadastro extends Vue {}
</script>
<style lang="sass" scoped>
.v-form
  padding: 20px
</style>
