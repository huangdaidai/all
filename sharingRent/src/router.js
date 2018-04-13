import VueRouter from 'vue-router'
import myInfo from '@/views/myInfo'

const routers = new VueRouter({
  routes: [
    {
      path: '/myInfo',
      name: 'myInfo',
      component: myInfo
    }
  ]
})

export default routers
