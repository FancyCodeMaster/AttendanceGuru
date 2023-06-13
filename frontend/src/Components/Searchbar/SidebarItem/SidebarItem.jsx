import React from 'react'
import HomeIcon from '@mui/icons-material/Home'

const SidebarItem = (props) => {
  return (
    <div class='flex items-center space-x-3 my-5 cursor-pointer border-2 border-white hover:border-blue-500 hover:bg-blue-500 hover:opacity-70 hover:text-white p-3'>
      {/* image */}
      <div class='text-blue-500'>
        <HomeIcon />
      </div>
      {/* text */}
      <h2 class='text-2xl'>{props.itemText}</h2>
    </div>
  )
}

export default SidebarItem
