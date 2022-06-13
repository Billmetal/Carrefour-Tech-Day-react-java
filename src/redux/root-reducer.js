import { combineReducers } from "redux";
import usuarioReducer from "./usuario/usuario.reducer";

const rootReducer = combineReducers({
    usuario: usuarioReducer
});


export default rootReducer;