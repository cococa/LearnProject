import logo from './logo.svg';
import {createElement } from 'react';
import React from 'react';
import './App.css';


function testGetName(){
  return "cocoa";
}

// const ElementRedDiv = createElement(
//   'h1',
//   {className:'redText'},
//   'hello world'
// );

function FormattedDate(props) {
  return <h2>child componrnt FormattedDate It is {props.date.toLocaleTimeString()}.</h2>;
}


class Welcome extends React.Component{
  render(){
    return <div className="red-text"> Welcome {this.props.name}</div>;
  }
}


class Timer extends React.Component{

    constructor(props){
      super(props);
      this.state = {date: new Date(),isToggleOn : true};
      // this.testClick = this.testClick.bind(this);

    }

    componentDidMount(){
        this.timerId = setInterval(()=>{
            this.tick();
        },1000);
    }

    componentWillUnmount(){
        clearInterval(this.timerId);
    }

    tick(){
      this.setState({
          date: new Date()
      });
    }

    testClick(e,id){
      console.log("testClick"+ JSON.stringify(id));
      this.setState(state => ({
          isToggleOn : !state.isToggleOn
      }));
    }


    List(){
      const numbers  = [1,2,3]  
      return numbers.map((item)=>
                   <li key={item.toString()}>{item* item }</li>
                );
    }

    render(){
      return (
            <div>
                <ul>{this.List()}</ul>
                <button onClick={(e) => this.testClick(e,1)}>testClick{this.state.isToggleOn ? 'on' : 'off'}</button>
                <h1>{this.state.date.toLocaleTimeString()}</h1>
                <FormattedDate date={this.state.date} />
            </div>
      );
    }
}



function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Welcome name='sj'> </Welcome>
        <Timer ></Timer>
        <div> {testGetName()} </div>
      </header>
    </div>
  );
}

export default App;
