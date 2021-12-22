import Login from './login/Login'
import Home from './home/Home'
import '../style/main.css'

import SwaggerUI from "swagger-ui-react"
import "swagger-ui-react/swagger-ui.css"

function App () {
  return (
    <div className='App'>
      <SwaggerUI url='localhost:9000/coco/openapi.json' />
    </div>
  )
}

export default App
