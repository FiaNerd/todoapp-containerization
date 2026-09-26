import { useEffect, useState } from 'react';
import type { Todo } from '../interfaces/todo';
import TodoItem from '../components/TodoItem';

export default function TodosPage() {
    const [todos, setTodos] = useState<Todo[]>([]);
    const [newTitle, setNewTitle] = useState('');

    const API_URL = 'http://localhost:8080/api/todos';

    useEffect(() => {
        fetch(API_URL)
            .then(res => res.json())
            .then(data => setTodos(data))
            .catch(err => console.error("Kunde inte hämta:", err));
    }, []);


    const addTodo = (e: React.SyntheticEvent<HTMLFormElement>) => {
        e.preventDefault();
        if (!newTitle.trim()) return;

        fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ title: newTitle, completed: false }) 
        })
            .then(res => res.json())
            .then(newTodo => {
                setTodos([...todos, newTodo]);
                setNewTitle('');
            })
            .catch(err => console.error("Kunde inte lägga till:", err));
    };

   const toggleTodo = (id: number, currentStatus: boolean) => {
    fetch(`${API_URL}/${id}`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ completed: !currentStatus })
    })
    .then(res => res.json())
    .then(updated => {
        setTodos(todos.map(t => {
            if (t.id === id) {
                return {
                    ...updated,
                    title: updated.title ? updated.title : t.title
                };
            }
            return t;
        }));
    });
};

    const deleteTodo = (id: number) => {
        fetch(`${API_URL}/${id}`, { method: 'DELETE' })
            .then(() => {
                setTodos(todos.filter(t => t.id !== id));
            })
            .catch(err => console.error("Kunde inte radera:", err));
    };

    return (
        <div className="max-w-md mx-auto p-6 bg-white rounded-2xl shadow-md">
            
            <h1 className="text-2xl font-bold mb-4 text-gray-800">Ta tag i</h1>

            <form onSubmit={addTodo} className="flex gap-2 mb-6">
                <input
                    type="text"
                    value={newTitle}
                    onChange={e => setNewTitle(e.target.value)}
                    placeholder="Skriv en ny todo..."
                    className="flex-1 px-4 py-2 border rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-400 bg-white text-gray-800"
                />
                <button type="submit" className="bg-yellow-400 text-black px-4 py-2 rounded-xl hover:bg-yellow-700 hover:text-white cursor-pointer">
                    Lägg till
                </button>
            </form>

            <div>
                {todos.map(todo => (
                    <TodoItem 
                        key={todo.id} 
                        todo={todo} 
                        onToggle={toggleTodo} 
                        onDelete={deleteTodo} 
                    />
                ))}
            </div>
        </div>
    );
} 