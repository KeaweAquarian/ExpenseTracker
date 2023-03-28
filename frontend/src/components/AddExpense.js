import React, { useState } from "react";
import { Container, Input, Button, Label, FormGroup, Form } from "reactstrap";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

const AddExpense = ({ submitExpense, categories, changeShow }) => {
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState({ id: 1, name: "Travel" });
  const [date, setDate] = useState(new Date());
  const [location, setLocation] = useState("");
  const [amount, setAmount] = useState("");

  const onSubmit = (e) => {
    e.preventDefault();

    if (!description) {
      alert("Please add a description");
      return;
    }

    submitExpense({ description, date, location, amount, category });

    setDescription("");
    setDate(new Date());
    setLocation("");
    setAmount("");
  };

  const findCategoryName = (id) => {
    categories.map((category) => {
      if (category.id === parseInt(id)) {
        setCategory(category);
      }
      return null;
    });
  };

  let optionList = categories.map((category) => (
    <option value={category.id} key={category.id}>
      {category.name}
    </option>
  ));

  const cancelSelected = (e) => {
    e.preventDefault();
    changeShow();
  };

  return (
    <div>
      <Container>
        <h1>Add Expense</h1>

        <Form onSubmit={onSubmit}>
          <FormGroup>
            <Label for="description">Title</Label>
            <Input
              type="text"
              name="description"
              id="description"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
          </FormGroup>

          <FormGroup>
            <Label for="category">Category</Label>
            <select
              onChange={(e) => {
                findCategoryName(e.target.value);
              }}
            >
              {optionList}
            </select>
          </FormGroup>

          <FormGroup>
            <Label for="expensedate">Date</Label>
            <DatePicker
              value={date}
              selected={date}
              onChange={(e) => setDate(e)}
            />
          </FormGroup>

          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="location">Location</Label>
              <Input
                type="text"
                value={location}
                name="location"
                id="location"
                onChange={(e) => setLocation(e.target.value)}
              />
            </FormGroup>
          </div>
          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="amount">Amount</Label>
              <Input
                type="number"
                value={amount}
                name="amount"
                id="amount"
                onChange={(e) => setAmount(e.target.value)}
              />
            </FormGroup>
          </div>
          <FormGroup>
            <Button color="primary" type="submit">
              Save
            </Button>{" "}
            <Button color="secondary" onClick={cancelSelected}>
              Close
            </Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  );
};

export default AddExpense;
