import React, { useState } from 'react'
import axios from 'axios';
import { Link } from 'react-router-dom'
import background from '../../assets/Images/background.png'

const Signup = () => {
    const [name, updateName] = useState(null);
    const [email, updateEmail] = useState(null);
    const [password, updatePassword] = useState(null);
    const [confirmPassword, updateConfirmPassword] = useState(null);

    const onButtonClick = (e) => {
        if(password === confirmPassword){
            e.preventDefault();
            postData();
        }else{
            window.alert("Two Passwords not matching");
        }
    }

    const postData = async () => {
        const formData = {
            name : name,
            email : email,
            password : password,
        }

        try{
            const response = await axios.post("http://localhost:8080/register/teacher", formData);
            const data = await response.data;
            console.log(data);
        }catch(error){
            console.log(error);
        }
    }
    
    return (
        <div class='bg-cover bg-center bg-no-repeat bg-fixed md:h-screen md:w-screen md:flex md:justify-center md:items-center' style={{backgroundImage : `url(${background})`}}>
            <div class='h-screen w-screen bg-discordBlack text-discordWhite py-10 px-6 md:w-1/3 md:h-auto'>
                <h1 class='text-center text-2xl'>Namaste</h1>
                <h2 class='mb-4 text-center text-lg'>Glad to see you for the first time!</h2>
                <p class='uppercase hidden md:block'>Name</p>
                <input type="text" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='Name' onChange={(el) => updateName(el.target.value)}></input>
                <p class='uppercase hidden md:block'>Email</p>
                <input type="email" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='email' onChange={(el) => updateEmail(el.target.value)}></input>
                <p class='uppercase hidden md:block'>Password</p>
                <input type="password" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='Password' onChange={(el) => updatePassword(el.target.value)}></input>
                <p class='uppercase hidden md:block'>Confirm Password</p>
                <input type="password" class='bg-discordDarkBlack w-full placeholder:uppercase mb-3 p-2 outline-none md:placeholder:text-discordDarkBlack' placeholder='Confirm Password' onChange={(el) => updateConfirmPassword(el.target.value)}></input>
                <p class='mb-4'>Already a user? <span class='text-discordBlue underline'><Link to="/login">Log In</Link></span></p>
                <button class='bg-discordBlue text-discordWhite border-discordBlue rounded-none w-full p-2' onClick={onButtonClick}>Signup</button>
            </div>
        </div>
    )
}

export default Signup
