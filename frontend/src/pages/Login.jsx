import "./Login.css";
import { Link } from "react-router-dom";
import { FaChartLine } from "react-icons/fa";

function Login() {
  return (
    <div className="login-container">
      <div className="login-card">

        <div className="logo">
          <FaChartLine />
          <h1>OrderFlow</h1>
        </div>

        <h2>Welcome Back</h2>
        <p>Login to continue trading</p>

        <form>

          <input
            type="email"
            placeholder="Email Address"
          />

          <input
            type="password"
            placeholder="Password"
          />

          <button 
             type="button"
            className="login-btn"
            onClick={() => window.location.href="/dashboard"}
          > 
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