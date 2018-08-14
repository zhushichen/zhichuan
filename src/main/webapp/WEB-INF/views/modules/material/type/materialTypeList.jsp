<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料类型管理</title>
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
		<li class="active"><a href="${ctx}/material/type/materialType/">物料类型列表</a></li>
		<shiro:hasPermission name="material:type:materialType:edit"><li><a href="${ctx}/material/type/materialType/form">物料类型添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="materialType" action="${ctx}/material/type/materialType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>描述：</label>
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
				<th>描述</th>
				<th>厂家</th>
				<th>型号</th>
				<th>数量</th>
				<th>备注</th>
				<th>更新时间</th>
				<shiro:hasPermission name="material:type:materialType:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="materialType">
			<tr>
				<td><a href="${ctx}/material/type/materialType/form?id=${materialType.id}">
					${materialType.name}
				</a></td>
				<td>
					${materialType.origin}
				</td>
				<td>
					${materialType.model}
				</td>
				<td>
					${materialType.amount}
				</td>
				<td>
					${materialType.remark}
				</td>
				<td>
					<fmt:formatDate value="${materialType.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="material:type:materialType:edit"><td>
    				<a href="${ctx}/material/type/materialType/form?id=${materialType.id}">修改</a>
					<a href="${ctx}/material/type/materialType/delete?id=${materialType.id}" onclick="return confirmx('确认要删除该物料类型吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>