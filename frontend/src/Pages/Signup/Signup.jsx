import React, { useState } from 'react'
import axios from 'axios';
import './Signup.css'
import { Link } from 'react-router-dom'

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
            const response = await axios.post("localhost:8080/register/teacher", formData);
            const data = await response.json();
            console.log(data);
        }catch(error){
            console.log(error);
        }
    }
    
    return (
        <div className='signup'>
            <div>
                <h1>Signup</h1>
                <p>Name</p>
                <input type="text" placeholder='Your Name' onChange={(el) => updateName(el.target.value)}></input>
                <p>Email</p>
                <input type="email" placeholder='youremail@ncit.edu.np' onChange={(el) => updateEmail(el.target.value)}></input>
                <p>Password</p>
                <input type="password" placeholder='Password' onChange={(el) => updatePassword(el.target.value)}></input>
                <p>Confirm Password</p>
                <input type="password" placeholder='Confirm Password' onChange={(el) => updateConfirmPassword(el.target.value)}></input>
                <p>Already a user? <span><Link to="/login">Log In</Link></span></p>
                <div><button onClick={onButtonClick}>Signup</button></div>
            </div>
        </div>
    )
}

export default Signup
