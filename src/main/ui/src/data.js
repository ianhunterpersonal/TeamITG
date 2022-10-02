let users = [
  {
    userId: 1,
    name: 'root',
    email: 'root@mail.com',
  },
  {
    userId: 2,
    name: 'ian',
    email: 'ian@mail.com',
  },
];
  
  export function getUsers() {
    return users;
  }
  
  export function deleteUser(userId) {
    users = users.filter((invoice) => invoice.userId !== userId);
  }
  
  export function getUser(userId) {
    return users.find((invoice) => invoice.userId === userId);
  }
  