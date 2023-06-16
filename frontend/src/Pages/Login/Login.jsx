import React, {useState} from 'react'
import axios from 'axios';
import background from '../../assets/Images/background.png'
import {
    Link,
  } from "react-router-dom";

const Login = () => {
  const [email, updateEmail] = useState(null);
  const [password, updatePassword] = useState(null);

  const onButtonClick = (e) => {
    e.preventDefault();
    if(email !== '' && password !== '') postData();
  }

  const postData = async () => {
      const formData = {
          email : email,
          password : password,
      }

      try{
          const response = await axios.post("http://localhost:8080/signIn", formData);
          const data = await response.data;
          console.log(data);
      }catch(error){
          console.log(error);
      }
  }
    
  return (
    <div class='bg-cover bg-center bg-no-repeat bg-fixed md:h-screen md:w-screen md:flex md:justify-center md:items-center' style={{backgroundImage : `url(${background})`}}>
      <div class='h-screen w-screen bg-discordBlack text-discordWhite py-10 px-6  md:h-auto md:w-1/3'>
        <h1 class='text-center text-2xl'>Welcome again!</h1>
        <h2 class='mb-4 text-center text-lg'>Glad to see you again</h2>
        <p class='uppercase hidden md:block'>Email</p>
        <input type="email" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='email' onChange={(el) => updateEmail(el.target.value)}></input>
        <p class='uppercase hidden md:block'>Password</p>
        <input type="password" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='password' onChange={(el) => updatePassword(el.target.value)}></input>
        <p class='mb-4'>Not a user, <span class='text-discordBlue underline'><Link to="/signup">Sign Up</Link></span></p>
        <button class='bg-discordBlue text-discordWhite border-discordBlue rounded-none w-full p-2' onClick={onButtonClick}>Login</button>
      </div>
    </div>
  )
}

export default Login
