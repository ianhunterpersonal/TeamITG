import { useEffect, useState } from 'react';

import { Outlet, Link } from 'react-router-dom';

export default function Users() {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    const requestOptions = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' },
    };
    fetch('http://localhost:9080/v1/users', requestOptions)
      .then(response => response.json())
      .then(data => setUsers(data));
  }, []);// empty array means effect only runs once

  function deleteUser(userId) {
    fetch('http://localhost:9080/v1/users/' + userId, {method: 'DELETE'}).then(() =>  {
      let filteredUsers = users.filter(item => item.id !== userId)
      setUsers(filteredUsers)
    });
    setUsers(...users, users.filter(u => u.id !== userId));
  }

  return (
    <div style={{ display: 'flex' }}>
      <nav
        style={{
          borderRight: 'solid 1px',
          padding: '1rem',
        }}
      >
        {users && Array.isArray(users) && users.map((user) => (
          <div key={user.id}>
            <Link
              to={"/users/" + user.id}
              state={{
                user: user
              }}
            >
              {user.email}
            </Link>
            {' | '}
            <button onClick={() => deleteUser(user.id)}>DEL</button>
            <br/>
          </div>
        ))}
      </nav>
      <Outlet />
    </div>
  );
}
