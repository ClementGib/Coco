import Login from './login/Login'
import Home from './home/Home'
import Admin from './admin/Admin'
import '../style/main.css'

function App () {
  return (
    <div className='App'>
      <Admin  url="localhost:9000/coco/openapi.json"/>
      {/* <Admin  url="https://petstore.swagger.io/v2/swagger.json"/> */}
    </div>
  )
}

export default App
