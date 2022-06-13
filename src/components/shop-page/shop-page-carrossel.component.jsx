import { useEffect, useState } from 'react';
import OwlCarousel from 'react-owl-carousel'
// import 'owl.carousel/dist/assets/owl.carousel.css';  
// import 'owl.carousel/dist/assets/owl.theme.default.css';  

import '../../assets/packages/o2system-ui/o2system-ui.css';
import '../../assets/packages/owl-carousel/owl-carousel.css';
import arrowRight from '../../assets/img/arrow-right.png'
import arrowLeft from '../../assets/img/arrow-left.png'

import ShopPageItemCarrossel from './shop-page-item-carrossel.component';


const ShopPageCarrossel = ({title, items, bgColor}) => {

    const [products, setProducts] = useState([])
    const [contentLoaded, setContentLoaded] = useState(false)
    
    useEffect(() => {

        if(!contentLoaded)
        {
            setProducts(items)
            setContentLoaded(true)
        }

        

    }, [])


    return(
    
    <section style={{background: `${bgColor}`}}>
        <div className="container">
            <div className="row">
                <div className="col md-12">

                    {contentLoaded ? 

                        <>
                            <h2 className="title">{title}</h2>
                            <OwlCarousel 
                              className='product-carousel' 
                              items={4} 
                              margin={15} 
                              nav={true} 
                              navElement='div' 
                              dots={false}
                              navText={[`<img src=${arrowLeft} />`, `<img src=${arrowRight} />`]}
                              responsive={{
                                0:{
                                    items:1
                                },
                                600:{
                                    items:2
                                },
                                1000:{
                                    items:4
                                }
                            }}
                            >


                                {
                                    products ? 
                                        products.map(item => ( <ShopPageItemCarrossel item={item} key={item.productId} /> ))
                                        : null
                                    
                                } 
                               
                        
                        

                            </OwlCarousel>
                        </>
                    
                        : null
                    }

                    

                </div>
            </div>
        </div>
    
    </section>);

}

export default ShopPageCarrossel;