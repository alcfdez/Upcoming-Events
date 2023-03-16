import axios from "axios";

export default class AuthRegister {

  #baseUrl = "http://localhost:8080";
  #auth = "";

  async register(username, password) {
    // this.#auth = window.btoa(`${username}:${password}`).toString();

    const user = {
      username: username,
      password: password,
      roles: [{ id: 2 }]
    };

    const response = await axios.post(`${this.#baseUrl}/api/register`, user);
  }
}
