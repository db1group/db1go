import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/views/Home.vue';
import Consulta from '@/views/Consulta.vue';
import Cadastro from'@/views/Cadastro.vue';
import Erro from'@/views/Erro.vue';


Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      component:Home
    },
    {
      path: '/consulta',
      component:Consulta      
    },
    {
      path: '/cadastro',
      component: Cadastro
    },
    {
      path: '/cadastro/:id',
      component: Cadastro
    },
    {
      path: '/erro',
      component: Erro
    },
    {
      path: "*",
      redirect: "/erro"
    }
  ],
});
