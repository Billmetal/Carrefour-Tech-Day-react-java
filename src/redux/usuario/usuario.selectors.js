import { createSelector } from "reselect";

const selectUsuario = state => state.usuario;

export const selectUsuarioCep = createSelector(
    [selectUsuario],
    usuario => usuario.cep
)

export const selectUsuarioOfertas = createSelector(
    [selectUsuario],
    usuario => usuario.ofertas
)