import * as ActionTypes from './actionTypes';

export const Guest = (state = {
        id: null,
        
    }, action) => {
    switch (action.type) {
        case ActionTypes.ADD_USER:
            return { ...state, id: action.payload.id, username: action.payload.username, authorities: action.payload.authorities }
        
        case ActionTypes.DELETE_USER:
            return { ...state, id: null, username: '', authorities: [] }

        default:
            return state;
    }
}