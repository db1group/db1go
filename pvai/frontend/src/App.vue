<template>
  <v-app>
    <v-toolbar dark color="primary">
      <v-toolbar-title>DB1 Go</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="header__items">
        <link-menu label="Home" path="/home"></link-menu>   
        <link-menu label="New" path="/new"></link-menu>             
      </v-toolbar-items>
    </v-toolbar>
    <div class="content">
      <router-view></router-view>
    </div>
  </v-app>
</template>

<script>
import { Vue, Component } from 'vue-property-decorator';
import LinkMenu from '@/shared/link-menu.component';

@Component({
  components: {
    LinkMenu
  }
})
export default class App extends Vue {


}
</script>
<style lang="sass" scoped>
.header
  &__items
    display: flex
    align-items: center
    font-size: 20px
.content
  padding: 30px 15px 0 15px
</style>
