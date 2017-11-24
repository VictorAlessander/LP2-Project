<template>
  
  <div class="reports">
    <button @click="form_patient_report = !form_patient_report">Patient report</button>

    <form action="." v-if="form_patient_report">
      <div class="field">
        <label for="employeeRequest">Employee Request</label>
        <input class="input" type="text" id="employeeRequest" name="employeeRequest" placeholder="Employee request" v-model="employeeRequest">
      </div>
      <div class="field">
        <label for="patientFirstName">First Name</label>
        <input class="input" type="text" id="patientFirstName" name="patientFirstName" placeholder="Patient first name" v-model="patientFirstName">
      </div>
      <div class="field">
        <a class="button is-link" @click="getPatientReport()">GET</a>
        <a id="downloadAnchorElem" style="display:none"></a>
      </div>
    </form>
  </div>

</template>


<script>
  import axios from 'axios'

  export default {
    name: 'Reports',
  
    data () {
      return {
        employeeRequest: '',
        patientFirstName: '',

        patientReport: {},

        form_patient_report: false
      }
    },

    methods: {
      clearInputs () {
        this.employeeRequest = ''
        this.patientFirstName = ''
      },

      getPatientReport () {
        axios.get(`http://localhost:8080/reports/patient/${this.patientFirstName}/${this.employeeRequest}`)
        .then(response => {
          this.patientReport = response.data
          this.downloadReport(this.patientReport)
          // this.downloadReport()
        })
        .catch(e => { alert(e) })
      },

      downloadReport (info) {
        var dataStr = 'data:text/json;charset=utf-8,' + encodeURIComponent(JSON.stringify(info))
        var dlAnchorElem = document.getElementById('downloadAnchorElem')
        dlAnchorElem.setAttribute('href', dataStr)
        dlAnchorElem.setAttribute('download', 'report.json')
        dlAnchorElem.click()
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