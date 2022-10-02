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
        <Route path="users" element={<Users />}/>
        <Route path="users/:userId" element={<User />} />
        <Route path="*" element={<main style={{ padding: '1rem' }}><p>There are no users in the system.</p></main>}/>
      </Route>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
