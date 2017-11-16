$(function() {
	$('[rel=tooltip]').tooltip();	
})

$('#deleteModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	var registryId = button.data('id');
	var form = $(this).find('form');
	var action = form.data('action');
	
	form.attr('action', action + '/' + registryId);
});