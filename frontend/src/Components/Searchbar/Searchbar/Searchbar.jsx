import React from 'react'
import SearchIcon from '@mui/icons-material/Search';

const Searchbar = () => {
  return (
    <div class='px-28 relative rounded w-full'>
      {/* search icon */}
      <div class='absolute left-32 top-3 text-discordBlue'><SearchIcon /></div>
      
      {/* input box */}
      <input type='text' class='w-full pl-12 py-2 text-lg border-2 outline-none border-discordBlue text-discordBlue rounded-lg' placeholder='Search' />
    </div>
  )
}

export default Searchbar
