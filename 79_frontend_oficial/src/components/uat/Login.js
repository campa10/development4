import React from 'react';
import axios from 'axios';


class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = { UserName: "", Password: "" };

    this.handleUserNameChange = this.handleUserNameChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  
  baseUrl = 'atenas/login';


  handleUserNameChange(event) {
    this.setState({ UserName: event.target.value });
  }

  handlePasswordChange(event) {
    this.setState({ Password: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    debugger;
    alert("A name was submitted: " + this.state.UserName + this.state.Password);
  }


  myFunction() {
    this.props.history.push("/Products");
  }


  handleSubmit = event => {
    event.preventDefault();
    const user = {
      name: this.state.name
    };
    axios.post('atenas/login?param1=Login&param2=' + this.state.UserName + '&param3=' + this.state.Password, {user})
      .then(res => {
        this.myFunction();
        //console.log(res);
        //console.log(res.data);
        //console.log(user.name);
      })
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>   Name:<input type="text" value={this.state.UserName} onChange={this.handleUserNameChange} /> </label>
        <label> Password: <input type="text" value={this.state.Password} onChange={this.handlePasswordChange} /></label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

export default Login;