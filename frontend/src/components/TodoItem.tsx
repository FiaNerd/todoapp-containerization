import type { Todo } from "../interfaces/todo";

interface TodoItemProps {
    todo: Todo;
    onToggle: (id: number, completed: boolean) => void;
    onDelete: (id: number) => void;
}

export default function TodoItem({ todo, onToggle, onDelete }: TodoItemProps) {
  console.log("Här är todo-objektet:", todo);
    if (!todo.id) {
      return null;
    }

    return (
        <div className="bg-white text-black  p-4 rounded-xl shadow-sm border border-gray-100 flex justify-between items-center mb-3">
            <span 
                onClick={() => onToggle(todo.id, todo.completed)}
                className={`cursor-pointer font-medium ${todo.completed ? "line-through text-lime-800" : "text-pink-600"}`}
            >
                {todo.title}
            </span>
            <button 
                onClick={() => onDelete(todo.id)}
                className="text-sm bg-red-50 text-red-600 px-3 py-1 rounded-lg hover:bg-red-100 cursor-pointer"
            >
                Ta bort
            </button>
        </div>
    );
}