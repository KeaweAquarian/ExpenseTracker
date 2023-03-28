import { Nav, NavItem, NavLink, Navbar } from "reactstrap";
import { Button } from "reactstrap";
import { useLocalState } from "../util/useLocalStorage";

const AppNavHor = () => {
  const [, setJwt] = useLocalState("", "jwt");
  const logOut = () => {
    setJwt("");

    window.location = "http://localhost:3000/auth";
  };
  return (
    <>
      <Navbar
        className="my-2"
        color="dark"
        dark
        style={{ borderRadius: "4px" }}
      >
        <Nav className="ml-auto" navbar pills></Nav>
        <NavItem>
          <NavLink
            href="/"
            style={
              window.location.href === "http://localhost:3000/"
                ? {
                    borderRadius: "8px",
                    color: "white",
                  }
                : { color: "#0249cc" }
            }
          >
            Dashboard
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="/expenses"
            style={
              window.location.href === "http://localhost:3000/expenses"
                ? {
                    borderRadius: "8px",
                    color: "white",
                  }
                : { color: "#0249cc" }
            }
          >
            Expences
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="/categories"
            style={
              window.location.href === "http://localhost:3000/categories"
                ? {
                    borderRadius: "8px",
                    color: "white",
                  }
                : { color: "#0249cc" }
            }
          >
            Categories
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="/about"
            style={
              window.location.href === "http://localhost:3000/about"
                ? {
                    borderRadius: "8px",
                    color: "white",
                  }
                : { color: "#0249cc" }
            }
          >
            About
          </NavLink>
        </NavItem>
        <Button size="sm" color="secondary" outline onClick={logOut}>
          Log Out
        </Button>
      </Navbar>
    </>
  );
};

export default AppNavHor;
