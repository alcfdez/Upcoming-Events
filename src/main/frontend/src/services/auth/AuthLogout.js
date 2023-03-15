import axios from 'axios'

export default class AuthLogout{
    #baseUrl = "http://localhost:8080";
    #auth = "";

   async logout(){
     localStorage.removeItem("auth");
    axios.get(`${this.#baseUrl}/api/logout`)
    window.location.reload()
  .then(res => {
    console.log(res)
  })
  .catch(error => {
  });
  }
}
