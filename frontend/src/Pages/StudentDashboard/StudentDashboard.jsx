import React from 'react'
import SidebarItem from '../../Components/Searchbar/SidebarItem/SidebarItem'
import Searchbar from '../../Components/Searchbar/Searchbar/Searchbar'
import UserProfileSidebar from '../../Components/Searchbar/UserProfileSidebar/UserProfileSidebar'
import logo from '../../assets/Images/logo.png'
import cctv from '../../assets/Images/cctv.svg'

const StudentDashboard = () => {
  return (
    <div class='h-screen w-screen flex justify-between'>
      {/* Sidebar */}
      <div class='basis-1/6 border-r-2 border-neonBlue '>
        {/* Project Logo */}
        {/* <h1 class='text-2xl text-blue-500 mt-6'>NCIT</h1> */}
        <div class='flex justify-center pt-2 items-center cursor-pointer'>
          <img alt='attendance guru logo' src={`${logo}`} class='w-12 h-12' />
        </div>
        <SidebarItem itemText='Dashboard' />
        <SidebarItem itemText='Classes' />
        <SidebarItem itemText='Calendar' />
        <SidebarItem itemText='Profile' />
        <SidebarItem itemText='Setting' />

        {/* sidebar elements */}
        {/* Dashboard */}
      </div>


      {/* middle section */}
      <div class='basis-4/6 border-r-2 border-neonBlue'>
        {/* Searchbar */}
        <div class='w-full flex justify-center items-center py-4'>
            <Searchbar />
        </div>
        

        {/* sidebar item title */}
        <h1 class='text-2xl text-neonBlue'>Dashboard</h1>

        {/* Graph */}
      </div>

      {/* Calendar and Profile section */}
      <div class='basis-1/6 py-2'>
        {/*  user profile sidebar*/}
        <UserProfileSidebar name="Student's Name" />

        {/* calendar */}
        <h1>Calendar Place</h1>

        <img src={`${cctv}`}></img>
      </div>
    </div>
  )
}

export default StudentDashboard
