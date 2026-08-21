import "./Login.css";
import { Link, useNavigate } from "react-router-dom";
import { FaChartLine } from "react-icons/fa";

function Login() {
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    navigate("/dashboard");
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <div className="logo">
          <FaChartLine />
          <h1>OrderFlow</h1>
        </div>
        <h2>Welcome Back</h2>
        <p>Login to continue trading</p>
        <form onSubmit={handleLogin}>
          <input type="email" placeholder="Email Address" />
          <input type="password" placeholder="Password" />
          <button type="submit" className="login-btn">
            Login
          </button>
        </form>
        <p className="bottom-text">
          Don't have an account?
          <Link to="/register"> Register</Link>
        </p>
      </div>
    </div>
  );
}

export default Login;