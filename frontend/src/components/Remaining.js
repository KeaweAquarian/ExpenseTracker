import React, { useState, useContext, useEffect } from "react";
import { ApiContext } from "./context/ApiContext";

const Remaining = ({ budget }) => {
  const [expensesList] = useContext(ApiContext);
  const [expenseTotal, setExpenseTotal] = useState(0);

  useEffect(() => {
    const calculateTotalExpenses = () => {
      let total = 0;
      expensesList.forEach((expense) => {
        total = total + expense.amount;
      });
      setExpenseTotal(total);
    };
    calculateTotalExpenses();
  }, [expensesList]);

  let remaining = Math.round((budget - expenseTotal) * 100) / 100;

  const balanceAlert = remaining > 0 ? "alert-success" : "alert-danger";
  return (
    <div className={`alert ${balanceAlert} p-3`} style={{ height: "60px" }}>
      <div>Remaining: $ {remaining} </div>
    </div>
  );
};

export default Remaining;
