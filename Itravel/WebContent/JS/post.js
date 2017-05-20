

	    $(document).ready(function() {
		$('#states').click(function(event) {
			$.get('ActionServlet', {
				countryname : "India"
			}, function(responseJson) {
				var $select = $('#states');
				$select.find('option').remove();
				$.each(responseJson, function(key, value) {
					$('<option>').val(key).text(value).appendTo($select);
				});
			});
		});
	});
