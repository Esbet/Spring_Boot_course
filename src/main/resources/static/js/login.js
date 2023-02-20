// Call the dataTables jQuery plugin
$(document).ready(function() {
loadUsers();

});


async function LoginUser(){


let dataUser = {}

dataUser.email = document.getElementById('txtEmail').value;
dataUser.password = document.getElementById('txtPassword').value;


(async () => {
  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
     body: JSON.stringify(dataUser)

  });
  const response = await request.text();
    if (response != 'FAIL'){
    localStorage.token = response;
    localStorage.email = dataUser.email;
    window.location.href = 'users.html'
    }else{
    alert("las credenciales son incorrectas. Por favor intentalo nuevamente!");
    }

})();
}

