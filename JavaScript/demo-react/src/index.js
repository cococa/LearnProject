import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
// import { Router, Route,hashHistory } from 'react-router'
// import { BrowserRouter as Router, Route } from 'react-router-dom';
// var ReactRouter = require('react-router')
// var Router = ReactRouter.Router
// var Route = ReactRouter.Route
// var Link = ReactRouter.Link

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,

  // (
  //   <Router >
  //   <Route path="/" component={App}>
  //   </Route>
  // </Router>
  // ), 
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
