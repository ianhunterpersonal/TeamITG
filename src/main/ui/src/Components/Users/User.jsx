import { useParams, useNavigate, useLocation } from 'react-router-dom';

import { getUser, deleteUser } from '../../data';

export default function User() {
  let navigate = useNavigate();
  let location = useLocation();
  let params = useParams();
  let user = getUser(parseInt(params.userId, 10));

  return (
    <main style={{ padding: '1rem' }}>
      <p>
        {user.name}: {user.userId}
      </p>
      <p>Email: {user.email}</p>
      <p>
        <button
          onClick={() => {
            deleteUser(user.userId);
            navigate('/users' + location.search);
          }}
        >
          Delete
        </button>
      </p>
    </main>
  );
}
