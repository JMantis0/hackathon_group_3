import React, {useState} from "react";
import {loginApiCall} from "../remotes/login-api-call";
import {RegisterDTO} from "../dtos/RegisterDTO";

const Register = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    // const dispatch = useDispatch();

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
        let credentials: RegisterDTO = { username, password};
        loginApiCall(credentials).then(data => console.log(data));
        // dispatch(login(data));
    }
    return (
        <div>
            <input className="username-input" title={"username"} placeholder={"username"} onChange={changeHandler}/>
            <input className="password-input" title={"password"} placeholder={"password"} onChange={changeHandler}/>
            <button className={"register-button"} onClick={handleClick} >Register</button>
        </div>
    );
}
export default Register;