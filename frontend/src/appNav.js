import React, { Component } from 'react';
import {Nav,Navbar,NavItem,NavbarBrand, NavLink} from 'reactstrap';


class AppNav extends Component {
    state = {  }
    render() {
        return (
          <div>
            <Navbar color="dark" dark  expand="md">
              <NavbarBrand href="/">Project Expense Tracker</NavbarBrand>
                <Nav className="ml-auto" navbar>
                  <NavItem>
                    <NavLink href="/">Project Expence Overveiw</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/categories">Categories</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/expenses">Expenses</NavLink>
                  </NavItem>
                
                </Nav>
          
            </Navbar>
          </div>
        );
      }
}
 
export default AppNav;