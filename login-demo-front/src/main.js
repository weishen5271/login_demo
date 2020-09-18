import Vue from 'vue'

import App from './App.vue'
// import './plugins/element.js'
import router from './router'

import ElementUI from 'element-ui' //element-ui的全部组件

Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router, //使用路由配置
}).$mount('#app')
