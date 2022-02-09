import React from 'react'
import SwaggerUI from 'swagger-ui-react'
import 'swagger-ui-react/swagger-ui.css'

import Header from '../layout/Header'
import Footer from '../layout/Footer'


function Admin () {
  return (
    <div>
      <Header />
      <SwaggerUI url='http://127.0.0.1:8080/coco/openapi' />
      <Footer />
    </div>
  )
}

export default Admin
