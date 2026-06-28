import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginView from "../pages/LoginView";

export default function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginView />} />
        <Route
          path="/calculadora"
          element={<h1>¡Bienvenido a la Calculadora!</h1>}
        />
      </Routes>
    </BrowserRouter>
  );
}
