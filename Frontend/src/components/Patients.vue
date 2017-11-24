<template>
  <div class="patients">
    <button @click="form_get = !form_get">Form GET</button>
    <button @click="form_post = !form_post">Form POST</button>
    <button @click="form_delete = !form_delete">Form DELETE</button>

    <form action="." v-if="form_get">
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="Employee first name" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="getPatients()">GET</a>
      </div>
    </form>

    <form action="." v-if="form_post">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID" v-model="patient.id">
      </div>
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="first name" v-model="patient.firstName">
      </div>
      <div class="field">
        <label for="lastName">Last Name</label>
        <input class="input" type="text" id="lastName" name="lastName" placeholder="last name" v-model="patient.lastName">
      </div>
      <div class="field">
        <label for="age">Age</label>
        <input class="input" type="text" id="age" name="age" placeholder="age" v-model="patient.age">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="createPatient()">POST</a>
        <a class="button is-link" @click="updatePatient()">PUT</a>
      </div>
    </form>

    <form action="." v-if="form_delete">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID" v-model="patient.id">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="removePatient()">DELETE</a>
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
          </tr>
        </thead>
        <tbody>
          <tr v-for="patient in patientsData">
            <td>{{patient.id}}</td>
            <td>{{patient.firstName}}</td>
            <td>{{patient.lastName}}</td>
            <td>{{patient.age}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Patients',

    data () {
      return {
        patientsData: {},
        employeeRequest: '',
        patient: {
          id: null,
          firstName: '',
          lastName: '',
          age: ''
        },

        form_get: false,
        form_post: false,
        form_delete: false
      }
    },

    methods: {
      clearInputs () {
        this.patient.id = null
        this.patient.firstName = ''
        this.patient.lastName = ''
        this.patient.age = null
      },

      getPatients () {
        axios.get(`http://localhost:8080/patients/${this.employeeRequest}`)
        .then(response => {
          this.patientsData = response.data
        })
      },

      createPatient () {
        axios.post(`http://localhost:8080/patients/${this.employeeRequest}`, this.patient)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      updatePatient () {
        axios.put(`http://localhost:8080/patients/${this.employeeRequest}`, this.patient)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      removePatient () {
        axios.delete(`http://localhost:8080/patients/${this.employeeRequest}/${this.patient.id}`)
        .then(this.clearInputs())
        .catch(e => { alert(e) })
      }
    }
  }
</script>

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