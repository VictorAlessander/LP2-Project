<template>
  <div class="hello">
    <router-link :to="{ name: 'Patients' }">Patients</router-link>
    <router-link :to="{ name: 'Employees' }">Employees</router-link>
    <router-link :to="{ name: 'Appointments' }">Appointments</router-link>
    <router-link :to="{ name: 'Kinds' }">Kinds</router-link>
    <router-link :to="{ name: 'Reports' }">Reports</router-link>
  </div>
</template>

<script>
export default {
  name: 'Index',
  data () {
    return {}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
