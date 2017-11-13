<template>
  <div class="employees">
    <button @click="form_get = !form_get">Form GET</button>
    <button @click="form_post = !form_post">Form POST</button>

    <form action="." v-if="form_get">
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="Employee first name" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="getEmployees()">GET</a>
      </div>
    </form>

    <form action="." v-if="form_post" style="margin-top: 50px">
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="first name" v-model="employee.firstName">
      </div>
      <div class="field">
        <label for="lastName">Last Name</label>
        <input class="input" type="text" id="lastName" name="lastName" placeholder="last name" v-model="employee.lastName">
      </div>
      <div class="field">
        <label for="age">Age</label>
        <input class="input" type="text" id="age" name="age" placeholder="age" v-model="employee.age">
      </div>
      <div class="field">
        <label for="kind_id">Kind id</label>
        <input class="input" type="text" id="kind_id" name="kind_id" placeholder="kind id" v-model="employee.kind.id">
      </div>
      <div class="field">
        <label for="kind_name">Kind name</label>
        <input class="input" type="text" id="kind_name" name="kind_name" placeholder="kind name" v-model="employee.kind.name">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="createEmployee()">POST</a>
      </div>
    </form>

    <div>
      <ul style="margin-top: 50px">
        <li v-for="employee in employeesData">
          <p>First Name: {{employee.firstName}}</p>
          <p>Last Name: {{employee.lastName}}</p>
          <p>Age: {{employee.age}}</p>
          <p>Kind: {{employee.kind.name}}</p>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Employees',

    data () {
      return {
        employeesData: {},
        employeeRequest: '',
        employee: {
          firstName: '',
          lastName: '',
          age: '',
          kind: {
            id: '',
            name: ''
          }
        },

        form_get: false,
        form_post: false
      }
    },

    methods: {
      getEmployees () {
        axios.get('http://localhost:8080/employees/' + this.employeeRequest)
        .then(response => {
          this.employeesData = response.data
        })
      },

      createEmployee () {
        axios.post('http://localhost:8080/employees/' + this.employeeRequest, this.employee)
        .then(response => { console.log(response) })
        .catch(e => { console.log('Errors:' + e) })
      }
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

form {
  width: 300px;
  margin: 0 auto;
  margin-top: 50px;
}
</style>