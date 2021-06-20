// ANCHOR Login content with form connexion

import React from 'react'

export default function Content () {
  return (
    <section className='section-login'>
      <div className='form-wrapper'>
        <header className='form-head'>
          <h2>Connexion</h2>
        </header>

        <form action='' className='form-container'>
          <div className='form-elements'>
            <div className='input-form'>
              <input type='email' placeholder='Email' name='user' required />
              <input
                type='password'
                placeholder='Mot de passe'
                name='password'
                required
              />
            </div>

            <div className='remember-form'>
              <input type='checkbox' name='remember' />
              <label for='remember'> Se souvenir de moi</label>
            </div>
          </div>

          <div className='button-form'>
            <button type='submit'>Connexion</button>
          </div>
        </form>

        <p>
          Coco <span dangerouslySetInnerHTML={{ __html: '&copy;' }} />
        </p>
      </div>
    </section>
  )
}
