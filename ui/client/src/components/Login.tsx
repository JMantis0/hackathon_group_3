import React, {useState} from "react";
import {LoginDTO} from "../dtos/LoginDTO";
import {loginApiCall} from "../remotes/login-api-call";
import {useDispatch} from "react-redux";
import {login} from "../states/auth-slice";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const dispatch = useDispatch();


    const changeHandler = (e: any) => {
        if (e.target.className === "username-input")
        {
            setUsername(e.target.value);
        } else
        {
            setPassword(e.target.value);
        }
    }
    const handleClick = () => {
        let token = '';
        let id = 0;
        let credentials: LoginDTO = { username, password};
        loginApiCall(credentials).then(data =>
        {
            console.log(data)
            dispatch(login(data));
        });
    }
    return (
        <div>
            <input className="username-input" title={"username"} placeholder={"username"} onChange={changeHandler}/>
            <input className="password-input" title={"password"} placeholder={"password"} onChange={changeHandler}/>
            <button className={"login-button"} onClick={handleClick} >Login</button>
        </div>
);
}
export default Login;