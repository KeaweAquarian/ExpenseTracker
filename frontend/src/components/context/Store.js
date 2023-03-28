import React, { useState, useEffect } from "react";
import { ApiContext } from "./ApiContext";
import { useLocalState } from "../../util/useLocalStorage";

function Store({ children }) {
  //   const [isLoading, setIsLoading] = useState(false);
  const [expensesList, setExpensesList] = useState([]);
  const [jwt] = useLocalState("", "jwt");

  useEffect(() => {
    const getExpenses = async () => {
      const expensesFromServer = await fetchExpenses();
      setExpensesList(expensesFromServer);
    };

    // Fetch Expenses
    const fetchExpenses = async () => {
      const response = await fetch("http://localhost:5000/api/expenses", {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${jwt}`,
        },
      });
      const body = await response.json();

      // setIsLoading(false);
      return body;
    };

    getExpenses();
  }, [jwt]);

  return (
    <ApiContext.Provider value={[expensesList, setExpensesList]}>
      {children}
    </ApiContext.Provider>
  );
}
export default Store;
