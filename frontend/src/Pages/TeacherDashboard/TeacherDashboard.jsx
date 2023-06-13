import React from 'react'
import SidebarItem from '../../Components/Searchbar/SidebarItem/SidebarItem'
import Searchbar from '../../Components/Searchbar/Searchbar/Searchbar'
import UserProfileSidebar from '../../Components/Searchbar/UserProfileSidebar/UserProfileSidebar'

const TeacherDashboard = () => {
  return (
    <div class='h-screen w-screen flex justify-between'>
      {/* Sidebar */}
      <div class='basis-1/6 border-r-2 border-blue-500'>
        {/* NCIT header */}
        <h1 class='text-2xl text-blue-500 mt-6'>NCIT</h1>
        <SidebarItem itemText='Dashboard' />
        <SidebarItem itemText='Classes' />
        <SidebarItem itemText='Profile' />
        <SidebarItem itemText='Setting' />

        {/* sidebar elements */}
        {/* Dashboard */}
      </div>


      {/* middle section */}
      <div class='basis-4/6 border-r-2 border-blue-500'>
        {/* Searchbar */}
        <div class='w-full flex justify-center items-center py-4'>
            <Searchbar />
        </div>
        

        {/* sidebar item title */}
        <h1 class='text-2xl text-blue-500'>Dashboard</h1>

        {/* Graph */}
      </div>

      {/* Calendar and Profile section */}
      <div class='basis-1/6 py-2'>
        {/*  user profile sidebar*/}
        <UserProfileSidebar name="Teacher Name" />

        {/* calendar */}
      </div>
    </div>
  )
}

export default TeacherDashboard
