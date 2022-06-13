import bgImage from '../../assets/img/bg-novo.jpg'


const HomeBg = (props) => {

    return (

        <div className='page-content'>
            <div className='banner'>
                <div className='jumbotron jumbotron-bg jumbotron-home text-center rounded-0 d-flex align-items-center' style={{background: `url(${bgImage}) center/ cover`, backgroundRepeat: 'no-repeat' }} >
                    {props.children}
                </div>
            </div>
        </div>
    )

}

export default HomeBg;