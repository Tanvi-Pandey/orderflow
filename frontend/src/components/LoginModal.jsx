import { useState } from "react";
import "./LoginModal.css";

function LoginModal({ closeModal }) {
  const [isLogin, setIsLogin] = useState(true);

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [message, setMessage] = useState("");

  const handleSubmit = () => {
    if (
      email.trim() === "" ||
      password.trim() === "" ||
      (!isLogin && name.trim() === "")
    ) {
      setMessage("Please fill all fields.");
      return;
    }

    if (isLogin) {
      setMessage("Login Successful!");
    } else {
      setMessage("Registration Successful!");
    }

    setTimeout(() => {
      closeModal();
    }, 1500);
  };

  return (
    <div className="modal-overlay">

      <div className="login-modal">

        <button
          className="close-btn"
          onClick={closeModal}
        >
          ×
        </button>

        <h2>
          {isLogin ? "Login" : "Register"}
        </h2>

        <div className="switch-buttons">

          <button
            className={isLogin ? "active" : ""}
            onClick={() => setIsLogin(true)}
          >
            Login
          </button>

          <button
            className={!isLogin ? "active" : ""}
            onClick={() => setIsLogin(false)}
          >
            Register
          </button>

        </div>

        {!isLogin && (

          <input
            type="text"
            placeholder="Full Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />

        )}

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button
          className="submit-btn"
          onClick={handleSubmit}
        >
          {isLogin ? "Login" : "Register"}
        </button>

        {message && (
          <p className="login-message">
            {message}
          </p>
        )}

      </div>

    </div>
  );
}

export default LoginModal;