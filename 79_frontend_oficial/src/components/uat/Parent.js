import React from 'react';
import Child from "./Child";

export default class Parent extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            counter:0,
            data: "Hefasssssssssssssssdfasdo y que seria"
        }
        this.updateThisCounter = this.updateThisCounter.bind(this)
        this.updateData = this.updateData.bind(this)
    }


    updateData(){
        this.setState({data:"hola"});
    }


    updateThisCounter(){
        this.setState({counter:this.state.counter + 1});
    }

    render() {
        return (
            <div style={{ backgroundColor: true ? "gray" : "white", marginRight:15 }}>
            <Child dataFromParent={this.state.data} triggerParentUpdate={this.updateThisCounter} triggerParentUpdate3={this.updateData} />
            <span>Parent Label {this.state.counter}</span>
            </div>
        );
    }
}