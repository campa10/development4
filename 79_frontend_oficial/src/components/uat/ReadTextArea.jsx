import React from 'react';

class ReadTextArea extends React.Component {
  constructor(props) {
    super(props);
    this.state = { firstName: "", lastName: "" };

    this.handleFirstNameChange = this.handleFirstNameChange.bind(this);
    this.handleLastNameChange = this.handleLastNameChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleFirstNameChange(event) {
    this.setState({ firstName: event.target.value });
  }

  handleLastNameChange(event) {
    this.setState({ lastName: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    alert("A name was submitted: " + this.state.firstName + this.state.lastName);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={this.state.firstName}
            onChange={this.handleFirstNameChange}
          />
        </label>
        <label>
          LastName:
          <input
            type="text"
            value={this.state.lastName}
            onChange={this.handleLastNameChange}
          />
        </label>
        <input type="submit" value="Submit" /> <br/><label> { this.state.lastName }</label>
        
      </form>
    );
  }
}

export default ReadTextArea;