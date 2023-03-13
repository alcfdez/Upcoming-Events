import AuthConnection from "./AuthConnection";
import AuthRegister from "./AuthRegister";

export default class AuthService {

  #conn;
  #reg;

  constructor() {
    this.#conn = new AuthConnection();
    this.#reg = new AuthRegister();
  }

  async login(username, password) {
    console.log(username, password)
    return await this.#conn.login(username, password);
  }

  async register(username, password) {
    console.log(username, password)
     await this.#reg.register(username, password);
  }
}
