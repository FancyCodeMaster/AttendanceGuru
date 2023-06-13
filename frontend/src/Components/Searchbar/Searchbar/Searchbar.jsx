import React from 'react'
import SearchIcon from '@mui/icons-material/Search';

const Searchbar = () => {
  return (
    <div class='px-28 relative rounded w-full'>
      {/* search icon */}
      <div class='absolute left-32 top-2 text-blue-500'><SearchIcon /></div>
      
      {/* input box */}
      <input type='text' class='w-full pl-12 text-lg border-2 border-blue-500 text-blue-500 rounded-lg' placeholder='Search' />
    </div>
  )
}

export default Searchbar
