<template>
  <v-app>
    <div>
      <v-toolbar class="primary" dark>
        <v-toolbar-title>NEWBIE Trader</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items class="link">
          <router-link to="/">
            <v-btn text>Home</v-btn>
          </router-link>

          <router-link to="/consulta">
            <v-btn text>Consulta</v-btn>
          </router-link>
          
          <router-link to="/cadastro">
            <v-btn text>Cadastro</v-btn>
          </router-link>
        </v-toolbar-items>
      </v-toolbar>
    </div>
    <router-view></router-view>
  </v-app>
</template>
<style lang="sass" scoped>
.link
  margin-top: 30px  
</style>