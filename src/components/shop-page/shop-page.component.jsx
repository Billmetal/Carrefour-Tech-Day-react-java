import { useState, useEffect } from "react";
import { connect } from "react-redux";
import { createStructuredSelector } from "reselect";
import { selectUsuarioCep, selectUsuarioOfertas } from "../../redux/usuario/usuario.selectors";
import ShopErrorContainer from "./shop-error-container.component";
import ShopPageCarrossel from "./shop-page-carrossel.component";
import ShopPageHeader from "./shop-page-header.component";

const ShopPage = (props) => {

    const [erro, setErro] = useState(false)
    const [erroMsg, setErroMsg] = useState("")
    const [mercearia, setMercearia] = useState(
            props.ofertas ? props.ofertas.filter(item => item.category === 'Mercearia') : null
    )
    const [hortifruti, setHortifruti] = useState(
        props.ofertas ? props.ofertas.filter(item => item.category === 'Hortifruti') : null
        )

    useEffect(() => {

        if(props.cep === '' || props.ofertas === null)
        {
            setErro(true)
            setErroMsg("Por favor informe seu CEP")
            return
        }
        
        return () => {
            setHortifruti(null);
            setMercearia(null);
        }


    }, [])

    return(
    
        erro ? 
                <ShopErrorContainer erroTxt={erroMsg} />

            : 

                <>
                    <ShopPageHeader title="OFERTAS" subtitle="Aproveite nossas ofertas" />
                    <ShopPageCarrossel title="Mercearia" items={mercearia} bgColor="#ffffff"  />
                    <ShopPageCarrossel title="Hortifruti" items={hortifruti} bgColor="#f8f8f8" />
                </>
        
    )

}

const mapStateToProps = createStructuredSelector({
    cep: selectUsuarioCep,
    ofertas: selectUsuarioOfertas
})


export default connect(mapStateToProps, null)(ShopPage);