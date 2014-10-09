/**
 * 
 */

$(document).ready(
		function() {
			$.ajax({
				type : "GET",
				url : "/FindStuff/jaxrs/shopping",
				dataType : "json",
				success : function(data) {
					if (data.length > 0) {
						$(data).each(function(index, element) {
							var msg_data = "<div id='msg" + element.Sub_Cat_Id + "'>"
									+ element.Sub_Cat_Name + "</div>";
							$(msg_data).appendTo("#content");
						});
					} else {
						$("#content").html("No Results");
					}
				}
			});
	

			$('#UpdateButton').click(function() {
				$.ajax({
					type: 'POST',
					contentType: 'application/json',
					url: "/restdemo/jaxrs/customers/InsertMessage",
					dataType: "json",
					data: formToJSON(),
					success: function(data) {
						$("#Message").val('');
						$("#content").prepend("<div>" + data + "</div");
					},
					error: function(){
						alert('Error while adding message');
					}
				});
			});
			
			function formToJSON() {
				return JSON.stringify({
					"message": $('#Message').val(), 
					"user_id": "2",
					"msg_id" : "1"
					});
			}
		});
