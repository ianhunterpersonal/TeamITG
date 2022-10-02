import './App.css';

import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from './Components/Home/Home';
import Users from './Components/Users/Users';
import User from './Components/Users/User';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />}>
        <Route path="users" element={<Users />}>
          <Route index element={<main style={{ padding: '1rem' }}><p>Select a User</p></main>}/>
          <Route path=":userId" element={<User />} />
        </Route>
        <Route path="*"element={<main style={{ padding: '1rem' }}><p>There's nothing here!</p></main>}/>
      </Route>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
