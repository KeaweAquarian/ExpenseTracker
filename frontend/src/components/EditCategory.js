import React, { useState } from 'react';

const EditCategory = (props) => {
	const [name, setName] = useState("");


const onClick = (e) => {
    e.preventDefault()

    if (name === "") {
      alert('Please add a category')
      return
    }else{


	
    }

    props.onAdd({name})

    setName("")

  }

	return (
		<>
			<input
			
				required='required'
				type='text'
				className='form-control mr-3'
				id='name'
				value={name}
				// value={value}
				onChange={(event) => setName(event.target.value)}
				
			/>
			<button
				type='button'
				className='btn btn-primary'
				onClick={onClick}
			>
				Save
			</button>
		</>
	);
};

export default EditCategory;