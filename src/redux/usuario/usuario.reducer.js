import { UsuarioActionTypes } from "./usuario.types";

const INITIAL_STATE = {
    cep: '',
    ofertas: null
}

const usuarioReducer = (state = INITIAL_STATE, action) => {

    switch(action.type){

        case UsuarioActionTypes.SET_CEP:
            return{
                ...state,
                cep: action.payload
            }

        case UsuarioActionTypes.SET_OFERTAS:
            return{
                ...state,
                ofertas: action.payload
            }

        default:
            return state

    }

}

export default usuarioReducer;