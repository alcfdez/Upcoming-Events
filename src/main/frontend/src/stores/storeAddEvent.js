import { defineStore } from "pinia";
import { reactive } from 'vue';

export const storeMyEvents = defineStore({
    id: "myEvents",
    state: () => ({
        addedEvents: [],
    }),
    actions: {
        showAddedEvents(event) {
            if (this.addedEvents.indexOf(event) === -1) {
                this.addedEvents.push(event)
            }
        }
    }
})


export function useMyEvents() {
  const state = reactive({
    addedEvents: []
  });

  function showAddedEvents(event) {
    if (state.addedEvents.indexOf(event) === -1) {
      state.addedEvents.push(event);
    }
  }

  return {
    state,
    showAddedEvents
  };
}


// export const storeMyEventsUser = defineStore({
//     id: "myEventUser",
//     state: () => ({
//         addedEvents: [],
//     }),

//     actions: {
//         showAddedEvents(event) {
//             if (this.addedEvents.indexOf(event) === -1) {
//                 this.addedEvents.push(event)
//             }
//         }
//     }
