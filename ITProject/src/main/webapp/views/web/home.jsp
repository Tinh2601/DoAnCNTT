<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Section-->
	<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">K&T SHOP CATEGORY</h1>
		<p class="lead text-muted mb-0">Có rất nhiều lựa chọn dành cho bạn</p>
	</div>
</section>
	<!-- Product -->
	<div class="bg0 m-t-23 p-b-140">

			<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card  ">
					<div class="card-header bg-light text-black text-uppercase" >
						<i class="fa fa-list-alt"></i> Categories
					</div>
					<ul class="list-group ">
						<c:forEach items="${listCC}" var="o">
							<li  ><a class="list-group-item text-back ${cid == o.categoryId ? "active":""}"
								href="${pageContext.request.contextPath}/web-category/list?cateId=${o.categoryId}">${o.categoryName}</a></li>
						</c:forEach>

					</ul>
				</div>
				
			</div>

			<div class="col-sm-9">
				<div id="content" class="row">
					<c:forEach items="${listP}" var="o">
						<div class="product col-12 col-md-6 col-lg-4">
							<div class="card">
								<img class="card-img-top" src="${o.images}" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a href="detail?pid=${o.productId}" title="View Product">${o.productName}</a>
									</h4>
									<p class="card-text show_txt"></p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${o.price} đ</p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				
			</div>

		</div>

	</div>
	</div>
	
	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

</body>
</html>