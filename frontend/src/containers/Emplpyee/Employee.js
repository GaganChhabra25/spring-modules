import React from "react";

const employee = (props) => {
    let style = {
        'width' : 200,
        'border': '1px solid blue',
        'marginLeft' : 20,
        'margiRight' : 20
    };
    return (
        <div className="employee" style={style} onClick={() => props.click(props.id)}>
            <p>First Name : {props.firstName}</p>
            <p>Last Name : {props.lastName}</p>
            <p>Email : {props.email}</p>
        </div>
    );
};

export default employee