import { ref } from "vue";
import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", () => {

  let isAuthenticate = ref(false);
  const username = ref("");
  const roles = ref([]);

  const setRole = (role) => {
    if (!roles.value.includes(role)) {
      roles.value.push(role);
    }
  };

  const setUsername = (newUsername) => {
    username.value = newUsername;
  };

  const setIsAuthenticated = () => {
    isAuthenticate.value = true;
  };

  return { isAuthenticate, username, roles, setRole, setUsername, setIsAuthenticated };
})
