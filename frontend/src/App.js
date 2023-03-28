import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Store from "./components/context/Store";
import Category from "./Category";
import Expenses from "./Expenses";
import About from "./About";
import Auth from "./components/login/Auth";
import PrivateRoute from "./components/privateRoute/PrivateRoute";
import Dashboard from "./components/Dashboard";

function App() {
  // const [active, setActive] = useState("1");

  // const toggleLink = (link) => {
  //   setActive(link);
  //   console.log(link);
  // };

  return (
    <>
      <Store>
        <Router>
          <Routes>
            <Route path="/auth" element={<Auth />} />
            <Route
              path="/"
              exact={true}
              element={
                <PrivateRoute>
                  <Dashboard />
                </PrivateRoute>
              }
            />
            <Route
              path="/expenses"
              exact={true}
              element={
                <PrivateRoute>
                  <Expenses />
                </PrivateRoute>
              }
            />
            <Route
              path="/categories"
              exact={true}
              element={
                <PrivateRoute>
                  <Category />
                </PrivateRoute>
              }
            />
            <Route
              path="/about"
              exact={true}
              element={
                <PrivateRoute>
                  <About />
                </PrivateRoute>
              }
            />
          </Routes>
        </Router>
      </Store>
    </>
  );
}

export default App;
