import bgImage from '../../assets/img/bg-novo.jpg'

const ShopPageHeader = ({title, subtitle, ...rest}) => (
    <div className='page-content'>
        <div className='banner'>
            <div className='jumbotron jumbotron-bg jumbotron-shop text-center rounded-0' style={{background: `url(${bgImage}) center/ cover`, backgroundRepeat: 'no-repeat' }} >

                <div className="container">
                    <h1 className="pt-5 home-main-title">{title}</h1>
                    <p className="lead home-main-subtitle">{subtitle}</p>
                  </div>
                
            </div>
        </div>
    </div>
)

export default ShopPageHeader;