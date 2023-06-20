import React from 'react'
import NotificationsActiveIcon from '@mui/icons-material/NotificationsActive';
import { Avatar } from '@mui/material';

const UserProfileSidebar = (props) => {
  return (
    <div class='flex space-x-2 items-center pl-2 mt-2 pb-2'>
      {/* bell */}
      <div class='text-discordBlue text-4xl basis-1/5'><NotificationsActiveIcon /></div>
      {/* user avatar */}
      <div class='basis-1/5 text-discordBlue'><Avatar src='../../../assets/Images/userprofile.jpg' /></div>
      {/* username */}
      <h2 class='basis-3/5 text-xl text-discordBlue'>{props.name}</h2>
    </div>
  )
}

export default UserProfileSidebar
