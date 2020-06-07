import React, {Component} from "react";
import {Api} from "../service/ApplicationContext";
import Employees from "./Emplpyee/Employees";
import {Link} from "react-router-dom";
import {Route, Router, Switch} from "react-router";
import About from "./About/About";
import Contact from "./ContactUs/Contact";
class HomePage extends Component {

    constructor(props){
        super(props);
        this.state = {
            employees : [],
            showEmployees: false
        }
    }
    componentDidMount() {
        Api.get("/employees").then((data) => {
            this.setState({
                employees: data
            })
        }).catch((error) => {
            console.log("Unable to fetch employees", error);
        })
    }

    showEmployeesHandler = () => {
        let showEmployees = this.state.showEmployees;
        this.setState({
            showEmployees : !showEmployees
        })
    };

    deleteEmployeeHandler = (Id) => {
        console.log('clicked', Id);
        Api.delete("/employees", Id).then((response) => {
            console.log("Employee deleted Successfully");
            const filteredEmployees = this.state.employees.filter(employee => employee.id !== Id)
            this.setState({
                employees: filteredEmployees
            })
        }).catch((error) => {
            console.log("Unable to delete Employee", error);
        })
    };

    render() {
        const style = {
            'display':'flex'
        };

        let employees = (
            <div className="employees" style={style}>
                <Employees
                    employees={this.state.employees}
                    clicked={this.deleteEmployeeHandler}
                />
            </div>
        );

      return(
          <div className="homepage">
              <h1>Welcome to User management system</h1>
              <ul>
                  <li>
                      <Link to="/">Home</Link>
                  </li>
                  <li>
                      <Link to="/about">About</Link>
                  </li>
                  <li>
                      <Link to="/contact">Contact</Link>
                  </li>
              </ul>
              <button onClick={this.showEmployeesHandler}>Show Employees</button>
              {this.state.showEmployees && employees}
              <Switch>
                  <Route path='/about' component={About} exact />
                  <Route path='/contact' component={Contact} exact/>
              </Switch>
          </div>
      )
    }
}
export default HomePage