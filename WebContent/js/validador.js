
 function validar() {
	/*
	  var inputDescricao = document.getElementById('desc').value;
	   if (inputDescricao === "") {
                window.alert("O campo descrição está vazio!");
                document.getElementById('desc').focus();
                inputDescricao.style.backgrounColor = "red;"
            }  else {				
				document.forms["frmContato"].submit();
			}   */
			var inputField = document.getElementById('desc');
            var errorMessage = document.getElementById('error-message');

            if (inputField.value.trim() === '') {
				inputField.style.borderColor = 'red';
                errorMessage.style.display = 'block';
                inputField.focus();
            } else {
                errorMessage.style.display = 'none';
            }
			
 }
 
window.onload = function() {	
	var celulas = document.querySelectorAll('#tabela .status-cor');	
	
      celulas.forEach(function(cell) {
				//alert(cell.textContent.trim());
                switch (cell.textContent.trim()) {
                    case 'A iniciar':
                        cell.style.color = 'gray';
                        break;
                    case 'Em andamento':
                         cell.style.color = 'orange';
                        break;
                    case 'Concluído':
                        cell.style.color = 'green';
                        break;
                    default:
                        break;
                }
            });	
	
	 }
	
