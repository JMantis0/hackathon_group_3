import axios from "axios";

export const randomNameApi = async () => {
    return await axios.get("https://randomuser.me/api/?inc=name")
        .then(response => { return response.data })
        .catch(error => console.log(error))
}