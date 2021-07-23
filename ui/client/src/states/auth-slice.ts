import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {RootState} from "../store/store";

interface State {
    username: string,
    token: string,
    isLoggedIn: boolean,
    isLoaded: boolean,
    characters: []
}

const initialState: State = {
    username: '',
    token: '',
    isLoggedIn: false,
    isLoaded: false,
    characters: []
}

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        login: (state, action: PayloadAction<any>) => {
            state.username = action.payload.username;
            state.token = action.payload.token;
            state.isLoggedIn = true;
        },
        finishedLoading: (state, action: PayloadAction<any>) => {
            state.isLoaded = true;
            state.characters = action.payload;
        },
    },
})

export const {login, finishedLoading} = authSlice.actions;
export const authState = (state: RootState) => state.auth;

export default authSlice.reducer;