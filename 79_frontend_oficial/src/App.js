
import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
//import logo from './logo.svg';
import Todos from './components/Todos'
//import Home from './components/Home'
import Products from './components/Products'
import ShoppingList from './components/ShoppingList'
import Post from './components/uat/Post'
//import Test1 from './components/uat/Test1'
//import Parent from './components/uat/Parent'
//import Child from './components/uat/Child'
import Login from './components/uat/Login'

import ReadTextArea from './components/uat/ReadTextArea'
//import Component2 from './components/uat/Component2'
import PassParameter from './components/uat/PassParameter'



class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      value: ''
    }
  }

  render() {
    return (
      <div>
        <Router>
          <div className="border border-primary">
            {/* <h5>Ejemplo 1 </h5> */}
            <Link to="/ShoppingList" className="btn btn-primary" value="Shopping List">Shopping Car</Link>
            <Link to="/Products" className="btn btn-primary" value="Products">Products</Link>
            <Link to="/Todos" className="btn btn-primary" value="Todos">Products</Link>
            {/* <Link to="/Test1" className="btn btn-primary" value="Test1">Test</Link> */}
            <Link to="/Post" className="btn btn-primary" value="Test">Post</Link>

            {/* <Link to="/Parent" className="btn btn-primary" value="Test">Parent</Link> */}
            {/* <Link to="/Child" className="btn btn-primary" value="Test">Child</Link> */}
            <Link to="/Login" className="btn btn-primary" value="Test">Login</Link>
            
            <Link to="/readTextArea" className="btn btn-primary" value="Test">readTextArea</Link>
            {/* <Link to="/Component2" className="btn btn-primary" value="Test">component2</Link> */}
            <Link to="/PassParameter" className="btn btn-primary" value="Test">PassParameter</Link>

          </div>
          <div>
            <Route path="/" exact component={Products} />
            <Route path="/ShoppingList" component={ShoppingList} />
            <Route path="/Products" component={Products} />
            <Route path="/Todos" component={Todos} />

            <Route path="/Post" component={Post} />

            {/* <Route path="/Test1" component={Test1} />             */}
            {/* <Route path="/Parent" component={Parent} /> */}
            {/* <Route path="/Child" component={Child} /> */}
            <Route path="/Login" component={Login} />
            
            <Route path="/ReadTextArea" component={ReadTextArea} />
            {/* <Route path="/Component2" component={Component2} /> */}
            <Route path="/PassParameter" component={PassParameter} />

          </div>
        </Router>

      </div>
    );
  }
}

export default App;