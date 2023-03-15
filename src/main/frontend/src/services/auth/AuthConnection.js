import axios from "axios";

export default class AuthConnection {

  #baseUrl = "http://localhost:8080";
  #auth = "";
  #role="";

  async login(username, password) {
    this.#auth = window.btoa(`${username}:${password}`).toString();

    const response = await axios.get(`${this.#baseUrl}/api/login`, {
      headers: {
        Authorization: `Basic ${this.#auth}`
      },
      withCredentials: true
    });

    this.#role = response.data.role;
    return this.#role;
  }
}

