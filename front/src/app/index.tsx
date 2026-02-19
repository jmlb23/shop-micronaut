import { Router, Route } from "@solidjs/router"
import { type ParentProps } from "solid-js"
import { CreateProduct } from "../features/product/create-product";
import { ProductList } from "../features/product/product-list";

const Layout = (props: ParentProps) => {
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
    <Router root={Layout}>
        <Route path="/" component={() => <h1>main</h1>} />
        <Route path="/add-product" component={CreateProduct} />
        <Route path="/list-product" component={ProductList} />
    </Router>
  )
}

export default App;
