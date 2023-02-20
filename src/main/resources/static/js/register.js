// Call the dataTables jQuery plugin
$(document).ready(function() {
loadUsers();

});


async function registerUsers(){


let dataUser = {}
dataUser.name = document.getElementById('txtName').value;
dataUser.lastname = document.getElementById('txtLastName').value;
dataUser.email = document.getElementById('txtEmail').value;
dataUser.password = document.getElementById('txtPassword').value;

let repeatPassword = document.getElementById('txtRepeatPassword').value;


if (repeatPassword != dataUser.password ){
    alert('las contraseñas no coinciden ');
    return;
}

(async () => {
  const request = await fetch('api/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
     body: JSON.stringify(dataUser)

  });
  alert("la cuenta fue creada con exito");
  window.location.href='login.html';

})();
}

