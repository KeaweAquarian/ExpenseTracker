import React, { useState } from "react";
import { Navigate } from "react-router";
import { useLocalState } from "../../util/useLocalStorage";

const PrivateRoute = ({ children }) => {
  const [jwt, setJwt] = useLocalState("", "jwt");
  const [validTOken, setValidToken] = useState(null);
  const [loading, setLoading] = useState(true);
  if (jwt) {
    // Fetch Catagories
    const fetchTasks = async () => {
      const res = await fetch("http://localhost:5000/api/categories", {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${jwt}`,
        },
      });
      if (res.status === 200) {
        setValidToken(true);
        setLoading(false);
      } else {
        setValidToken(false);
        setLoading(false);
        setJwt("");
      }
    };

    fetchTasks();

    return loading ? (
      <div>Loading...</div>
    ) : validTOken === true ? (
      children
    ) : (
      <Navigate to="/auth" replace={true} />
    );
  } else return <Navigate to="/auth" replace={true} />;
};

export default PrivateRoute;
