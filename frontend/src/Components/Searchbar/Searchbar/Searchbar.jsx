import React from 'react'
import SearchIcon from '@mui/icons-material/Search';

const Searchbar = () => {
  return (
    <div class='px-28 relative rounded w-full'>
      {/* search icon */}
      <div class='absolute left-32 top-2 text-neonBlue'><SearchIcon /></div>
      
      {/* input box */}
      <input type='text' class='w-full pl-12 text-lg border-2 border-neonBlue text-neonBlue rounded-lg' placeholder='Search' />
    </div>
  )
}

export default Searchbar
