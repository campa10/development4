





async post call
-------------------------------




parent child
---------------------------


callback function : child back to parent

-------------------------


using previous state 
---------------------------


pass data to another component
---------------------------

react setState sum/rest numbers
---------------------------
import React from "react";

class Test1 extends React.Component {

  state = { count: 0 }
  
  handleIncrement = () => {
    this.setState({ count: this.state.count + 1 })
  }
  
  handleDecrement = () => {
    this.setState({ count: this.state.count - 1 })
  }
    render() {
      return (
        <div>
          <div>
            {this.state.count}
          </div>
          <button onClick={this.handleIncrement}>Increment by 1</button>
          <button onClick={this.handleDecrement}>Decrement by 1</button>
        </div>
      )
    }
  }

export default Test1;



Date time  manejar las horas
---------------------------
import React from "react";

class Test1 extends React.Component {
  constructor(props) {
    super(props);
    this.state = { date: new Date() };
  }

  render() {
    return (
      <div>
        <h1>Hello, world!</h1>
        <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
      </div>
    );
  }
}

export default Test1;



read textArea
---------------------------
import React from "react";

class Test1 extends React.Component {
  constructor(props) {
    super(props);
    this.state = { value: "" };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    debugger;
  }

  handleChange(event) {
    this.setState({ value: event.target.value });
  }
  handleSubmit(event) {
    alert("A name was submitted: " + this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={this.state.value}
            onChange={this.handleChange}
          />{" "}
        </label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

export default Test1;



button handle click
--------------------------

import React from 'react';

class Test1 extends React.Component {

  handleClick = (e) => {
    e.preventDefault();
    console.log('The link was clicked.');
  };
 

  render() {
    
    return (
      <a href="https://www.bogantes.com" onClick={this.handleClick}>
        Click me
      </a>
    );
    
  }
}
export default Test1;



handler
--------------------------
import React, { Component } from "react";

class Test1 extends Component {
  constructor(props) {
    super(props);
    this.sayHello = this.sayHello.bind(this);
  }

  sayHello() {
    alert("Hello!");
  } 

  render() {
    return <button onClick={this.sayHello}>Click me!</button>;
  }
}

//Event hadling in react
function ActionLink() {
  function handleClick(e) {
    e.preventDefault();
    console.log("The link was clicked.");
  }

  return (
    <a href="https://www.bogantes.com" onClick={handleClick}>
      Click me
    </a>
  );
}

export default Test1;







funcion pasar parametros...
---------------------
import React from 'react';

function Test1() {
  const users = ['James', 'Nora', 'Matthew', 'Joe', 'Susan'];
  
  function deleteUserWithName(name) {
    console.log(name);
  }
  
  return (
    <ul>
      {users.map(name => (
        <li>
          <button onClick={() => deleteUserWithName(name)}>
            Click {name}
          </button>
        </li>
      ))}
    </ul>
  );
}

export default Test1;



pop up
----------------------
//
import React from 'react';

class Test1 extends React.Component {

  constructor(props) {
    super(props);
    this.sayHello = this.sayHello.bind(this);
  }

  sayHello() {
    alert('Hello!');
  }
  

  render() {
    return (
      <button onClick={this.sayHello}>
      Click me!
    </button>
    );
  }
}
export default Test1;




template
---------------------------

import React from 'react';

class Test1 extends React.Component {

 

  render() {
    return (
        <div>aa</div>
    );
  }
}
export default Test1;
