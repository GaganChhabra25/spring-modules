import React from 'react';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import HomePage from "./containers/HomePage";

function App() {
  return (
      <BrowserRouter>
          <div className="App">
            <HomePage/>
          </div>
      </BrowserRouter>


  );
}

export default App;
