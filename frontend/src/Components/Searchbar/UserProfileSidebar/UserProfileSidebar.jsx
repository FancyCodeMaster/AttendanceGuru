import React from 'react'
import NotificationsActiveIcon from '@mui/icons-material/NotificationsActive';
import { Avatar } from '@mui/material';

const UserProfileSidebar = (props) => {
  return (
    <div class='flex space-x-5 items-center pl-2 mt-2 border-b-2 border-neonBlue pb-2'>
      {/* bell */}
      <div class='text-neonBlue text-4xl basis-1/5'><NotificationsActiveIcon /></div>
      {/* user avatar */}
      <div class='basis-1/5 text-neonBlue'><Avatar src='/broken-image.jpg' /></div>
      {/* username */}
      <h2 class='basis-3/5 text-xl text-neonBlue'>{props.name}</h2>
    </div>
  )
}

export default UserProfileSidebar
