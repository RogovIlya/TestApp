<#include "header.ftl">
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">AnimeGitHub</a>
				</div>
				<div>${user!"nulll"}</div>
				<div id="navbar" class="navbar-collapse collapse">
					<form class="navbar-form navbar-right" action="authentication" method="POST">
						<div class="form-group">
							<input type="text" name = "login" placeholder="Email" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" name="password" placeholder="Password" class="form-control">
						</div>
						<input type="hidden" name="${_csrf.parameterName!""}" 	value="${_csrf.token!""}" />
						<button type="submit" class="btn btn-success">Войти</button>
					</form>
				</div><!--/.navbar-collapse -->
			</div>
		</nav>
		<div class="row-fluid center" style="padding-top: 5%; background-color: #F7C923;">
			<div class="container-fluid">
				<h1>Тестовый</h1>
				<p></p>
				<p><a href="#" target="_blank" class="btn btn-success btn-lg">Get started today</a></p>
			</div>
		</div>
		<div class="container-fluid nopadding">
			<!-- Example row of columns -->
			<div class="row-fluid">
				<div class="col-lg-* main_body">
					<div class="row-fluid">
						<div class="col-md-3 text-center">
							<div class = "left">
								Left
							</div>
						</div>
						<div class="col-md-6 text-left nopadding">
							<div class = "news panel news-panel">
								<div class="news-header-panel panel-heading" >
									<a class="btn" href="anime.html" role="button" style = "text-align:left;color: white;">
										<b>ONE PIECE (ВАН ПИС)</b>
									</a>
								</div>
								<div class="news-body" style="display: none;">
									<div class="container-fluid">
										<div class="row-fluid news-header">
											<div class = "col-md-* nopadding category ">
												<p>Категория:
													<a class="btn-link" role="button" href="#">боевые искусства</a>,
													<a class="btn-link" role="button" href="#">романтика</a>,
													<a class="btn-link" role="button" href="#">фантастика</a>,
													<a class="btn-link" role="button" href="#">этти</a>
													<a class="btn-link" role="button" href="#">этти</a>
													<a class="btn-link" role="button" href="#">этти</a>
													<a class="btn-link" role="button" href="#">этти</a>
													<a class="btn-link" role="button" href="#">этти</a>
												</p>
											</div>
										</div>
										<div class="row-fluid">
											<div class="col-md-4 nopadding img-body">
												<a href="anime">
													<img src="static/img/one_piece.jpg" alt="name" class="img-rounded img-header">
												</a>
												<div class ="rating">
													<h4>Рейтинг:&nbsp;<span class = "value_rating"></span>/<span class="value_rating_max"></span></h4>
													<input type="hidden" value="4" id="value_rating">
													<div class="rateit" data-rateit-backingfld="#value_rating" data-rateit-readonly="true" data-rateit-resetable="false" data-productid="312" data-rateit-step="0.1" data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="10"></div>
												<!--h4>Ваша оценка:&nbsp;<span class = "value_hover"></span></h4-->
												</div>
											</div>
											<div class="col-md-8">
												<div class="text-left">
													<ul class="list-unstyled">
														<li>
															<b>Год выпуска:</b>
															<a class="btn label label-info" role="button" href="#">2016</a>
														</li>
														<li>
															<b>Жанр:</b>
															<a class="btn label label-info" role="button" href="#">боевые искусства</a>,
															<a class="btn label label-info" role="button" href="#">гарем</a>,
															<a class="btn label label-info" role="button" href="#">романтика</a>,
															<a class="btn label label-info" role="button" href="#">фантастика</a>,
															<a class="btn label label-info" role="button" href="#">этти</a>
														</li>
														<li>
															<b>Озвучка:</b>
															<a class="btn label label-info" role="button" href="#">Русская озвучка</a>
														</li>
														<li>
															<b>Озвучили:</b>
															<a class="btn label label-info" role="button" href="#">Ancord</a>,
															<a class="btn label label-info" role="button" href="#">Fuurou</a>,
															<a class="btn label label-info" role="button" href="#">Nika Lenina</a>,
															<a class="btn label label-info" role="button" href="#">Jade</a>,
														</li>
														<li>
															<b>Перевод:</b>
															<a class="btn label label-info" role="button" href="#">sanyalitvyak</a>,
															<a class="btn label label-info" role="button" href="#">Seiya Loveless,</a>,
															<a class="btn label label-info" role="button" href="#">Evafan</a>,
															<a class="btn label label-info" role="button" href="#">KANSAI</a>,
															<a class="btn label label-info" role="button" href="#">Oni</a>
														</li>
														<li>
															<b>Автор оригинала:</b>
															<a class="btn label label-info" role="button" href="#">Дзюна Мисаки</a>
														</li>
														<li>
															<b>Серии:</b>ТВ (&gt;12 эп.), 25 мин.
														</li>
													</ul>	
												</div>
											</div>
											<div class="col-md-8 clip is-truncated" style="word-wrap: break-word;">
											Последние слова, произнесенные Королем Пиратов перед казнью, вдохновили многих: «Мои сокровища? Коли хотите, забирайте. Ищите – я их все оставил там!». Легендарная фраза Золотого Роджера ознаменовала начало Великой Эры Пиратов – тысячи людей в погоне за своими мечтами отправились на Гранд Лайн, самое опасное место в мире, желая стать обладателями мифических сокровищ...
											Но с каждым годом романтиков становилось все меньше, их постепенно вытесняли прагматичные пираты-разбойники, которым награбленное добро было куда ближе, чем какие-то «никчемные мечты». Но вот... 
											</div>
										</div>
									</div>	
								</div>
								<div class="news-footer panel-footer">
									<div class = "plus-div">
										<div class="plus">
										<!--img src="img/plus.jpg" alt="" class="img-circle"-->
										</div>
									</div>
									<div class="container-fluid nopadding">
										<div class="row-fluid" style="margin-top: -20px;">
											<a href="anime.html" class="btn btn-primary btn-md" role="button">
													<b>Смотреть</b>
													<span class="badge">3</span>
											</a>
											<ul class="nav nav-pills pull-right">
												<li role="presentation" class	>
													<span  class="scan" >
														<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
														<span class="">3</span>
													</span>
												</li>
												<li role="presentation" class>
													<span  class="scan" >
														<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
														<span class="">4</span>
													</span>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<br>
						</div>
						<div class="col-md-3 text-center">
							<div class = "right">
								Rigth
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<footer>
			<p style="color: wheat;">© 2015 Company, Inc.</p>
		</footer>
	</body>
<#include "footer.ftl">