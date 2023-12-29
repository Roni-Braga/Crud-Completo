const alertPlaceholder = document.getElementById('liveAlertPlaceholder')
			const appendAlert = (message, type) => {
 			const wrapper = document.createElement('div')
 				 wrapper.innerHTML = [
  				  `<div class="alert alert-${type} alert-dismissible" role="alert">`,
  				  `   <div>${message}</div>`,
  				  '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
  				  '</div>'
  			].join('')

  				alertPlaceholder.append(wrapper)
}

				const alertTrigger = document.getElementById('liveAlertBtn')
function SalvarUsuario(){
	var name = $('#name').val();
	var age = $('#age').val();
	
	$.ajax({
		method:"POST",
		url:"usuario",
		data:JSON.stringify({name: name, age: age}),
		contentType:"application/json; charset=utf-8",
		success: function(response){
			
			if (alertTrigger) {
 			 alertTrigger.addEventListener('click', () => {
  			  appendAlert('Nice, you triggered this alert message!', 'success')
  })
}
		}
		
	}).fail(function(xhr,status,errorThrown){
		alert("Erro ao salvar usuário" + xhr.responseText);
	});
	
}
