import React from 'react'

export default function MyCourses () {
  return (
    <div className='content'>
      <section className='section-cours'>
      <div className="following-cours">
      <h2>Cours suivis</h2>
      <hr className="solid"/>
      <div className="inprogress-tab">
            <table >
              <tr>
                <th>Nom</th>
                <th>Inscription</th>
                <th>Progression</th>
                <th>Certificat</th>
              </tr>
              <tr>
                <td>Jill</td>
                <td>Smith</td>
                <td>50</td>
                <td>50</td>
              </tr>
              <tr>
                <td>Eve</td>
                <td>Jackson</td>
                <td>94</td>
                <td>50</td>
              </tr>
            </table> 
          </div>
          <div className="finish-tab">
            <table >
              <tr>
                <th>Nom</th>
                <th>Inscription</th>
                <th>Progression</th>
                <th>Certificat</th>
              </tr>
              <tr>
                <td>Jill</td>
                <td>Smith</td>
                <td>50</td>
                <td>50</td>
              </tr>
              <tr>
                <td>Eve</td>
                <td>Jackson</td>
                <td>94</td>
                <td>50</td>
              </tr>
            </table> 
          </div>
      </div>

      </section>
    </div>
  )
}
