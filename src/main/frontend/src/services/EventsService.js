import { ref } from "vue";
import axios from "axios";

class EventsService {
  events;
  #url = "http://localhost:8080/api/";

  constructor() {
    this.events = ref([]);
  }

  getEvents() {
    return this.events;
  }

  async fetchAll() {
    axios.defaults.withCredentials = "include";
    try {
      await axios.get(`${this.#url}events`).then((response) => {
        this.events.value = response.data;
      });
    } catch (err) {}
  }

  async deleteEvent(props, rows) {
    try {
      axios
        .delete("/" + props.id)
        .then((res) => {
          const index = rows.value.findIndex((row) => row.id === props.id);
          rows.value.splice(index, 1);
        });
    } catch (err) {
      console.log(err);
    }
  }

  async addEvent(eventId){
   await axios.post(`${this.#url}users/${eventId}`)
     .then((res) => {
      console.log(res);
  });
  }
}

export default EventsService;
