import React from 'react'
import SearchIcon from '@mui/icons-material/Search';

const Searchbar = () => {
  return (
    <div class='pl-5 pr-80 relative rounded w-full'>
      {/* search icon */}
      <div class='absolute left-8 top-3 text-discordBlue'><SearchIcon /></div>
      
      {/* input box */}
      <input type='text' class='focus:w-full w-64 pl-12 py-2 text-lg border-2 outline-none border-discordBlue text-discordBlue' placeholder='Search' />
    </div>
  )
}

export default Searchbar
