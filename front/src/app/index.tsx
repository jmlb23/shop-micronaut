import { Router, Route } from "@solidjs/router"
import { CreateProduct } from "../features/product/create-product";
import { ProductList } from "../features/product/product-list";

const App = () => {
  return (
    <Router>
        <Route path="/" component={() => <h1>main</h1>} />
        <Route path="/add-product" component={CreateProduct} />
        <Route path="/list-product" component={ProductList} />
    </Router>
  )
}

export default App;
