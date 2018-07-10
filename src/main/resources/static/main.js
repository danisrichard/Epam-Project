function ajaxGet(url, data, successCallback) {
	$.ajax({
		url: url,
		type:'GET',
		dataType: "html",
		data: data,
		success : function(result) {
			successCallback(result)
		},
		error: function (xhr) {
			handleError(xhr);
		}
	});
}

function handleError(xhr) {
	if (xhr.status == 666) {
		$("html").html(xhr.responseText);
	} else {
		alert("Hiba történt! " + xhr.status);
	}
}