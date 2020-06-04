import Vue from 'vue';
import App from './App.vue';
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue';
import VueRouter from 'vue-router';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {routes} from './routes';

Vue.config.productionTip = false
Vue.config.devtools = true;
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
