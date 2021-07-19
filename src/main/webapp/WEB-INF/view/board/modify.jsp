<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>register</title>
  <!-- Custom fonts for this template-->
    <link href="${contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<%@ include file="../includes/header.jsp" %>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Modify</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Modify Page</div>
				<div class="panel-body">
					<form role="form" action="/board/modify" method="post">
					
						<div class="form-group">
							<label>Bno</label>
							<input class="form-control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>Title</label>
							<input class="form-control" name="title" value='<c:out value="${board.title }"/>'>
						</div>

						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="content"><c:out value="${board.content }"/></textarea>
						</div>
						
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" name="writer"  value='<c:out value="${board.writer }"/>' readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>RegDate</label>
							<input class="form-control" name="regDate" readonly="readonly" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}" />'>
						</div>

						<div class="form-group">
							<label>Update Date</label>
							<input class="form-control" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.updateDate}" />'>
						</div>
						
						<button type="submit" class="btn btn-default" data-oper='modify' onclick="location.href='/board/modify?bno=<c:out value = "${board.bno}"/>'">Modify</button>
						<button type="submit" class="btn btn-danger" data-oper='remove' onclick="location.href='/board/modify?bno=<c:out value = "${board.bno}"/>'">Remove</button>
						<button type="submit" class="btn btn-info" data-oper='list' onclick="location.href='/board/list'">List</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp" %>
</body>
<!-- Bootstrap core JavaScript-->
    <script src="${contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${contextPath }/resources/js/sb-admin-2.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		
		var formObj = $("form");
		
		$('button').on("click",function(e){
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action", "/board/remove");
			}else if(operation === 'list'){
				//move to list
				self.location = "/board/list";
				return;
			}
			
			formObj.submit();
		})
	})
</script>
</html>