import { Link } from "react-router-dom";


const ShopErrorContainer = ({erroTxt}) => (

    <div className="error-container d-flex align-items-center justify-content-center">
        <div className="container">
            <div className="row">
                <div className="col-12 d-flex">
                    <div className="card-error text-center">
                        {erroTxt}
                        <Link className="btn btn-primary btn-block mt-3" to="/">Informar CEP</Link>
                    </div> 
                </div>
            </div>
        </div>
    </div>
)

export default ShopErrorContainer;