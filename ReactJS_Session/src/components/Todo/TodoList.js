import React from 'react' ; 

class TodoList  extends React.Component {
    show = () => {
               
        if(this.props.filter === "completed"){
            return true ; 
        }else if(this.props.filter === "pending"){
            return false ; 
        }
        return null ; 
    };
    
    render(){
        const {todos , title , filter} = this.props; 

        const buttonStyle = {
            marginLeft : "10px",
        }

        return(
            <div>
                <h3>Title: {this.props.title}</h3>
                <ul>
                    {todos ? 
                        todos.map((value , index) =>{
                            if(value.delete === false){
                                if(this.props.filter === "showAll"){
                                    return( 
                                    <li key={index} >
                                        <label>
                                            <input type="checkbox" checked={value.marked} 
                                            onChange = {(event) => this.props.markTaskAsCompleted(event , index)}></input>
                                            {value.todo}
                                        </label>
                                        <button 
                                            style={buttonStyle}
                                            onClick = {(event) => this.props.deleteTodo(event , index)} 
                                        >Delete</button>
                                        <button 
                                            style={buttonStyle}
                                            onClick = {(event) => this.props.duplicateTodo(event , index)} 
                                        >Duplicate</button>
                                    </li> 
                                    );
                                }
                                else {
                                    if(value.marked === this.show() ){
                                        return(<li key={index} >
                                            <label>
                                                <input type="checkbox" checked={value.marked} 
                                                onChange = {(event) => this.props.markTaskAsCompleted(event , index)}></input>
                                                {value.todo}
                                            </label>
                                            <button 
                                                style={buttonStyle}
                                                onClick = {(event) => this.props.deleteTodo(event , index)} 
                                            >Delete</button>
                                            <button 
                                                style={buttonStyle}
                                                onClick = {(event) => this.props.duplicateTodo(event , index)} 
                                            >Duplicate</button>
                                        </li>);
                                    } 
                                    else{
                                        return(null) ; 
                                    }
                                }
                            }
                            else{
                                return(null) ; 
                            } 
                        })
                        : null
                    }
                </ul>
            </div> 
        );
    }
}

export default TodoList ; 