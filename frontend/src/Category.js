import React, { Component } from 'react';
import AppNav from './appNav';

class Category extends Component {

    state = {  
        isLoading : true,
        Categories : []
    }
 
    async componentDidMount(){
        const response=await fetch('http://projectbudgettracker-env-1.eba-w5cwheeg.us-east-1.elasticbeanstalk.com/api/categories');
        const body = await response.json();
        this.setState({Categories : body , isLoading: false});
    }

    render() { 
        const {Categories , isLoading} = this.state;
        if(isLoading) 
            return (
            <div>
                <AppNav />
                Loading...
                </div>);
        
        return ( 
            
                <div>
                   <AppNav />
                    <h2>Categories</h2>
                    {
                        Categories.map( category => 
                            <div id={category.id}>
                                {category.name}
                            </div>
                        )

                    }

                </div>
         );
    }
}
 
export default Category;