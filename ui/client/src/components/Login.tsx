import React, {useState} from "react";
import {LoginDTO} from "../dtos/LoginDTO";
import {loginApiCall} from "../remotes/login-api-call";
import {useDispatch} from "react-redux";
import {login} from "../states/auth-slice";
import "./login.css"
import {fetchUserApiCall} from "../remotes/fetch-user-api-call";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const dispatch = useDispatch();


    const changeHandler = (e: any) => {
        if (e.target.className === "username-input") {
            setUsername(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }
    const handleClick = (e: any) => {

        let credentials: LoginDTO = {username, password};
        loginApiCall(credentials).then(data => {
            console.log(data)
            dispatch(login(data));
        });
    }
    return (
        <div className="login-div">
            <div className="username-div">
                <input className="username-input" title={"username"} placeholder={"username"} onChange={changeHandler}/>
            </div>
            <div className="password-div">
                <input className="password-input" title={"password"} placeholder={"password"} onChange={changeHandler}/>
            </div>
            <div>
                <button className={"login-button"} onClick={handleClick}>Login</button>
            </div>
            <div>
                <button className={"fetch-test"} onClick={handleClick}>Test</button>
            </div>
        </div>
    );
}
export default Login;