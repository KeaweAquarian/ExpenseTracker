import React, { useState, useEffect, useContext } from "react";
import { ApiContext } from "./context/ApiContext";
import Moment from "react-moment";
import { Table, Container, Button } from "reactstrap";

const Expense = ({ remove, chartOption, number }) => {
  const [expensesList] = useContext(ApiContext);

  const [windowDim, setWindowDim] = useState({
    winWidth: window.innerWidth,
    winHeight: window.innerHeight,
  });

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

  var list = expensesList;
  if (chartOption !== "all") {
    var newExpenseList = expensesList.filter(
      (e) => e.category.name === chartOption
    );
    list = newExpenseList;
  }

  let rows = list.map((expense) => (
    <tr key={expense.id}>
      <td>{expense.description}</td>
      {windowDim.winWidth > 700 && <td>{expense.location}</td>}
      {windowDim.winWidth > 700 && (
        <td>
          <Moment date={expense.expensedate} format="YYYY/MM/DD" />
        </td>
      )}

      <td>{expense.category.name}</td>
      <td>{expense.amount}</td>
      <td>
        <Button size="sm" color="danger" onClick={() => remove(expense.id)}>
          Delete
        </Button>
      </td>
    </tr>
  ));

  return (
    <Container>
      <h3>Expenses</h3>
      <Table className="mt-4">
        <thead>
          <tr>
            <th width="30%">Description</th>
            {windowDim.winWidth > 700 && <th width="10%">Location</th>}
            {windowDim.winWidth > 700 && <th> Date</th>}

            <th> Category</th>
            <th>Amount</th>
            <th width="10%">Action</th>
          </tr>
        </thead>
        <tbody>{rows}</tbody>
      </Table>
    </Container>
  );
};

export default Expense;
