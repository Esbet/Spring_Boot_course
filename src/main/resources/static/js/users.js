// Call the dataTables jQuery plugin
$(document).ready(function() {
loadUsers();
  $('#users').DataTable();
  updateEmailUser();
});

function updateEmailUser(){
document.getElementById('txtEmailUser').outerHTML = localStorage.email;
}


async function loadUsers(){
(async () => {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: getHeaders()

  });
  const users = await request.json();

  console.log(users);



  let htmlList = '';


  for (let user of users) {
  let phone = user.phone == null ? '-' : user.phone;
   let deleteButton = '<a href="#" onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle btn-lg"><i class="fas fa-trash"></i></a>';
    let userHTML = '<tr><td>'+user.id+'</td><td>'+user.name+'</td><td>'+user.email+'</td><td>'+phone+'</td><td>'+deleteButton+'</td></tr>'

    htmlList += userHTML;
  }



  document.querySelector('#users tbody').outerHTML =  htmlList;
})();
}

function getHeaders(){
return {
  'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
};
}

async function deleteUser(id){

    if(!confirm('Deseas eliminar este usuario?')){
     return;
    }

 const request = await fetch('api/deleteUser/' +id, {
    method: 'DELETE',
    headers: getHeaders()

  });

  location.reload()

}