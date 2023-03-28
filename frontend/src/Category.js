import React, { useEffect } from "react";
import AppNav from "./AppNav";
import { useState } from "react";
import EditCategory from "./components/EditCategory";
import ListGroup from "react-bootstrap/ListGroup";
import DeleteButton from "./components/DeleteButton";
import { useLocalState } from "./util/useLocalStorage";
import { Container } from "reactstrap";
import AppNavHor from "./components/AppNavHor";

const Category = () => {
  const [windowDim, setWindowDim] = useState({
    winWidth: window.innerWidth,
    winHeight: window.innerHeight,
  });
  const [isLoading, setIsLoading] = useState(true);
  const [Categories, setCatagories] = useState([]);
  const [jwt] = useLocalState("", "jwt");

  // const handleSaveClick = (category) => {
  //     addCatagory(category)

  // };
  //handle window resize
  const detectSize = () => {
    setWindowDim({
      winWidth: window.innerWidth,
      winHeight: window.innerHeight,
    });
  };
  useEffect(() => {
    window.addEventListener("resize", detectSize);
    return () => {
      window.removeEventListener("resize", detectSize);
    };
  }, [windowDim]);

  useEffect(() => {
    const getCategories = async () => {
      const categoriesFromServer = await fetchTasks();
      setCatagories(categoriesFromServer);
    };

    getCategories();
    //eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  // Fetch Catagories
  const fetchTasks = async () => {
    const response = await fetch("http://localhost:5000/api/categories", {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
    });
    const body = await response.json();
    setIsLoading(false);

    return body;
  };

  // Add Catagory
  const addCatagory = async (category) => {
    const res = await fetch("http://localhost:5000/api/categories", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
      body: JSON.stringify(category),
    });
    console.log(res);
    {
      const getCategories = async () => {
        const categoriesFromServer = await fetchTasks();
        setCatagories(categoriesFromServer);
      };

      getCategories();
    }
  };

  // Delete Catagory
  const deleteCatagory = async (id) => {
    const res = await fetch(`http://localhost:5000/api/categories/${id}`, {
      method: "DELETE",
      headers: {
        "Content-type": "application/json",
        Authorization: `Bearer ${jwt}`,
      },
      body: JSON.stringify(id),
    });
    if (res.status !== 200) {
      alert("Categories with active expenses cannot be deleted!");
    }

    {
      const getCategories = async () => {
        const categoriesFromServer = await fetchTasks();
        setCatagories(categoriesFromServer);
      };

      getCategories();
    }
  };

  if (isLoading) return <div>Loading...</div>;

  return (
    <div
      className="d-flex"
      style={{ backgroundColor: "#EEF5F7", height: "100vh" }}
    >
      {windowDim.winWidth > 600 && <AppNav />}

      <Container
        style={{
          backgroundColor: "white",
          boxShadow: "rgba(0, 0, 0, 0.16) 0px 1px 4px",
          marginRight: "20px",
        }}
      >
        {windowDim.winWidth < 600 && <AppNavHor />}
        <div style={{ marginLeft: "30px" }}>
          <h2>Categories</h2>

          <div
            className="alert alert-secondary p-2 d-flex align-items-center justify-content-between"
            style={{ width: "200px" }}
          >
            <EditCategory onAdd={addCatagory} />
          </div>
          {Categories.length > 0 ? (
            <ListGroup as="ol" style={{ width: "400px" }}>
              {Categories.map((category) => (
                <ListGroup.Item as="li" key={category.id}>
                  {category.name}
                  <DeleteButton
                    deletecatagory={deleteCatagory}
                    id={category.id}
                  />
                </ListGroup.Item>
              ))}
            </ListGroup>
          ) : (
            "No categories defined."
          )}
        </div>
      </Container>
    </div>
  );
};

export default Category;
