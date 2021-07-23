import {useDispatch, useSelector} from "react-redux";
import {authState, finishedLoading} from "../states/auth-slice";
import {fetchUserApiCall} from "../remotes/fetch-user-api-call";

const UserInfo = () => {
    const state = useSelector(authState);
    const dispatch = useDispatch();
    if(!state.isLoaded) {
        fetchUserApiCall(1).then(data => {
            dispatch(finishedLoading(data.characters));
        }).catch(error => console.log(error))
    }
    return(
        <div>
            <div>
                <h1>User: {state.username}</h1>
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Health</th>
                        <th>Height</th>
                        <th>Magic Damage</th>
                        <th>Physical Damage</th>
                        <th>Strength</th>
                        <th>Speed</th>
                        <th>Weight</th>
                    </tr>
                    </thead>
                    <tbody>
                    {state.isLoaded && state.characters.map((row:any) =>
                        <tr key={row.name}>
                            <th scope={"row"}>{row.name}</th>
                            <td>{row.description}</td>
                            <td>{row.health}</td>
                            <td>{row.height}</td>
                            <td>{row.magic_damage}</td>
                            <td>{row.physical_damage}</td>
                            <td>{row.strength}</td>
                            <td>{row.speed}</td>
                            <td>{row.weight}</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
export default UserInfo;