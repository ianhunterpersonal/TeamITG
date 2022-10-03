import * as React from 'react';

import { Outlet, Link } from 'react-router-dom';

export default function Home() {
  return (
    <div>
      <h1>User Management</h1>
      <nav
        style={{
          borderBottom: 'solid 1px',
          paddingBottom: '1rem',
        }}
      >
        <Link to="/users">New User</Link> | {' '}
      </nav>
      <Outlet />
    </div>
  );
}
