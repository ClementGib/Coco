// ANCHOR Basic Header for the login page

import React from 'react'


import '../../style/main.css'
import Logo from '../../assets/icons/logo-white.svg'

export default function BasicHeader () {
  return (
      <header className='basic-head'>
            <img
              src={Logo}
            />
      </header>
  )
}

