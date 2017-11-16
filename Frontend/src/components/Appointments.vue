<template>
  <div class="appointments">
    <button @click="form_get = !form_get">Form GET</button>
    <button @click="form_post = !form_post">Form POST</button>
    <button @click="form_delete = !form_delete">Form DELETE</button>

    <form action="." v-if="form_get">
      <div class="field">
        <label for="firstName">First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="Employee first name" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="getAppointments()">GET</a>
      </div>
    </form>

    <form action="." v-if="form_post">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID" v-model="appointment.id">
      </div>
      <div class="field">
        <label for="medical_specialty">Medical Specialty</label>
        <input class="input" type="text" id="medical_specialty" name="medical_specialty" placeholder="medical specialty" v-model="appointment.medical_specialty">
      </div>
      <div class="field">
        <div class="control">
          <label for="attended-checkbox">
            <input type="checkbox" id="attended-checkbox" name="attended-checkbox" v-model="appointment.attended">
            Attended
          </label>
        </div>
      </div>
      <div class="field">
        <label for="date">Date</label>
        <input class="input" type="text" id="date" name="date" placeholder="Date" v-model="appointment.date">
      </div>
      <div class="field">
        <label for="patient_id">Patient's ID</label>
        <input class="input" type="text" id="patient_id" name="patient_id" placeholder="ID" v-model="appointment.patient.id">
      </div>
      <div class="field">
        <label for="firstName">Patient's First Name</label>
        <input class="input" type="text" id="firstName" name="firstName" placeholder="first name" v-model="appointment.patient.firstName">
      </div>
      <div class="field">
        <label for="lastName">Patient's Last Name</label>
        <input class="input" type="text" id="lastName" name="lastName" placeholder="last name" v-model="appointment.patient.lastName">
      </div>
      <div class="field">
        <label for="age">Patient's Age</label>
        <input class="input" type="text" id="age" name="age" placeholder="age" v-model="appointment.patient.age">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee's First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="createAppointment()">POST</a>
        <a class="button is-link" @click="updateAppointment()">PUT</a>
      </div>
    </form>

    <form action="." v-if="form_delete">
      <div class="field">
        <label for="id">ID</label>
        <input class="input" type="text" id="id" name="id" placeholder="ID" v-model="appointment.id">
      </div>
      <div class="field">
        <label for="employeeRequest">Employee First Name</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request (first name)" v-model="employeeRequest">
      </div>
      <div class="field">
        <a class="button is-link" @click="removeAppointment()">DELETE</a>
      </div>
    </form>

    <div>
      <table class="table is-fullwidth" style="margin-top: 50px">
        <thead>
          <tr>
            <th>ID</th>
            <th>Specialty</th>
            <th>Attended</th>
            <th>Date</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="appointment in appointmentsData">
            <td>{{appointment.id}}</td>
            <td>{{appointment.medical_specialty}}</td>
            <td>{{appointment.attended}}</td>
            <td>{{appointment.date}}</td>
            <td>{{appointment.patient.firstName}}</td>
            <td>{{appointment.patient.lastName}}</td>
            <td>{{appointment.patient.age}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Appointments',

    data () {
      return {
        appointmentsData: {},
        employeeRequest: '',
        appointment: {
          id: null,
          medical_specialty: '',
          attended: false,
          date: null,
          patient: {
            id: '',
            firstName: '',
            lastName: '',
            age: null
          }
        },

        form_get: false,
        form_post: false,
        form_delete: false
      }
    },

    methods: {
      clearInputs () {
        this.appointment.id = null
        this.appointment.medical_specialty = ''
        this.appointment.attended = false
        this.appointment.date = null
        this.appointment.patient.id = null
        this.patient.firstName = ''
        this.patient.lastName = ''
        this.patient.age = null
      },

      getAppointments () {
        axios.get(`http://localhost:8080/appointments/${this.employeeRequest}`)
        .then(response => { this.appointmentsData = response.data })
      },

      createAppointment () {
        axios.post(`http://localhost:8080/appointments/${this.employeeRequest}`, this.appointment)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      updateAppointment () {
        axios.put(`http://localhost:8080/appointments/${this.employeeRequest}`, this.appointment)
        .then(response => {
          console.log(response)
          this.clearInputs()
        })
        .catch(e => { alert(e) })
      },

      removeAppointment () {
        axios.delete(`http://localhost:8080/appointments/${this.appointment.id}/${this.employeeRequest}`)
        .then(response => { console.log(response) })
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