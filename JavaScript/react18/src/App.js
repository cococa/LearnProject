import logo from "./logo.svg";
import "./App.css";
import Gallery from "./components/Gallery.js";
import Brace from "./components/Brace.js";
import Avatar from "./components/Avatar.js";
import Container from "./components/Container.js";
import List from "./components/List.js";
import Button from "./components/Button.js";
import FirstComponent  from "./components/FirstComponent.js";
import MoveContainer from "./components/MoveContainer.js";
import { Father } from "./book-components/Father";

import { useState } from "react";

function handleClick() {
  console.log("App Button clicked");
}


function App() {

  const [ text , setText ] = useState('123');

  return (
    <div className="App">
      <Father></Father>
      {/* <MoveContainer/> */}
      <FirstComponent ></FirstComponent>
      <div onClick={()=> { alert('clicked!'); setText("222")  }}><Button handleClick={handleClick} text={text}></Button></div>
      {1 > 2 ? <div>1</div> : <div>2</div>}
      <List></List>
      <Brace></Brace>
      <Container>
        <Avatar
          name="aaa"
          size={100}
          person={{ name: "cccc", src: "https://i.imgur.com/1bX5QH6.jpg" }}
        ></Avatar>
      </Container>
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
