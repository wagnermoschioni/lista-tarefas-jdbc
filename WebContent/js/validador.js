
 function validar() {
	  var inputDescricao = document.getElementById('desc').value;
	   if (inputDescricao === "") {
                window.alert("O campo descrição está vazio!");
                document.getElementById('desc').focus();
            }  else {				
				document.forms["frmContato"].submit();
			}
 }