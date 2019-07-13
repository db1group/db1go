<template>
  <v-app>
    <v-toolbar dark color="primary">
      <v-toolbar-title>DB1 Go</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="header__items">
        <router-link to="/consulta">
          <span class="items__option">
            Consulta
          </span>
        </router-link>
        <router-link to="/cadastro">
          <span class="items__option">
            Cadastro
          </span>
        </router-link>
      </v-toolbar-items>
    </v-toolbar>
    <div class="content">
      <router-view></router-view>
    </div>
  </v-app>
</template>

<script>
import { Vue, Component } from 'vue-property-decorator';
@Component({})
export default class App extends Vue {}
</script>
<style lang="sass" scoped>
.header
  &__items
    display: flex
    align-items: center
    font-size: 20px
.items
  &__option
    color: #FFFFFF
    display: block
    padding: 0 15px
    &:hover
      color: #b7e3ff
.content
  padding: 30px 15px 0 15px
.router-link-active
  font-size: 22px
  text-transform: uppercase
</style>
