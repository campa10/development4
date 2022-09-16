import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

class Products extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: [],
    };
  }

  componentDidMount() {
    fetch("atenas/getall?param1=Producto")
      .then((res) => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result.items,
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error,
          });
        }
      );
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
      return <div>Loading...</div>;
    } else {
      // var abc = "abc";
      // debugger;

      return (
        <div>
          ,<div>Products</div>
          <ul>
            {items.map((item) => (
              <li
                key={item.productoid}
                style={{ display: "block", float: "left", padding: "16px" }}
                className="border border-primary"
              >
                <a href="https://www.google.com">
                  <img src={item.pict1} alt="ss" />
                  <br />
                  {item.productname}
                  <br />
                  {item.titulo}{" "}
                </a>
              </li>
            ))}
          </ul>
        </div>
      );
    }
  }
}
export default Products;
