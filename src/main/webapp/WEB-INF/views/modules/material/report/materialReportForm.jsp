<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>台账管理</title>
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

		function changePoint(){

		    var roadId = $("#roadSelect").val();
            $.ajax({
                url: "${ctx}/material/report/materialReport/getPointByRoad?roadId="+roadId,
                success: function(result){
                    console.log("success");
                    $("#pointSelect").empty();
                    /*
                     * 清空遗留显示，迫不得已，注意
                     */
                    $(".select2-chosen")[1].innerHTML='';
                    for(var i = 0; i < result.length; i++){
                        var item = result[i];
                        $("#pointSelect").append("<option value=item['id']>"+item["name"] + "</option>");
                    }
                },
                error: function(error){
                    console.log("error");
                    console.log(error);
                }
            });
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/material/report/materialReport/">台账列表</a></li>
		<li class="active"><a href="${ctx}/material/report/materialReport/form?id=${materialReport.id}">台账<shiro:hasPermission name="material:report:materialReport:edit">${not empty materialReport.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="material:report:materialReport:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="materialReport" action="${ctx}/material/report/materialReport/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">线路id：</label>
			<div class="controls">
				<form:select path="roadid" id="roadSelect" class="input-xlarge required" onchange="changePoint()">
					<form:option value="" label=""/>
                    <form:options items="${roadMap}"  htmlEscape="false" />
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">点id：</label>
			<div class="controls">
				<form:select path="pointid" id="pointSelect" class="input-xlarge required">
					<form:option value="" label=""/>
                    <form:options items="${pointMap}"  htmlEscape="false" />
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">借口井编号：</label>
			<div class="controls">
				<form:input path="jointwellnumber" htmlEscape="false" maxlength="11" class="input-xlarge  digits"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电缆型号：</label>
			<div class="controls">
				<form:input path="cabletype" htmlEscape="false" maxlength="1000" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电缆厂家：</label>
			<div class="controls">
				<form:input path="cablemanufacturer" htmlEscape="false" maxlength="1000" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电缆长度：</label>
			<div class="controls">
				<form:input path="cablelength" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件类型：</label>
			<div class="controls">
				<form:input path="attachmenttype" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件厂家：</label>
			<div class="controls">
				<form:input path="attachmentmanufacturer" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">接地方式：</label>
			<div class="controls">
				<form:input path="groundingmode" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="material:report:materialReport:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>