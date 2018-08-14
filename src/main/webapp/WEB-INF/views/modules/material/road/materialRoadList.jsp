<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>路线管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/material/road/materialRoad/">路线列表</a></li>
		<shiro:hasPermission name="material:road:materialRoad:edit"><li><a href="${ctx}/material/road/materialRoad/form">路线添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="materialRoad" action="${ctx}/material/road/materialRoad/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>线路名字：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>线路名字</th>
				<th>备注</th>
				<th>更新时间</th>
				<shiro:hasPermission name="material:road:materialRoad:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="materialRoad">
			<tr>
				<td><a href="${ctx}/material/road/materialRoad/form?id=${materialRoad.id}">
					${materialRoad.id}
				</a></td>
				<td>
					${materialRoad.name}
				</td>
				<td>
					${materialRoad.remark}
				</td>
				<td>
					<fmt:formatDate value="${materialRoad.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="material:road:materialRoad:edit"><td>
    				<a href="${ctx}/material/road/materialRoad/form?id=${materialRoad.id}">修改</a>
					<a href="${ctx}/material/road/materialRoad/delete?id=${materialRoad.id}" onclick="return confirmx('确认要删除该路线吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>