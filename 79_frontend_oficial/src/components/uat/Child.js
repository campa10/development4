import React from 'react';

class Child extends React.Component {

    // constructor(props) {
    //     super(props)
    // }


    render() {

        return (
            <ul>
                <a href="https://www.bogantes.com">child:{this.props.dataFromParent}</a>
                <br />
                <button onClick={this.props.triggerParentUpdate} >Update parent </button>
                {/* <button onClick={this.props.triggerParentUpdate3} >cambiar data </button> */}
            </ul>
        );
    }
}

export default Child;