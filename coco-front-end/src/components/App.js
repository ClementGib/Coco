import Login from './login/Login'
import Home from './home/Home'
import Admin from './admin/Admin'
import { Route, BrowserRouter } from 'react-router-dom'
import '../style/main.css'

function App () {
  return (
    <div className='App'>
      <BrowserRouter>
        <Route exact path='/'>
          <Home />
        </Route>
        <Route exact path='/admin'>
          <Admin />
        </Route>

        {/* <Admin  url="localhost:9000/coco/openapi.json"/> */}
        {/* <Admin  url="https://petstore.swagger.io/v2/swagger.json"/> */}
        </BrowserRouter>
    </div>
  )
}

export default App
