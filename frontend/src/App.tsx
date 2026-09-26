import TodoPage from "./pages/TodoPage"

function App() {

  return (
    <>
      <main className="flex bg-gray-900 min-h-screen flex-col items-center justify-between p-24">
        <div className="z-10 w-full max-w-5xl items-center justify-between font-mono text-sm lg:flex">
          <h1 className="text-4xl font-bold text-white jusify-center mb-6">Todo App</h1>
        </div>
        <div className="w-full max-w-5xl mt-6">
          <TodoPage />
        </div>
        </main>
    </>
  )
}

export default App
