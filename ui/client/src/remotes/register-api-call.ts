import {RegisterDTO} from "../dtos/RegisterDTO";
import axios from "axios";


export const loginApiCall = async (props: RegisterDTO) =>
{
    console.log(props);
    return await axios.post("http://localhost:5000/user/add", props)
        .then(response => {return response.data})
        .catch(error => console.log(error))
}