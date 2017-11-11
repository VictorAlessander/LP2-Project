import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Patients from '@/components/Patients'
import Employees from '@/components/Employees'
import Appointments from '@/components/Appointments'
import Kinds from '@/components/Kinds'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index
    },

    {
      path: '/patients',
      name: 'Patients',
      component: Patients
    },

    {
      path: '/employees',
      name: 'Employees',
      component: Employees
    },

    {
      path: '/appointments',
      name: 'Appointments',
      component: Appointments
    },

    {
      path: '/kinds',
      name: 'Kinds',
      component: Kinds
    }
  ]
})
