import { Router, Route, type RouteSectionProps } from "@solidjs/router"
import { CreateProduct } from "../features/product/create-product";
import { ProductList } from "../features/product/product-list";
import { LoginPage } from "../pages/Login";
import { SignUpPage } from "../pages/SingUp";

const Layout = (props: RouteSectionProps) => {
  return (
    <>
      <header>header</header>
        {props.children}
      <footer>footer</footer>
    </>
  )
}

const App = () => {
  return (
    <Router>
        <Route path="/login" component={LoginPage} />
        <Route path="/signup" component={SignUpPage} />
        <Route path="/" component={Layout} >
            <Route path="/" component={() => <h1>main</h1>} />
            <Route path="/add-product" component={CreateProduct} />
            <Route path="/list-product" component={ProductList} />
        </Route>
    </Router>
  )
}

export default App;
