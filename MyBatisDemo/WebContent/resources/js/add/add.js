function addMsg() {
	var command = $("#command").val();
	if (!command) {
		alert("请输入指令");
		return;
	}
	var description = $("#description").val();
	if (!description) {
		alert("请输入描述");
		return;
	}
	var content = $("#content").val();
	if (!content) {
		alert("请输入内容");
		return;
	}

	$.ajax({
		url : $("#basePath").val() + "AddMessageServlet.action",
		type : "POST",
		dataType : "text",
		timeout : 10000,
		success : function(data) {
			alert(data)
		},
		data : {
			"command" : command,
			"description" : description,
			"content" : content,
		}
	});
}