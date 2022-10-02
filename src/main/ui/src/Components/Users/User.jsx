import { useNavigate, useLocation } from 'react-router-dom';

export default function User(props) {

  let navigate = useNavigate();
  let location = useLocation();

  const user = location?.state?.user;

  console.log(user);

  return (
    (user ?
      <main style={{ padding: '1rem' }}>
        <p>
          {user?.name}: {user?.id}
        </p>
        <p>Email: {user?.email}</p>
        <p>
          <button
            onClick={() => {
              navigate('/users');
            }}
          >
            Back
          </button>
        </p>
      </main>
      :
      <div>No user passed in</div>
    )
  );
}
