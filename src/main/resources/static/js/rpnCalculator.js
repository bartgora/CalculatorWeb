$(function(){
	$(".errors").hide();
	$("#submitButton").prop('disabled', 'true');

	$("#source").change(function(){
	        if($(this).val().length != 0){
	            $("#submitButton").prop('disabled', null);
	        }else{
	            $("#submitButton").prop('disabled', 'true');
	        }
	 })
});


function calculate(){
	var source = $("#source").val();
	$(".errors").hide();
	$.ajax({
		url: '/calculate/'+source,
		datatype: "json",
		success: function(response){
			$("#result").val(response.result);
		},
		error: function(error){
			console.log(error)
			var message = $.parseJSON(error.responseText).error;
			var code = $.parseJSON(error.responseText).status;
			$("#errorCode").text(code);
			$("#errorMessage").text(message);
			$(".errors").show();
			
		}
	})
}