// import React, { Component } from 'react';
import { Route, BrowserRouter as Router, Switch } from 'react-router-dom';
import Category from './Category';
import Home from './home';
import Expenses from './Expenses';



function App() {
  return (
    <Router>
      <Switch>
        <Route path='/' exact={true} component={Home}/>
        <Route path='/Expenses' exact={true} component={Expenses}/>
        <Route path='/categories' exact={true} component={Category}/>
      </Switch>
    </Router>

  );
}

export default App;