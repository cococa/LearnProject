import logo from './logo.svg';
import './App.css';
import React from 'react';

class Test extends React.Component {

  constructor(props) {  
    super(props);
    this.state = {date: new Date(), isStart: false}
  }

  componentDidMount(){
    this.startClock()
  }

  componentWillUnmount(){
    this.stopClock();
  }

  tick() {
    this.setState({
      date: new Date()
    });
    this.setState({
      isStart: true
    })
  }

  startClock(){
    this.timerId = setInterval(() => {
      this.tick()
    }, 1000);
  }


  stopClock(){
    clearInterval(this.timerId);
      this.setState({
        isStart: false
      });
  }

  handleClick(e){
    e.preventDefault();
    console.log(this.state.isStart);
    if(this.state.isStart){
        this.stopClock();
    }else{
        this.startClock()
    }
  }


  updateDate(){
    this.setState({
      date: new Date()
    })  
  }

  render() {
    return (
      <div> 
        <h1>extends React.Component {this.props.name}</h1>
        <h1>{this.state.date.toLocaleTimeString()}</h1>
        <button onClick={(e) => this.handleClick(e)}>{this.state.isStart ? 'Stop' : 'Start'}</button>
        
      </div>
    );
  }
}

function FunctionComponent(props) {
  return <h1>FunctionComponent {props.name}</h1>
}

function App() {
  return (
    <div className="App">
      <Test name="123"></Test>
      <FunctionComponent name="123" ></FunctionComponent>
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
      </header>
    </div>
  );
}

export default App;
