// import logo from "./logo.svg";
import "./App.css";
import React from "react";
import { Routes, Route } from "react-router-dom";



class TestRouter extends React.Component {

  render() {
    return (
      <div >
        TestRouter
      </div>
    );
  }
}


class UserList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: "",
    };
  }

  handleChange(event) {
    this.setState({
      userName: event.target.value,
    });
  }
  handleClick(e) {
    e.preventDefault();
    if (this.state.userName && this.state.userName.length > 0) {
      this.props.onAddUser(this.state.userName);
    }
  }

  render() {
    return (
      <div className="red">
        <h5>红色区域为UserList 子组件, 演示子组件和父组件进行交互</h5>
        <input
          onChange={(e) => this.handleChange(e)}
          value={this.state.userName}
        ></input>
        <button onClick={(e) => this.handleClick(e)}> add user</button>
        {this.props.userList.map((user) => {
          return <div key={user.id}>{user.name}</div>;
        })}
      </div>
    );
  }
}

class Test extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      date: new Date(),
      isStart: false,
      a: "a",
      list: [1, 2, 3],
      name: "",
      userList: [
        { id: 1, name: "张三" },
        { id: 2, name: "李四" },
      ],
    };
  }

  updateA() {
    this.setState({
      a: "b",
    });
  }

  componentDidMount() {
    this.startClock();
  }

  componentWillUnmount() {
    this.stopClock();
  }

  tick() {
    this.setState({
      date: new Date(),
    });
    this.setState({
      isStart: true,
    });
  }

  startClock() {
    this.timerId = setInterval(() => {
      this.tick();
    }, 1000);
  }

  stopClock() {
    clearInterval(this.timerId);
    this.setState({
      isStart: false,
    });
  }

  handleClick(e) {
    e.preventDefault();
    console.log(this.state.isStart);
    if (this.state.isStart) {
      this.stopClock();
    } else {
      this.startClock();
    }
  }

  onInputChaned(e) {
    this.setState({
      name: e.target.value,
    });
  }

  addUser(e) {
    console.log(e);
    this.setState({
      userList: this.state.userList.concat({
        id: this.state.userList.length + 1,
        name: e,
      }),
    });
  }

  render() {
    return (
      <div>
        <UserList
          userList={this.state.userList}
          onAddUser={(e) => this.addUser(e)}
        ></UserList>
        <h1>extends React.Component {this.props.name}</h1>
        <h1>{this.state.date.toLocaleTimeString()}</h1>
        <button onClick={(e) => this.handleClick(e)}>
          {this.state.isStart ? "Stop" : "Start"}
        </button>
        {this.state.list.map((item, index) => (
          <div key={index}>
            {" "}
            list {index}---{item * item}
          </div>
        ))}
        <h1>Hello this.state.name = {this.state.name}</h1>
        <input
          value={this.state.name}
          onChange={(e) => this.onInputChaned(e)}
        ></input>
      </div>
    );
  }
}

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Routes>
          <Route path="/" element={<Test />}></Route>
          <Route path="/test" element={<TestRouter/>}></Route>
        </Routes>
      </div>
    );
  }
}

export default App;
