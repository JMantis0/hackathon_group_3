import axios from "axios";

export const fetchUserApiCall = async (props: any) => {
    return await axios.get("http://localhost:5000/user?", {params: {id: props}})
                .then(response => {return response.data})
                .catch(error => console.log(error))
}