import {LoginDTO} from "../dtos/LoginDTO";
import axios from "axios";

export const loginApiCall = async (props: LoginDTO) =>
{
    console.log(props);
    return await axios.post("http://localhost:5000/login", props)
        .then(response => {return response.data})
        .catch(error => console.log(error))
}