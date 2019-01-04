/**
 * 
 * @param basePath
 * @returns
 */
function jumpToAddMsgPage(basePath) {
	$("#mainForm").attr("action", basePath + "JumpToAddMsgServlet.action");
	$("#mainForm").submit();
}

/**
 * delete one message by id
 * 
 * @param basePath
 * @returns
 */
function deleteOne(basePath) {
	if (confirm("确定删除此条数据嘛？")) {
		$("#mainForm").attr("action", basePath + "deleteOne.action");
		$("#mainForm").submit();
	}
}
/**
 * delete one message by id
 * 
 * @param url
 * @param id
 * @returns
 */
function deleteOne(basePath, id) {
	if (confirm("确定删除此条数据嘛？")) {
		// document.getElementById("id").value = id;
		// document.getElementById("mainForm").action = url;
		// document.getElementById("mainForm").submit();
		$("#mainForm").attr("action", basePath + "deleteOne.action?id=" + id);
		$("#mainForm").submit();
	}
}

/**
 * batch delete message
 * 
 * @returns
 */
function deleteBatch(basePath) {
	/*
	 * document.getElementById("mainForm").action = basepath +
	 * "deleteBatch.action"
	 */
	if (confirm("确定删除选中的数据嘛？")) {
		$("#mainForm").attr("action", basePath + "deleteBatch.action");
		$("#mainForm").submit();
	}
}

function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();

}