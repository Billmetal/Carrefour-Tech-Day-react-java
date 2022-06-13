
const ShopPageItemCarrossel = (props) => {

    const {item} = props

    return(
        <div className="item">
        <div className="card card-product">
          <div className="card-ribbon">
            <div className="card-ribbon-container right">
              <span className="ribbon ribbon-primary">OFERTA</span>
            </div>
          </div>
          <div className="card-badge">
            <div className="card-badge-container left">
              <span className="badge badge-default" style={{display: 'none'}}>Until 2018</span>
              <span className="badge badge-primary">20% OFF</span>
            </div>
            <img
              src={item.imageUrl}
              alt="Card image 2"
              className="card-img-top"
            />
          </div>
          <div className="card-body">
            <h4 className="card-title">
              <a href={item.link} target='_blank'>{item.productName}</a>
            </h4>
            <div className="card-price">
              <span className="discount" style={{display: 'none'}}>R$ 30,99</span>
              <span className="promo-preco">{item.price}</span>
            </div>
            <a href={item.addToCartLink} target='_blank' className="btn btn-block btn-primary btn-produto mb-2">
              Adicionar no Carrinho
            </a>

            <a href={item.link} target='_blank' className="btn btn-block btn-default btn-produto">
              Mais Detalhes
            </a>
          </div>
        </div>
      </div>
    );

}

export default ShopPageItemCarrossel;