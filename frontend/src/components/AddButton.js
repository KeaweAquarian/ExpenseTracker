import React from 'react'
import { Button } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const AddButton = ({changeShow}) => {



  return (
    <div className='container'>
     
      <Button color="success" type="button" className='btn' onClick={changeShow}>
        Add Expense
      </Button>
     
    </div>
  )
}



export default AddButton
