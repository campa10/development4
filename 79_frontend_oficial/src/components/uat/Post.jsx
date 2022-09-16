import React from "react";


class Post extends React.Component {

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
export default Post;