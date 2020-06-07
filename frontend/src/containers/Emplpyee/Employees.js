import Employee from "./Employee";
import React from "react";

const employees = (props) => props.employees.map((employee) => {
    return <Employee
                firstName = {employee.firstName}
                lastName = {employee.lastName}
                email = {employee.email}
                id = {employee.id}
                key = {employee.id}
                click = {props.clicked}
            />
});

export default employees;