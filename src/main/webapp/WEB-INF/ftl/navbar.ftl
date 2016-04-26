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
				<#if user.getUsername()?? >
					<div style = "color:white" >${user!"nulll"}</div>
					<a class="btn" href="logout" role="button" style = "text-align:left;color: white;">
						<b>Выйти</b>
					</a>
				<#else>
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
				</#if>
			</div>
		</nav>