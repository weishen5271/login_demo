import Vue from 'vue'

import App from './App.vue'
// import './plugins/element.js'
import router from './router'
import echarts from 'echarts'
import ElementUI from 'element-ui' //element-ui的全部组件
import  'element-ui/lib/theme-chalk/index.css'
import api from "./api";

Vue.prototype.$api = window.$api = api;
Vue.prototype.$Echart = echarts;
import store from "./store";

Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router, //使用路由配置
  store
}).$mount('#app')
