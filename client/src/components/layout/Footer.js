// ANCHOR main Footer of the App

import React from 'react'
import Question from '../../assets/icons/question-white.svg'
import Logo from '../../assets/icons/logo-blue.svg'

export default function Footer () {
  return (
    <footer>
      <div class='separator-bar'></div>

      <div class='footer-wrapper'>
        <div class='question'>
          <div class='container-question'>
            <div class='img-question' for='button-question'>
              <input
                type='image'
                src={Question}
                alt=''
              />
            </div>

            <div class='btn-question'>
              <button id='button-question'>Besoin d'aide ?</button>
            </div>
          </div>
        </div>

        <div class='sitemap'>
          <a>Cours</a>
          <a>Profil</a>
          <a>Contact</a>
          <a>Termes</a>

          <p id='copy-footer'>Coco &copy</p>
        </div>

        <div class='more'>
          <div class='logo-mini'>
            <img src={Logo} alt='' />
          </div>

          <div class='author'>
            <h3>Clément G</h3>
          </div>

          <div class='contact'>
            <button>Email me.</button>
          </div>
        </div>
      </div>
    </footer>
  )
}
