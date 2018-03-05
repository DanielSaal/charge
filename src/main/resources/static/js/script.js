$(function() {
	$('[rel=tooltip]').tooltip();
	
	$('.js-update-status').on('click', function(event){
		event.preventDefault();
		
		var receiveButton = $(event.currentTarget);
		var urlReceive = receiveButton.attr('href');
		
		var response = $.ajax({
			url: urlReceive,
			type: 'PUT'
		});
		
		response.done(function(e){
			var registryId = receiveButton.data('id');
			$('[data-role=' + registryId + ']').html('<span class="label label-success">' + e + '</span>')
			receiveButton.hide();
		});
		
		response.fail(function(e){
			console.log('Error');
			alert('Error');
		});
	});
})

$('#deleteModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	var registryId = button.data('id');
	var form = $(this).find('form');
	var action = form.data('action');
	
	form.attr('action', action + '/' + registryId);
});