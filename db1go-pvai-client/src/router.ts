import Vue from 'vue';
import Router from 'vue-router';
import Consulta from '@/views/Consulta.vue';
import Cadastro from '@/views/Cadastro.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/consulta',
      component: Consulta,
    },
    {
      path: '/cadastro',
      component: Cadastro,
    },
    {
      path: '*',
      redirect: '/consulta',
    },
  ],
});
