<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>物料详细信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/material/detail/materialDetail/">物料详细信息列表</a></li>
		<li class="active"><a href="${ctx}/material/detail/materialDetail/form?id=${materialDetail.id}">物料详细信息<shiro:hasPermission name="material:detail:materialDetail:edit">${not empty materialDetail.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="material:detail:materialDetail:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="materialDetail" action="${ctx}/material/detail/materialDetail/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
        <div class="control-group">
        <label class="control-label">物料名字：</label>
        <div class="controls">
        <form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
        </div>
        </div>
		<div class="control-group">
			<label class="control-label">线路</label>
			<div class="controls">
                <form:select path="road" class="input-xlarge required">
                    <form:option value="" label="---请选择路线---"/>
                    <form:options items="${materialRoadMap}"  htmlEscape="false" />
                </form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">物料类型code：</label>
			<div class="controls">
                <form:select path="materialTypeId" class="input-xlarge required">
                    <form:option value="" label="---请选择物料类型---"/>
                    <form:options items="${materialTypeMap}"  htmlEscape="false" />
                </form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">经度：</label>
			<div class="controls">
				<form:input path="longitude" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">纬度：</label>
			<div class="controls">
				<form:input path="latitude" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片路径：</label>
            <div class="controls">
                <form:hidden path="picturePath" htmlEscape="false" maxlength="255" class="input-xlarge"/>
                <sys:ckfinder input="picturePath" type="images" selectMultiple="true" uploadPath="/material/detail"/>
            </div>
		</div>
		<div class="control-group">
			<label class="control-label">序号：</label>
			<div class="controls">
				<form:input path="pointorder" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="material:detail:materialDetail:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>