import React, {useState} from "react";
import { connect } from "react-redux";
import { useNavigate } from "react-router-dom";
import HomeBg from "./home-bg.component";
import { setCEP, setOfertas } from "../../redux/usuario/usuario.actions";
import { Alert, Spinner } from "react-bootstrap";
import { fetchProdutos } from "../../services/main.services";

const HomePage = (props) => {

    const FORM_INICIAL = {
        cep: ''
    } 

    const [dataForm, setDataForm] = useState(FORM_INICIAL)
    const [showError, setShowError] = useState(false)
    const [msgError, setMsgError] = useState("")
    const [mainLoader, setMainLoader] = useState(false)


    let navigate = useNavigate()

    const handleOnChange = event => {
        const {name, value} = event.target;
        setDataForm({...dataForm, [name]: value});
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        if(dataForm.cep === '')
        {
            setShowError(true)
            setMsgError("Por favor digite o seu CEP.")
            return false
        }

        setMainLoader(true)
        setShowError(false)
        setMsgError("")

        props.dispatchCep(dataForm.cep)

        var dataPost = JSON.stringify({cep: dataForm.cep})

        await fetchProdutos(dataPost)
        .then(data => {

          if(data.products)
          {
            console.log(data)
            props.dispatchOfertas(data.products)
            navigate('/ofertas')
          }
          else
          {
            setMainLoader(false)
            setShowError(true)
            setMsgError("Ocorreu um erro, por favor tente novamente.")
            return false
          }


        })
        .catch(error => {
          setMainLoader(false)
          setShowError(true)
          setMsgError("Ocorreu um erro, por favor tente novamente.")
          return false
        })
    }

    return(
      <>

        {mainLoader ? 
          <div className="main-loader d-flex align-items-center justify-content-center">
            <Spinner animation="border" variant="primary" />
          </div>
          : null
        }
        



        <HomeBg>
          <div className="container">
              <h1 className="pt-5 home-main-title">Receba em casa</h1>
              <p className="lead home-main-subtitle">Digite seu CEP para visualizar ofertas para sua região.</p>
              <div className="card card-login mb-5">
                <div className="card-body">
                  <form className="form-horizontal" onSubmit={handleSubmit}>

                    <Alert show={showError} variant="danger" onClose={() => setShowError(false)} dismissible>
                      
                      <p>
                        {msgError}
                      </p>
                    </Alert>
                    
                    
                    <div className="form-group row mt-3 mb-3">
                      <div className="col-md-12">
                        <input
                          className="form-control text-center home-form-el"
                          type="text"
                          required=""
                          name="cep"
                          placeholder="SEU CEP"
                          onChange={handleOnChange}
                        />
                      </div>
                    </div>

                    <div className="form-group row text-center mt-4">
                      <div className="col-md-12">
                        <button
                          type="submit"
                          className="btn btn-primary btn-block text-uppercase home-form-el"
                        >
                          BUSCAR
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
          </div>
        </HomeBg>
      </>
        
    )

}


const mapDispatchToProps = dispatch => ({
    dispatchCep: cep => dispatch(setCEP(cep)),
    dispatchOfertas: ofertas => dispatch(setOfertas(ofertas))
})

export default connect(null, mapDispatchToProps)(HomePage);