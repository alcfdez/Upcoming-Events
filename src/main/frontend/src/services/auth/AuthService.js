import AuthConnection from "./AuthConnection";

export default class AuthService {

  #conn;

  constructor() {
    this.#conn = new AuthConnection();
  }

  async login(username, password) {
    console.log(username, password)
    await this.#conn.login(username, password);
  }
}
