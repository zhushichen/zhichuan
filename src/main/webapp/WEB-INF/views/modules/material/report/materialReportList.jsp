<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>台账管理</title>
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
		<li class="active"><a href="${ctx}/material/report/materialReport/">台账列表</a></li>
		<shiro:hasPermission name="material:report:materialReport:edit"><li><a href="${ctx}/material/report/materialReport/form">台账添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="materialReport" action="${ctx}/material/report/materialReport/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>线路id</th>
				<th>电缆型号</th>
				<th>电缆厂家</th>
				<th>电缆长度</th>
				<shiro:hasPermission name="material:report:materialReport:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="materialReport">
			<tr>
				<td><a href="${ctx}/material/report/materialReport/form?id=${materialReport.id}">
					${materialReport.roadid}
				</a></td>
				<td>
					${materialReport.cabletype}
				</td>
				<td>
					${materialReport.cablemanufacturer}
				</td>
				<td>
					${materialReport.cablelength}
				</td>
				<shiro:hasPermission name="material:report:materialReport:edit"><td>
    				<a href="${ctx}/material/report/materialReport/form?id=${materialReport.id}">修改</a>
					<a href="${ctx}/material/report/materialReport/delete?id=${materialReport.id}" onclick="return confirmx('确认要删除该台账吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>