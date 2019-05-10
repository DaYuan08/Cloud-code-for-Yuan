<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>
<head>
<meta charset="UTF-8">
<title>Crud</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<style>
	   label{
	       padding: 20px 10px 0px;
	   }
	   button{
	       width: 64px;
	       height: 38px; 
	       background-color: #009688;
	       color:white;
	   }
	</style>
</head>
<body>
    <div style="margin:auto;">
        <form action="query" class="form-inline form-horizontal" style="text-align: center;" method="get">
            <label>
                姓名
                <input type="text" class="form-control" name="name" placeholder="请输入" value="${name eq '%' ? 请输入 : name }">
            </label> 
            <label>
                性别
                <select name="sex" class="form-control" style="width:210px">
                    <option value="0" <c:if test="${sex == 0 }">selected</c:if>>不限</option>
                    <option value="1" <c:if test="${sex == 1 }">selected</c:if>>男</option>
                    <option value="2" <c:if test="${sex == 2 }">selected</c:if>>女</option>
                </select>
            </label>
            <label>
                工作年限
                <input class="form-control" type="number" style="width:110px" name="workTimeStart" value="${workTimeStart }"/>
                <input class="form-control" type="number" style="width:110px" name="workTimeEnd" value="${workTimeEnd }"/>
            </label>   
            <label>
                生日区间
                  <input class="form-control" type="date" style="width:140px" name="birthDayStart" value="${birthDayStart}"/>
                <input class="form-control" type="date" style="width:140px" name="birthDayEnd" value="${birthDayEnd}"/>
            </label>   
            <button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>
        </form> 
        <div style="padding-top:60px">
            <button type="button" class="btn" data-toggle="modal" data-target="#delete" >删除</button>
	           <div class="modal fade" id="delete">
	               <div class="modal-dialog" style="width: 40%;">
	                   <div class="modal-content">
	                       <div class="modal-header" style="font-size: 20px;">
	                           特殊操作，需再次确认!
	                           <button class="close" data-dismiss="modal">&times;</button>
	                       </div>
	                       <div class="modal-body">
	                           确认删除？
	                       </div>
	                       <div class="modal-footer">
	                       	<form action="delete" id="deleteAll" method="get">
	                           <button class="btn btn-info" data-dismiss="modal">取消</button>
	                           <button type="submit" class="btn btn-danger" >确认</button>
	                       	</form>
	                       </div>
	                   </div>
	               </div>
	           </div>
            <button type="button" class="btn" data-toggle="modal" data-target="#insert">添加</button>
	           <div class="modal fade" id="insert">
	               <div class="modal-dialog" style="width: 40%;">
	                   <div class="modal-content">
	                       <div class="modal-header" style="font-size:20px;">
	                           请填写以下信息
	                           <button class="close" data-dismiss="modal">&times;</button>
	                       </div>
	                       <div class="modal-body">
	                           <form action="add" method="post" enctype="multipart/form-data" style="margin:auto;" class="form-horizontal">
	                               <div class="row">
	                                   <span class="col-xs-4 control-label" style="text-align:right;">姓名</span>
	                                   <input class="col-xs-8 form-control" style="width:52%;height:32px;" type="text" placeholder="请输入姓名" name="name"/>
	                               </div>
	                               <div class="row">
	                                   <span class="col-xs-4 control-label" style="text-align:right;">工作年限</span>
	                                   <input class="col-xs-4 form-control" style="width:52%;height:32px;" type="number" name="worktime"/>
	                               </div>
	                               <div class="row">
	                                   <span class="col-xs-4 control-label" style="text-align:right;">性别</span>
	                                   <select name="sex" class="col-xs-8 form-control" style="width:52%;height:32px;">
	                                       <option value="0">不限</option>
	                                       <option value="1">男</option>
	                                       <option value="2">女</option>
	                                   </select>
	                               </div>
	                               <div class="row">
	                                   <span class="col-xs-4 control-label" style="text-align:right;">头像</span>
	                                   <input class="col-xs-8 form-control" style="width:52%;height:32px; " type="file" name="headerPath" accept="image/gif, image/jpeg, image/jpg, image/png,"/>
	                               </div>
	                               <div class="row form-group">
	                                   <span class="col-xs-4 control-label" style="text-align:right;">生日</span>
	                                   <input class="col-xs-4 form-control" style="width:52%;height:32px;" type="date" name="birthDay"/>
	                               </div>
	                               <div class="row col-xs-offset-7">
	                                   <input class="btn btn-default" type="reset" style="width:32%"/>
	                                   <input class="btn btn-info" type="submit" style="width:32%"/>
	                               </div>
	                           </form>
	                       </div>
	                   </div>
	               </div>
	           </div>
        </div>
        <table class="table table-hover table-bordered" style="text-align: center;">
            <tr style="background-color:#EDEDED">
                <td>
                    <input type="checkbox"/>
                </td>
                <td>id</td>
                <td>员工姓名</td>
                <td>工作年限</td>
                <td>性别</td>
                <td>头像</td>
                <td>生日</td>
                <td>录入日期时间</td>
                <td>更新日期时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${userList}" var="user">
            <tr>
                <td>
                  <input type="checkbox" name="deleteIds" value="${user.id }" form="deleteAll"/>
                </td>
                <td>${user.id }</td>
                <td>${user.name }</td>
                <td>${user.workExperiencesex }</td>
                <td>${user.sex == 0 ? "不限" : user.sex == 1 ? "男" : "女"}</td>
                <td><img src="${pageContext.request.contextPath}/${user.headerImg}" width="24px" height="24px" alt="加载失败"/></td>
                <td>${user.birthDay }</td>
                <td>
                <f:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                <f:formatDate value="${user.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <button class="btn btn-info glyphicon glyphicon-pencil" style="height: 30px; font-size: 10px;" data-toggle="modal" data-target="#update${user.id }" >编辑</button>
                    <div class="modal fade" id="update${user.id }">
                        <div class="modal-dialog" style="width: 40%;">
                            <div class="modal-content">
                                <div class="modal-header" style="font-size:20px;">
                                    请填写要修改信息（选填）
                                    <button class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <form action="update" style="margin:auto;" class="form-horizontal" method="get">
                                    	<input type="hidden" name="userId" value="${user.id }" />
                                        <div class="row">
                                            <span class="col-xs-4 control-label" style="text-align:right;">姓名</span>
                                            <input class="col-xs-8 form-control" style="width:52%;height:32px;" type="text" placeholder="当前姓名：${user.name}" name="name"/>
                                        </div>
                                        <div class="row">
                                            <span class="col-xs-4 control-label" style="text-align:right;">工作年限</span>
                                            <input class="col-xs-4 form-control" style="width:52%;height:32px;" type="number" name="worktime" value="${user.workExperiencesex }"/>
                                        </div>
                                        <div class="row">
                                            <span class="col-xs-4 control-label" style="text-align:right;">性别</span>
                                            <select name="sex" class="col-xs-8 form-control" style="width:52%;height:32px;">
                                                <option value="0" <c:if test="${user.sex == 0 }">selected</c:if>>不限</option>
                                                <option value="1" <c:if test="${user.sex == 1 }">selected</c:if>>男</option>
                                                <option value="2" <c:if test="${user.sex == 2 }">selected</c:if>>女</option>
                                            </select>
                                        </div>
                                        <div class="row">
                                            <span class="col-xs-4 control-label" style="text-align:right;">头像</span>
                                            <input class="col-xs-8 form-control " style="width:52%;height:32px; " type="file" name="headerPath" accept="image/gif, image/jpeg, image/jpg, image/png,"/>
                                        </div>
                                        <div class="row form-group">
                                            <span class="col-xs-4 control-label" style="text-align:right;">生日</span>
                                            <input class="col-xs-4 form-control" style="width:52%;height:32px;" type="date" name="birthDay" value="${user.birthDay }"/>
                                        </div>
                                        <div class="row col-xs-offset-7">
                                            <input class="btn btn-default" type="reset" style="width:32%"/>
                                            <input class="btn btn-info" type="submit" style="width:32%"/>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-danger glyphicon glyphicon-trash" style="height: 30px; font-size: 10px" data-toggle="modal" data-target="#deleteSingle${user.id }" >删除</button>
                    <div class="modal fade" id="deleteSingle${user.id }">
                        <div class="modal-dialog" style="width: 40%;">
                            <div class="modal-content">
                                <div class="modal-header" style="font-size: 20px;">
                                    特殊操作，需再次确认!
                                    <button class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    确认删除？
                                </div>
                                <div class="modal-footer">
                                	<form action="delete" method="post">
                                        <input type="hidden" name="userId" value="${user.id}">
                                        <button class="btn btn-default" data-dismiss="modal">取消</button>
                                        <button type="submit" class="btn btn-danger">确定</button>
                                  	</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            </c:forEach>
       </table>
        <div style="text-align: center;">
            <ul class="pagination">
                <li>
                <a href="query?cpage=${cpage - 1}&pageRow=${pageRow}&name=${name}&sex=${sex}&workTimeStart=${workTimeStart}&workTimeEnd=${workTimeEnd}&birthDayStart=${birthDayStart}&birthDayEnd=${birthDayEnd}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <c:forEach begin="1" var="i" end="${maxPage }">
                	<li <c:if test="${cpage == i}"> class="active"</c:if> >
                		<a href="query?cpage=${i}&pageRow=${pageRow}&name=${name}&sex=${sex}&workTimeStart=${workTimeStart}&workTimeEnd=${workTimeEnd}&birthDayStart=${birthDayStart}&birthDayEnd=${birthDayEnd}" >${i}</a>
                	</li>
                </c:forEach>
                <li>
                <a href="query?cpage=${cpage + 1}&pageRow=${pageRow}&name=${name}&sex=${sex}&workTimeStart=${workTimeStart}&workTimeEnd=${workTimeEnd}&birthDayStart=${birthDayStart}&birthDayEnd=${birthDayEnd}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
        </div>
    </div>
    <script>
        $(function () {
			$(".deleteIdAll").click(function (e) {
				let checked = $(this).prop("checked");
				console.info(checked)
				$(".deleteId").prop("checked", checked);
			})
        })
    </script>
</body>
</html>