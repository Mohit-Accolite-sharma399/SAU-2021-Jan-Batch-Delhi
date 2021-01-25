import React from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

class Todo extends React.Component {
    state = {
        todo: "",
        todos: [{ todo: "FirstTodo", marked: true, delete: false },
            { todo: "SecondTodo", marked: false, delete: false }
        ],
        title: "My Tasks",
        filter: "showAll",
    };

    handleOnChange = (event) => {
        console.log(event.target.value);
        this.setState({ todo: event.target.value });
    };

    addTask = () => {
        const { todo, todos } = this.state;

        const newTodos = [...todos];
        if (todo !== "") {
            newTodos.push({ todo: todo, marked: false, delete: false });
            this.setState({ todos: newTodos, todo: "" });
        }

    };

    markTaskAsCompleted = (event, index) => {
        const { todos } = this.state;
        const newTodos = [...todos];

        newTodos[index] = {
            ...newTodos[index],
            marked: event.target.checked,
            delete: false
        };

        this.setState({ todos: newTodos });
    };

    deleteTodo = (event, index) => {
        const { todos } = this.state;
        const newTodos = [...todos];

        newTodos[index] = {
            ...newTodos[index],
            marked: todos[index].marked,
            delete: true
        };

        this.setState({ todos: newTodos });
    };

    duplicateTodo = (event, index) => {
        const { todos } = this.state;
        const newTodos = [...todos];

        newTodos.push({
            todo: todos[index].todo,
            marked: false,
            delete: false
        });

        this.setState({ todos: newTodos });
    }

    addFilter = (event, str) => {
        const { filter } = this.state;
        const filterValue = str;

        this.setState({ filter: filterValue });

    };


    render() {
        return ( < div className = "TodoContainer" >
            <
            h1 > Task Management Application < /h1> <
            TodoInput placeholder = "Add new task"
            value = { this.state.todo }
            onChange = { this.handleOnChange }
            /> <
            button onClick = { this.addTask } > Add task < /button> <
            button onClick = {
                (event) => this.addFilter(event, "showAll")
            } > Show All Task < /button> <
            button onClick = {
                (event) => this.addFilter(event, "completed")
            } > Completed Task < /button> <
            button onClick = {
                (event) => this.addFilter(event, "pending")
            } > Pending Task < /button> <
            TodoList title = { this.state.title }
            filter = { this.state.filter }
            todos = { this.state.todos }
            markTaskAsCompleted = { this.markTaskAsCompleted }
            duplicateTodo = { this.duplicateTodo }
            deleteTodo = { this.deleteTodo }
            />  < /
            div >
        );

    }
}

export default Todo;