		<#--nav class="navbar navbar-inverse navbar-fixed-top">
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
				<div class="col-md-10 text-right">
					<div class = "row">
						<span style = "color:white" >${user.getUsername()!""}</span>
						<a class="btn btn-success" href="logout" role="button">
							<b>Выйти</b>
						</a>
					</div>
				</div>
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
				</div>
				</#if>
			</div>
		</nav-->

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<!-- span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span-->
					</button>
					<a class="navbar-brand" href="#">AnimeGitHub</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="#">Новинки 
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li>
						<a href="#">Форум</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Помощь
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
					 	<li>
					 		<a href="#">Action</a>
					 	</li>
					 	<li>
					 		<a href="#">Another action</a>
					 	</li>
					 	<li>
					 		<a href="#">Something else here</a>
					 	</li>
					 	<li role="separator" class="divider"></li>
					 	<li>
					 		<a href="#">Separated link</a>
					 	</li>
					 	<li role="separator" class="divider"></li>
					 	<li>
					 		<a href="#">One more separated link</a>
					 	</li>
					 	</ul>
					  </li>
					</ul>
				  <form class="navbar-form navbar-left" role="search">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="Поиск">
			        </div>
			        <button type="submit" class="btn btn-default">Поиск</button>
			      </form>
				  <ul class="nav navbar-nav navbar-right">
				  	  <#if !user.getUsername()?? >	 	
	                  <li id = "auth" class="dropdown">
	                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Авторизоваться<b class="caret"></b></a>
	                     <ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
	                        <li>
	                           <div class="row-fluid">
	                              <div class="col-md-*">
	                                 <form class="form" role="form" method="post" action="authentication" accept-charset="UTF-8">
	                                    <div class="form-group">
	                                       <label class="sr-only" for="exampleInputEmail2">Email address</label>
	                                       <input type="text" name = "login" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
	                                    </div>
	                                    <div class="form-group">
	                                       <label class="sr-only" for="exampleInputPassword2">Password</label>
	                                       <input type="password" name = "password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
	                                    </div>
	                                    <div class="checkbox center">
	                                       <label>
	                                       		<input type="checkbox">Запомнить
	                                       </label>
	                                    </div>
	                                    <input type="hidden" name="${_csrf.parameterName!""}" 	value="${_csrf.token!""}" />
	                                    <div class="form-group">
	                                       <button type="submit" class="btn btn-success btn-block">Войти</button>
	                                    </div>
	                                 </form>
	                                 <form>
	                                 	<a href="#" class="registr">Регистрация</a>
	                                 </form>
	                                 <form class = "form_registr" role="form" action="registr" accept-charset="UTF-8" style="display:none">
	                                    <div class="form-group">
	                                       <label class="sr-only" for="inputEmail">Email address</label>
	                                       <input type="text" class="form-control" id="inputEmail" placeholder="Адресс почты" required>
	                                    </div>
	                                    <div class="form-group">
	                                       <label class="sr-only" for="inputLogin">User name</label>
	                                       <input type="text" class="form-control" id="inputLogin" placeholder="Имя" required>
	                                    </div>
	                                    <div class="form-group">
	                                       <label class="sr-only" for="inputPassword">Password</label>
	                                       <input type="password" class="form-control" id="inputPassword" placeholder="Пароль" required>
	                                    </div>
	                                    <div class="form-group">
	                                       <label class="sr-only" for="inputPassword2">Password2</label>
	                                       <input type="password" class="form-control" id="inputPassword2" placeholder="Повторите пароль" required>
	                                    </div>
	                                    <div class="form-group">
	                                       <button type="submit" class="btn btn-success btn-block">Зарегистрировать</button>
	                                    </div>
	                                 </form>
	                              </div>
	                           </div>
	                        </li>
	                        <li class="divider"></li>
	                        <a href="#" class="">Забыли пароль ?</a>
	                     </ul>
	                 </li>
	                 <#else>
	                 <li id = "user_auth" class="dropdown">
                    	 <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.getUsername()!""}<b class="caret"></b></a>
                     <ul class="dropdown-menu" style="padding: 15px;min-width: 300px;">
                        <li>
                           <div class="row-fluid">
                              <div class="col-md-*">
                                 <form class="form" role="form" action="logout" accept-charset="UTF-8">
          							<div class="panel panel-info">
            							<div class="panel-heading">
              								<h3 class="panel-title">Sheena Kristin A.Eschor</h3>
            							</div>
            						<div class="panel-body">
            						<div class="row-fluid">
                						<div class="col-md-3 col-lg-6 col-centered"> 
                							<img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle center-block img-responsive">
                						</div>
                					 </div>
              							<div class="row-fluid">
                							<div class=" col-md-9 col-lg-9 nopadding"> 
								                	<table class="table table-user-information">
									                    <tbody>
									                      <tr>
									                        <td>Department:</td>
									                        <td>Programming</td>
									                      </tr>
									                      <tr>
									                        <td>Hire date:</td>
									                        <td>06/23/2013</td>
									                      </tr>
									                      <tr>
									                        <td>Date of Birth</td>
									                        <td>01/24/1988</td>
									                      </tr>
									                        <tr>
									                        <tr>
									                        <td>Gender</td>
									                        <td>Male</td>
									                      </tr>
									                        <tr>
									                        <td>Home Address</td>
									                        <td>Metro Manila,Philippines</td>
									                      </tr>
									                      <tr>
									                        <td>Email</td>
									                        <td><a href="mailto:info@support.com">info@support.com</a></td>
									                      </tr>
									                        <td>Phone Number</td>
									                        <td>123-4567-890(Landline)<br><br>555-4567-890(Mobile)
									                        </td>
									                      </tr>
									                    </tbody>
								                	</table>
                								</div>
              								</div>
            							</div>
						                <div class="panel-footer">
						               		<button type="submit" class="btn btn-success">Выйти</button>
						                    <span class="pull-right">
						                       	<a href="user" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
						                        <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
						                    </span>
						                </div>
          							</div>
                                 </form>
                              </div>
                           </div>
                        </li>
                     </ul>
                  </li>
                  </#if>
               	</ul>
			</div>
		</nav>