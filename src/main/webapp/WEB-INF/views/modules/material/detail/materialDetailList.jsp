<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料信息管理</title>
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
		<li class="active"><a href="${ctx}/material/detail/materialDetail/">物料信息列表</a></li>
		<shiro:hasPermission name="material:detail:materialDetail:edit"><li><a href="${ctx}/material/detail/materialDetail/form">物料信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="materialDetail" action="${ctx}/material/detail/materialDetail/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>物料名字：</label>
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
				<th>物料名字</th>
				<th>线路标识</th>
				<th>物料类型code</th>
				<th>经度</th>
				<th>纬度</th>
				<th>图片路径</th>
				<shiro:hasPermission name="material:detail:materialDetail:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="materialDetail">
			<tr>
				<td><a href="${ctx}/material/detail/materialDetail/form?id=${materialDetail.id}">
					${materialDetail.name}
				</a></td>
				<td>
					${materialDetail.road}
				</td>
				<td>
					${materialDetail.materialTypeCode}
				</td>
				<td>
					${materialDetail.longitude}
				</td>
				<td>
					${materialDetail.latitude}
				</td>
				<td>
					${materialDetail.picturePath}
				</td>
				<shiro:hasPermission name="material:detail:materialDetail:edit"><td>
    				<a href="${ctx}/material/detail/materialDetail/form?id=${materialDetail.id}">修改</a>
					<a href="${ctx}/material/detail/materialDetail/delete?id=${materialDetail.id}" onclick="return confirmx('确认要删除该物料信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>