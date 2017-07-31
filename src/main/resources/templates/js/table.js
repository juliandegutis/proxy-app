jQuery(document).ready(function($) {
	loadTable();
});

function loadTable() {
	jQuery.ajax({
		type: 'GET',
		cache: false,
		url: 'http://localhost:8080/proxy/request',
		data : { },
		success : function(dataMessage) {			
			alert('lol');
		},
		error : function(dataMessage){
			
		}
	});
}