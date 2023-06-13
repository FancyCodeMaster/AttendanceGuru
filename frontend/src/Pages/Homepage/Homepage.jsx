import React from 'react'
import UserCard from '../../Components/Searchbar/UserCard/UserCard'
import background from '../../assets/Images/homepage.jpg'

const Homepage = () => {
  return (
    <div class="h-screen w-screen flex justify-center items-center bg-no-repeat bg-center" style={{backgroundImage : `url(${background})`}}>
        <div class="bg-gradient-to-r from-blue-500 to-pink-500 p-6">
          <h1 class="text-3xl mb-10 text-white">Are You</h1>
          <div class="flex flex-col justify-between items-center md:flex-row">
            <UserCard userType="Student" />
            <h1 class='mr-4 text-2xl text-white'>OR</h1>
            <UserCard userType="Teacher" />
          </div>
        </div>
    </div>
  )
}

export default Homepage
