import React, { Component } from 'react'
import AppNav from './appNav';

class  Home extends Component {
    state = {  } 
    render() { 
        return (
        <div>
        <AppNav/>
        <h2>
        Welcome to Expence App
        </h2>
        </div>

        
        );
    }
}
 
export default Home;