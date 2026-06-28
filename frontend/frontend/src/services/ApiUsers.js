import api from "./Api";

export const loginUser = async (email, passwordRaw) => {
  // El 'await' pausa la ejecución de esta línea hasta que el servidor responda
  const response = await api.post("/users/login", {
    email,
    passwordRaw,
  });

  // Extraemos exactamente lo que necesitamos
  return response.data;
};

export const fetchAllUsers = async () => {
  const response = await api.get("/users");
  return response.data;
};
