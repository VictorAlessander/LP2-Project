<template>
  <div class="employees">
    <button @click="form_get = !form_get">Form GET</button>
    <button @click="form_post = !form_post">Form POST</button>
    <button @click="form_delete = !form_delete">Form DELETE</button>

    <form action="." v-if="form_get">
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="Employee first name" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="getEmployees()">GET</a>
      </div>
    </form>

    <form action="." v-if="form_post">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID (blank if you are creating a new employee)" v-model="employee.id">
      </div>
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
        <a class="button is-link" @click="updateEmployee()">PUT</a>
      </div>
    </form>

    <form action="." v-if="form_delete">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID" v-model="employee.id">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="removeEmployee()">DELETE</a>
      </div>
    </form>

    <div>
      <table class="table is-fullwidth" style="margin-top: 50px">
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Kind ID</th>
            <th>Kind Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="employee in employeesData">
            <td>{{employee.id}}</td>
            <td>{{employee.firstName}}</td>
            <td>{{employee.lastName}}</td>
            <td>{{employee.age}}</td>
            <td>{{employee.kind.id}}</td>
            <td>{{employee.kind.name}}</td>
          </tr>
        </tbody>
      </table>
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
          id: null,
          firstName: '',
          lastName: '',
          age: '',
          kind: {
            id: '',
            name: ''
          }
        },

        form_get: false,
        form_post: false,
        form_delete: false
      }
    },

    methods: {
      clearInputs () {
        this.employee.id = null
        this.employee.firstName = ''
        this.employee.lastName = ''
        this.employee.age = ''
        this.employee.kind.id = ''
        this.employee.kind.name = ''
      },

      getEmployees () {
        axios.get(`http://localhost:8080/employees/${this.employeeRequest}`)
        .then(response => {
          this.employeesData = response.data
        })
      },

      createEmployee () {
        axios.post(`http://localhost:8080/employees/${this.employeeRequest}`, this.employee)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      updateEmployee () {
        axios.put(`http://localhost:8080/employees/${this.employeeRequest}`, this.employee)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      removeEmployee () {
        axios.delete(`http://localhost:8080/employees/${this.employeeRequest}/${this.employee.id}`)
        .then(this.clearInputs())
        .catch(e => { alert(e) })
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
  width: 400px;
  margin: 0 auto;
  margin-top: 50px;
}
</style>