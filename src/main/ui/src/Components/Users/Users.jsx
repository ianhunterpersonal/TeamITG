import { useEffect, useState } from 'react';

import { Outlet, Link } from 'react-router-dom';

import Button from '@mui/material/Button';

import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

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
    fetch('http://localhost:9080/v1/users/' + userId, { method: 'DELETE' }).then(() => {
      let filteredUsers = users.filter(item => item.id !== userId)
      setUsers(filteredUsers)
    });
    setUsers(...users, users.filter(u => u.id !== userId));
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="left">ID</TableCell>
            <TableCell align="left">Name</TableCell>
            <TableCell align="left">Email</TableCell>
            <TableCell align="left">&nbsp;</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {users && Array.isArray(users) && users.map((user) => (
            <TableRow
              key={user.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >

              <TableCell component="th" scope="row">{user.id}</TableCell>

              <TableCell>
                <Link to={"/users/" + user.id} state={{ user: user }}>{user.name}</Link>
              </TableCell>

              <TableCell>{user.email}</TableCell>

              <TableCell><Button variant="contained" onClick={() => deleteUser(user.id)}>DEL</Button></TableCell>

            </TableRow>

          ))}
        </TableBody>
      </Table>
      <Outlet />
    </TableContainer>
  )
}
