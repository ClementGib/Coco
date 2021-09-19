// ANCHOR main Header of the App

import React, { useState } from 'react'

import '../../style/main.css'
import Logo from '../../assets/icons/logo-white.svg'
import Search from '../../assets/icons/search-grey.svg'

export default function Header () {

  return (
    <div>
      <header className='main-head'>
        <nav className='navbar'>
          <div className='container-navbar'>
            <img className='logo-navbar' src={Logo} alt='Logo' />

            <div className='cours-navbar'>
              <button className='btn-navbar'>
                <span>Cours</span>
              </button>
              <div className='bar-navbar'></div>
            </div>

            <div className='search-navbar'>
              <img
                className='search-img'
                src={Search}
                alt='Rechercher des cours'
              />
              <input
                placeholder='Rechercher'
                type='text'
                className='input-navbar'
              />
            </div>

            <div className='block-navbar'>
              <div className='profil-navbar'>
                <button className='btn-navbar'>
                  <span>Profil</span>
                </button>
                <div className='bar-navbar'></div>
              </div>

              <div className='disconnect-navbar'>
                <button className='btn-navbar'>
                  <span>Déconnexion</span>
                </button>
                <div className='bar-navbar'></div>
              </div>
            </div>
          </div>
        </nav>
      </header>

      <nav class='subnavbar'>
        <div class='container-subnavbar'>
          <div class='allcours-subnavbar'>
            <button class='btn-navbar'>
              <span>Tous les cours</span>
            </button>
            <div class='bar-navbar'></div>
          </div>

          <div class='mycours-subnavbar'>
            <button class='btn-navbar'>
              <span>Mes cours</span>
            </button>
            <div class='bar-navbar'></div>
          </div>

          <div class='suggestion-subnavbar'>
            <button class='btn-navbar'>
              <span>Suggestion</span>
            </button>
            <div class='bar-navbar'></div>
          </div>
        </div>
      </nav>
    </div>
  )
}
