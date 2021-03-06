<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>

<link href="${basePath}resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script src="${basePath}resources/js/common/jquery-3.3.1.js"></script>
<script src="${basePath}resources/js/back/list.js"></script>

<!-- <script type="text/javascript">
	function deleteOne(url, id) {
		if (confirm("确定删除此条数据嘛？")) {
			/* this.mainForm.action=url;
			this.mainForm.id.value=id;
			this.mainForm.submit();  */
			document.getElementById("id").value = id;
			document.getElementById("mainForm").action = url;
			document.getElementById("mainForm").submit();
		}
	}
</script> -->
</head>
<body style="background: #e1e9eb;">
	<form action="<%=basePath%>list.action" id="mainForm" method="post">
		<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}" />
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 <a class="btn03"
						href="javascript:jumpToAddMsgPage('<%=basePath%>')">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						class="btn03" href="javascript:deleteBatch('<%=basePath%>')">删
						除</a>
				</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">指令：</td>
							<td><input name="command" type="text" class="allInput"
								value="${command }" /></td>
							<td width="90" align="right">描述：</td>
							<td><input name="description" type="text" class="allInput"
								value="${description }" /></td>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="查 询" /></td>
						</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th><input type="checkbox" id="all" /></th>
								<th>序号</th>
								<th>指令</th>
								<th>描述</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${messageBeans}" var="message"
								varStatus="status">
								<tr
									<c:if test="${status.index%2!=0 }">
									style="background-color:##ECF6EE"</c:if>>
									<td><input type="checkbox" name="cb_id"
										value="${message.id}" /></td>
									<td>${message.id }</td>
									<td>${message.command }</td>
									<td>${message.description }</td>
									<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a
										href="javascript:deleteOne('<%=basePath%>')">删除</a> <input
										type="hidden" name="delete_id" value="${message.id}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${page.totaNum}</b> 条 <a
							href="javascript:changeCurrentPage('1')" class='first'>首页</a> <a
							href="javascript:changeCurrentPage('${page.currentPage-1 }')"
							class='pre'>上一页</a> 当前第<span>${page.currentPage }/${page.totalPage }</span>页
						<a href="javascript:changeCurrentPage('${page.currentPage+1 }')"
							class='next'>下一页</a> <a
							href="javascript:changeCurrentPage('${page.totalPage }')"
							class='last'>末页</a> 跳至&nbsp;<input id="jumpPage" type='text'
							value='1' class='allInput w28' />&nbsp;页&nbsp; <a
							href="javascript:changeCurrentPage($('#jumpPage').val())" class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>