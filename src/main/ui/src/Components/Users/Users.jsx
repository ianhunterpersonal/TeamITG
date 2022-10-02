import { Outlet, Link } from 'react-router-dom';
import { getUsers } from '../../data';

export default function Users() {
  return (
    <div style={{ display: 'flex' }}>
      <nav
        style={{
          borderRight: 'solid 1px',
          padding: '1rem',
        }}
      >
        {getUsers().map((user) => (
          <Link
            style={{ display: 'block', margin: '1rem 0' }}
            to={`/users/${user.userId}`}
            key={user.userId}
          >
            {user.email}
          </Link>
        ))}
      </nav>
      <Outlet />
    </div>
  );
}
