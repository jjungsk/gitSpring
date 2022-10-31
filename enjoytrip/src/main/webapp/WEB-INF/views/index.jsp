<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/headerNoLogin.jsp"%>

<!-- cover start -->
<header class="masthead">
	<div
		class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
		<div class="d-flex justify-content-center">
			<div class="text-center">
				<h1 class="mx-auto text-uppercase">
					Enjoy<br />Trip
				</h1>
				<h2 class="text-black-50 mx-auto mt-3 mb-5 custom-title">내가 그리는
					나만의 여행</h2>
				<a class="btn btn-primary" href="#recommend">let's trip</a>
			</div>
		</div>
	</div>
</header>
<!-- cover end -->
<!-- 여행 추천 start -->
<section class="text-center justify-content-center mb-5" id="recommend">
	<div class="container pt-5">
		<h4 class="fw-bold mb-5 custom-title">목적지가 없다면? 취향 저격 추천 명소</h4>
	</div>
	<div class="align-content-center justify-content-center d-flex">
		<div class="image me-5">
			<a href="${root}/tourList/todaysTour"> <img class="image__img"
				src="./assets/img/tourSpot.png" />
				<div class="image__overlay mouse-pointer">
					<p class="image__description">오늘의 관광지</p>
				</div>
			</a>
		</div>
		<div class="image me-5">
			<a href="${root}/tourList?act=mvTodaysFestival"> <img class="image__img"
				src="./assets/img/festival.jpg" />
				<div class="image__overlay mouse-pointer">
					<p class="image__description">오늘의 행사/공연/축제</p>
				</div>
			</a>
		</div>
		<div class="image">
			<a href="${root}/tourList?act=mvTodaysRestaurant"> <img class="image__img"
				src="./assets/img/restaurant.jpg" />
				<div class="image__overlay mouse-pointer">
					<p class="image__description">오늘의 맛집</p>
				</div>
			</a>
		</div>
	</div>
	<hr class="m-5">
</section>
<!-- 여행 추천 end -->

<!-- 목적지 근처 정보 start -->
<section class="text-center mt-5" id="#">
	<div class="container px-4 px-lg-5">
		<!-- Featured Project Row-->
		<div class="row gx-0 mb-4 mb-lg-5 align-items-center menu-box">
			<div class="col-xl-8 col-lg-7">
				<img class="img-fluid mb-3 mb-lg-0 w-100"
					src="assets/img/airplane.png" alt="..." />
			</div>
			<div class="col-xl-4 col-lg-5">
				<div class="featured-text text-center text-lg-left">
					<h4 class="fw-bold">나만의 여행 계획하기</h4>
					<p class="text-black-50 mb-0">목적지만 선택하면 주변 정보가 한 눈에</p>
					<a class="btn btn-primary mt-3" href="${root}/map/map.jsp">어디로 떠나시나요?</a>
				</div>
			</div>
		</div>
</section>
<!-- 목적지 근처 정보 end -->

<!-- 일출일몰 정보 start -->
<section class="text-center mt-5" id="#">
	<div class="container px-4 px-lg-5">
		<!-- Featured Project Row-->
		<div class="row gx-0 mb-4 mb-lg-5 align-items-center menu-box">
			<div class="col-xl-4 col-lg-5">
				<div class="featured-text text-center text-lg-left">
					<h4 class="fw-bold">일출 일몰</h4>
					<p class="text-black-50 mb-0">
						인생샷을 남기고 싶다면?<br> 해가 뜨고 해가 지는 아름다운 여행지
					</p>
					<a class="btn btn-primary mt-3" href="${root}/tourList?act=mvSun">그 날의 해는?</a>
				</div>
			</div>
			<div class="col-xl-8 col-lg-7">
				<img class="img-fluid mb-3 mb-lg-0 w-100" src="assets/img/sun.jpg"
					alt="..." />
			</div>
		</div>
</section>
<!-- 일출일몰 정보 end -->

<!-- 교통 정보 start -->
<section class="text-center mt-5" id="#">
	<div class="container px-4 px-lg-5">
		<!-- Featured Project Row-->
		<div class="row gx-0 mb-4 mb-lg-5 align-items-center menu-box">
			<div class="col-xl-8 col-lg-7">
				<img class="img-fluid mb-3 mb-lg-0 w-100"
					src="assets/img/weather.jpg" alt="..." />
			</div>
			<div class="col-xl-4 col-lg-5">
				<div class="featured-text text-center text-lg-left">
					<h4 class="fw-bold">날씨 정보</h4>
					<p class="text-black-50 mb-0">
						전국 주요 관광지의<br> 주간 날씨를 확인해보세요
					</p>
					<a class="btn btn-primary mt-3" href="${root}/tourList?act=mvWeather">이번주 날씨는?</a>
				</div>
			</div>
		</div>
</section>
<!-- 교통 정보 end -->

<!-- 국내 여행 추천 start -->
<section class="text-center" id="#">
	<hr class="m-5">
	<div class="container mb-5">
		<div class="row justify-content-center">
			<h4 class="fw-bold mt-5 mb-5">내 나라 구석구석</h4>
			<ul class="d-flex justify-content-center mb-5">
				<li class="nook-item mouse-pointer"><a
					href="${root}/gooseok?act=sooncheon" class="gooseok"> <img
						class="rounded-circle my-nook" src="assets/img/sooncheon.jpg"
						alt="">
						<div class="m-3">
							<h5 class="fw-bold">순천시</h5>
							<p>
								전통과 역사가<br>살아 숨쉬는 도시
							</p>
						</div>
				</a></li>
				<li class="nook-item mouse-pointer"><a
					href="${root}/gooseok?act=seogwipo" class="gooseok"> <img
						class="rounded-circle my-nook" src="assets/img/jeju.jpg" alt="">
						<div class="m-3">
							<h5 class="fw-bold">서귀포시</h5>
							<p>
								천혜의 자연경관이 수려한<br>세계적 휴양 관광지
							</p>
						</div></a></li>
				<li class="nook-item mouse-pointer"><a
					href="${root}/gooseok?act=gangreung" class="gooseok"><img
						class="rounded-circle my-nook" src="assets/img/gangreung.jpg"
						alt="">
						<div class="m-3">
							<h5 class="fw-bold">강릉시</h5>
							<p>
								전국 서퍼와<br>커피가 가득한 이 곳
							</p>
						</div></a></li>
				<li class="nook-item mouse-pointer"><a
					href="${root}/gooseok?act=haewoondae" class="gooseok"><img
						class="rounded-circle my-nook" src="assets/img/haewoondae.jpg"
						alt="">
						<div class="m-3">
							<h5 class="fw-bold">해운대구</h5>
							<p>
								파란 하늘과<br>바다가 숨 쉬는 곳
							</p>
						</div></a></li>
				<li class="nook-item mouse-pointer"><a
					href="${root}/gooseok?act=ganghwa" class="gooseok"><img
						class="rounded-circle my-nook" src="assets/img/ganghwa.jpg" alt="">
						<div class="m-3">
							<h5 class="fw-bold">강화군</h5>
							<p>
								크고 작은 15개 섬이<br>한 곳에
							</p>
						</div></a></li>
			</ul>
		</div>
	</div>
</section>

<!-- 게시판 공지사항 section start -->
<div class="container w-75">
	<div class="row mt-3 mb-5">
		<div class="col-md-6">
			<div class="d-flex">
				<h3 class="fw-bold mt-5">
					게시판
					<h6 class="mt-5" style="line-height: 40px">
						<a href="${root}/board?act=list&pgno=1">&nbsp;&nbsp;바로가기</a>
					</h6>
				</h3>
			</div>
			<table class="table table-hover">
				<thead>
					<tr class="text-center">

						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody id="boardlist">
				</tbody>
			</table>
		</div>
		<div class="col-md-6">
			<div class="d-flex">
				<h3 class="fw-bold mt-5">
					공지사항
					<h6 class="mt-5" style="line-height: 40px">
						<a href="${root}/notice?act=list&pgno=1">&nbsp;&nbsp;바로가기</a>
					</h6>
				</h3>
			</div>

			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<th scope="col">제목</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody id="noticelist">
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- 게시판 공지사항 section end -->

<script>
// 게시판, 공지사항 3개 미리 얻어오기
window.onload = function () {
	fetch("${root}/board?act=preview")
	.then(response => response.json())
	.then(data => preview(data.list, "#boardlist"));
	
	fetch("${root}/notice?act=preview")
	.then(response => response.json())
	.then(data => preview(data.list, "#noticelist"));
}

function preview(list, id) {
	let bodycontent = ``;
	list.forEach(function(member) {
		bodycontent += `
			<tr class="text-center">
      <td class="text-start">\${member.subject}</td>`;
    if (id == "#boardlist") {
    	bodycontent += `<td>\${member.userid}</td>`;
    }
    bodycontent += `
      <td>\${member.hit}</td>
    </tr>
		`;
	})
	document.querySelector(id).innerHTML = bodycontent;
}
</script>

<%@include file="/WEB-INF/views/common/footer.jsp"%>