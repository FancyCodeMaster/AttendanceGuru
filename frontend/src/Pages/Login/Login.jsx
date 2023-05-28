import React, {useState} from 'react'
import './Login.css'
import {
    Link,
  } from "react-router-dom";

const Login = () => {
    const [email, updateEmail] = useState(null);
    const [password, updatePassword] = useState(null);

    const onButtonClick = () => {
        console.log(email,password);
    }
    
  return (
    <div className='login'>
      <div>
        <h1>Login</h1>
        <p>Email</p>
        <input type="email" placeholder='youremail@ncit.edu.np' onChange={(el) => updateEmail(el.target.value)}></input>
        <p>Password</p>
        <input type="password" placeholder='Password' onChange={(el) => updatePassword(el.target.value)}></input>
        <p>Not a user, <span><Link to="/signup">Sign Up</Link></span></p>
        <button onClick={onButtonClick}>Login</button>
      </div>
    </div>
  )
}

export default Login
