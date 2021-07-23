import React from 'react';
import './App.css';
import Login from "./components/Login";
import {Provider, useSelector} from "react-redux";
import {authState} from "./states/auth-slice";
import UserInfo from "./components/UserInfo";

function App() {
    let state = useSelector(authState);
  return (
      <div>
        <div>
            {!state.isLoggedIn ? <Login /> : <UserInfo/>}
            </div>
      </div>
  );
}

export default App;
