import React, {useState, useEffect} from 'react'
import SidebarItem from '../../Components/Searchbar/SidebarItem/SidebarItem'
import Searchbar from '../../Components/Searchbar/Searchbar/Searchbar'
import UserProfileSidebar from '../../Components/Searchbar/UserProfileSidebar/UserProfileSidebar'
import logo from '../../assets/Images/logo-handwritten.png'
import MenuIcon from '@mui/icons-material/Menu';
import CloseIcon from '@mui/icons-material/Close';
import Dashboard from '../DashboardPages/Dashboard/Dashboard'
import LineChartComp from '../../Components/Searchbar/LineChart/LineChart'
import SubjectPie from '../../Components/Searchbar/SubjectPie/SubjectPie'
import Calendar from '../DashboardPages/Calendar/Calendar'
import HomeIcon from '@mui/icons-material/Home'
import SchoolIcon from '@mui/icons-material/School';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import PersonIcon from '@mui/icons-material/Person';
import SettingsIcon from '@mui/icons-material/Settings';

import { useNavigate } from 'react-router-dom'



const StudentDashboard = () => {
  const navigate = useNavigate();
  
  const [showMenu, setShowMenu] = useState(true);

  const [dashboardClicked, setDashboarClicked] = useState(true);
  const [classesClicked, setClassesClicked] = useState(false);
  const [calendarClicked, setCalendarClicked] = useState(false);
  const [profileClicked, setProfileClicked] = useState(false);
  const [settingClicked, setSettingClicked] = useState(false);

  const onDashboardClicked = () => {
    setDashboarClicked(true);
    setClassesClicked(false);
    setCalendarClicked(false);
    setProfileClicked(false);
    setSettingClicked(false);
  }

  const onClassesClicked = () => {
    setDashboarClicked(false);
    setClassesClicked(true);
    setCalendarClicked(false);
    setProfileClicked(false);
    setSettingClicked(false);
  }

  const onCalendarClicked = () => {
    setDashboarClicked(false);
    setClassesClicked(false);
    setCalendarClicked(true);
    setProfileClicked(false);
    setSettingClicked(false);
  }

  const onProfileClicked = () => {
    setDashboarClicked(false);
    setClassesClicked(false);
    setCalendarClicked(false);
    setProfileClicked(true);
    setSettingClicked(false);
  }

  const onSettingClicked = () => {
    setDashboarClicked(false);
    setClassesClicked(false);
    setCalendarClicked(false);
    setProfileClicked(false);
    setSettingClicked(true);
  }

  useEffect(() => {
    let studentStatus = localStorage.getItem("student");
    // if(studentStatus !== 1){
    //   navigate('/login');
    // }
  })

  return (
    <>
    <div class='hidden md:flex md:h-screen md:w-screen  md:justify-between md:overflow-hidden'>
      {/* Sidebar */}
      <div class='basis-1/6'>
        {/* Project Logo */}
        {/* <h1 class='text-2xl text-blue-500 mt-6'>NCIT</h1> */}
        <div class='flex justify-center py-6 px-2 items-center cursor-pointer space-x-2 '>
          <img alt='attendance guru logo' src={`${logo}`} class='w-50 h-50' />
        </div>
        <div>
          <SidebarItem muiIcon={<HomeIcon />} itemText='Dashboard' textSize='text-lg' onClick={onDashboardClicked} leftBorder={(dashboardClicked)?'border-r-4 border-r-discordBlue bg-gray-300':''} />
          <SidebarItem muiIcon={<SchoolIcon />} itemText='Classes' textSize='text-lg' onClick={onClassesClicked} leftBorder={(classesClicked)?'border-r-4 border-r-discordBlue bg-gray-300':''} />
          <SidebarItem muiIcon={<CalendarMonthIcon />} itemText='Calendar' textSize='text-lg' onClick={onCalendarClicked} leftBorder={(calendarClicked)?'border-r-4 border-r-discordBlue bg-gray-300':''} />
          <SidebarItem muiIcon={<PersonIcon />} itemText='Profile' textSize='text-lg' onClick={onProfileClicked} leftBorder={(profileClicked)?'border-r-4 border-r-discordBlue bg-gray-300':''} />
          <SidebarItem muiIcon={<SettingsIcon />} itemText='Setting' textSize='text-lg' onClick={onSettingClicked} leftBorder={(settingClicked)?'border-r-4 border-r-discordBlue bg-gray-300':''} />
          <div class='flex justify-center'>
            <button class='text-center border-2 p-1 border-discordBlue bg-discordBlue text-white hover:bg-white hover:text-discordBlue'>Log Out</button>
          </div>
        </div>
        

        {/* sidebar elements */}
        {/* Dashboard */}
      </div>


      {/* middle section */}
      <div class='basis-5/6 bg-gray-100 pb-10'>
        {/* Searchbar */}
        <div class='w-full flex  items-center py-4 bg-gray-300'>
            <Searchbar />
            <div class=''>
                <UserProfileSidebar />
            </div>
        </div>
        
        {(dashboardClicked)?
        (<><h1 class='text-2xl text-discordBlue text-center mt-2'>Dashboard</h1>

        <div class='my-6'>
          <h3 class='text-lg text-discordBlue text-center mb-1'>Attendance Overview</h3>
          <LineChartComp />
        </div>

        {/* Subject Pies */}
        <div>
          <h3 class='text-center text-lg text-discordBlue mb-4'>Attendance per Subject</h3>
          <div class='flex w-full justify-center space-x-5'>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={80} subjectName="PPL" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={75} subjectName="CN" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={65} subjectName="EE" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={70} subjectName="OOSD" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={85} subjectName="MMS" widthHeight='w-32 h-32' />
            </div>
          </div>
        </div></>):null}


        {(classesClicked)?(
          <div class='px-20 w-full h-full'>
          <h1 class='text-center text-2xl text-discordBlue my-4 mb-8'>Classes</h1>
          <div class='flex w-full justify-center space-x-5 flex-wrap'>
            <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
              <SubjectPie percentage={80} subjectName="PPL" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
              <SubjectPie percentage={75} subjectName="CN" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
              <SubjectPie percentage={65} subjectName="EE" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
              <SubjectPie percentage={70} subjectName="OOSD" widthHeight='w-32 h-32' />
            </div>
            <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
              <SubjectPie percentage={85} subjectName="MMS" widthHeight='w-32 h-32' />
            </div>
          </div>
        </div>
        ):null
        }

        {(profileClicked)?(
          <h1>profile</h1>
        ):null
        }

        {(calendarClicked)?(
          <h1>calendar</h1>
        ):null
        }

        {(settingClicked)?(
          <h1>setting</h1>
        ):null
        }
      </div>
    </div>



    {/* For smaller Device */}
    <div class='h-screen w-screen no-scrollbar md:hidden'>
      <div class='p-3 flex items-center justify-between'>
          {/* handwritten logo */} 
          <div class='w-40 cursor-pointer justify-self-start'>
            <img src={logo} alt='attendance guru logo' />
          </div>
          {/* hamburger icon */}
          <div class='text-discordBlue text-md justify-self-end dark:text-white' onClick={() => setShowMenu(!showMenu)}>
            {(showMenu)?<MenuIcon />:<CloseIcon />}
          </div>
      </div>

      {/* sidebar items */}
      {(!showMenu)?(<div>
        <SidebarItem itemText='Dashboard' textSize='text-lg' onClick={onDashboardClicked} leftBorder={(dashboardClicked)?'border-l-4 border-l-discordBlue bg-gray-100':''} />
        <SidebarItem itemText='Classes' textSize='text-lg' onClick={onClassesClicked} leftBorder={(classesClicked)?'border-l-4 border-l-discordBlue bg-gray-100':''} />
        <SidebarItem itemText='Calendar' textSize='text-lg' onClick={onCalendarClicked} leftBorder={(calendarClicked)?'border-l-4 border-l-discordBlue bg-gray-100':''} />
        <SidebarItem itemText='Profile' textSize='text-lg' onClick={onProfileClicked} leftBorder={(profileClicked)?'border-l-4 border-l-discordBlue bg-gray-100':''} />
        <SidebarItem itemText='Setting' textSize='text-lg' onClick={onSettingClicked} leftBorder={(settingClicked)?'border-l-4 border-l-discordBlue bg-gray-100':''} />
      </div>):null}

      {(showMenu && dashboardClicked)?(
        <div class='w-full'>
          <h3 class='text-lg text-discordBlue text-center mb-1'>Attendance Overview</h3>
          <LineChartComp />
          <div>
          <h3 class='text-center text-lg text-discordBlue mb-4'>Attendance per Subject</h3>
          <div class='flex w-full justify-center space-x-5 flex-wrap px-20'>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={80} subjectName="PPL" widthHeight='w-40 h-40' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={75} subjectName="CN" widthHeight='w-40 h-40' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={65} subjectName="EE" widthHeight='w-40 h-40' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={70} subjectName="OOSD" widthHeight='w-40 h-40' />
            </div>
            <div class='flex flex-col space-y-2'>
              <SubjectPie percentage={85} subjectName="MMS" widthHeight='w-40 h-40' />
            </div>
          </div>
        </div>
        </div>
      ):null
      }

      {(showMenu && classesClicked)?(
        <div class='px-20 w-full h-full'>
        <h1 class='text-center text-2xl text-discordBlue my-4 mb-8'>Classes</h1>
        <div class='flex w-full justify-center space-x-5 flex-wrap'>
          <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
            <SubjectPie percentage={80} subjectName="PPL" widthHeight='w-32 h-32' />
          </div>
          <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
            <SubjectPie percentage={75} subjectName="CN" widthHeight='w-32 h-32' />
          </div>
          <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
            <SubjectPie percentage={65} subjectName="EE" widthHeight='w-32 h-32' />
          </div>
          <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
            <SubjectPie percentage={70} subjectName="OOSD" widthHeight='w-32 h-32' />
          </div>
          <div class='flex flex-col space-y-2 border-1 border-white shadow-discordBlue shadow-lg hover:shadow-md hover:shadow-discordBlue p-10 mb-20'>
            <SubjectPie percentage={85} subjectName="MMS" widthHeight='w-32 h-32' />
          </div>
        </div>
      </div>
      ):null
      }

      {(showMenu && profileClicked)?(
        <h1>profile</h1>
      ):null
      }

      {(showMenu && calendarClicked)?(
        <h1>calendar</h1>
      ):null
      }

      {(showMenu && settingClicked)?(
        <h1>setting</h1>
      ):null
      }
      
    </div>
    </>
  )
}

export default StudentDashboard
