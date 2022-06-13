import HomePage from "./components/home/home-page-component";
import ShopPage from "./components/shop-page/shop-page.component";

const myRoutes = [
    {
        path: '/',
        element: <HomePage/>
    },
    {
        path: '/ofertas',
        element: <ShopPage/>
    }
]

export default myRoutes;