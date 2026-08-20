import "./Register.css";
import { Link } from "react-router-dom";
import { FaChartLine } from "react-icons/fa";

function Register() {
  return (
    <div className="register-container">
      <div className="register-card">

        <div className="logo">
          <FaChartLine />
          <h1>OrderFlow</h1>
        </div>

        <h2>Create Account</h2>
        <p>Join OrderFlow today</p>

        <form>

          <input
            type="text"
            placeholder="Full Name"
          />

          <input
            type="email"
            placeholder="Email Address"
          />

          <input
            type="password"
            placeholder="Password"
          />

          <button className="register-btn">
            Register
          </button>

        </form>

        <p className="bottom-text">
          Already have an account?
          <Link to="/"> Login</Link>
        </p>

      </div>
    </div>
  );
}

export default Register;