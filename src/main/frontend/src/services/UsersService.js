import { ref } from "vue";
import axios from "axios";

class UsersService {
  users;
  #url = "http://localhost:8080/api/users";

  constructor() {
    this.users = ref([]);
  }

  getUsers() {
    return this.users;
  }

  async fetchAllUsers() {
    axios.defaults.withCredentials = "include";
    try {
      await axios.get(`${this.#url}`).then((response) => {
        this.users.value = response.data;
      });
    } catch (err) {}
  }
}

export default UsersService;
