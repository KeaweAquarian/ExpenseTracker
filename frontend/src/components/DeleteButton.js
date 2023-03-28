import React from 'react'
import { Button } from 'reactstrap';


const DeleteButton = (props) => {
    const onDelete= (id)=>{
props.deletecatagory(id);
}
  return (
    <>
     
      <Button outline color="danger" type="button" className='btn'  onClick={()=>onDelete(props.id)} size="sm"  style={{float:"right"}}>
        Delete
      </Button>
    </>
  )
}

export default DeleteButton
