import axios from "axios";

export default axios.create({
    // baseURL : 'http://localhost:8080'
    baseURL : 'https://attendance-guru-production.up.railway.app'

})