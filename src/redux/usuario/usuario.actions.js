import { UsuarioActionTypes } from "./usuario.types";

export const setCEP = cep => ({
    type: UsuarioActionTypes.SET_CEP,
    payload: cep
})

export const setOfertas = ofertas => ({
    type: UsuarioActionTypes.SET_OFERTAS,
    payload: ofertas
})