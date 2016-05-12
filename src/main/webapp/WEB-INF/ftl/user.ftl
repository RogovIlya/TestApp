<#include "header.ftl">
<#include "macros.ftl">
	<body>
		<#include "navbar.ftl">
		<@banner text="fsfasf"/>
		<div class="container-fluid nopadding">
			<!-- Example row of columns -->
			<div class="row-fluid">
				<div class="col-lg-* main_body">
					<div class="row-fluid">
						<!-- div class="col-md-3 text-center">
							<div class = "left">
								Left
							</div>
						</div-->
						<div class="col-md-* text-left nopadding">
							<div class = "panel panel-default">
								<div class="panel-heading" >
									<h3>Редактирование профиля</h3>
								</div>
								<div class="panel-body">
									<div class="container-fluid">
										<div class="row-fluid">
									        <!-- left column -->
									        <div class="col-md-3">
									            <div class="text-center">
									                <img src="//placehold.it/100" class="avatar img-circle img-responsive" alt="avatar" style="display: inline;">
									                 <h6>Upload a different photo...</h6>
									                <input type="file" class="form-control">
									            </div>
									        </div>
									        <!-- edit form column -->
									        <div class="col-md-9 personal-info">
									            <div class="alert alert-info alert-dismissable"> <a class="panel-close close" data-dismiss="alert">×</a>  <i class="fa fa-coffee"></i>
									This
									                is an <strong>.alert</strong>. Use this to show important messages to the
									                user.</div>
									             <h3>Personal info</h3>
												 <form class="form-horizontal" role="form">
										            <div class="form-group">
										                <label label-default="" class="col-lg-3 control-label">First name:</label>
										                <div class="col-lg-8">
										                    <input class="form-control" type="text" value="Jane">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-lg-3 control-label">Last name:</label>
										                <div class="col-lg-8">
										                    <input class="form-control" type="text" value="Bishop">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-lg-3 control-label">Company:</label>
										                <div class="col-lg-8">
										                    <input class="form-control" type="text" value="">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-lg-3 control-label">Email:</label>
										                <div class="col-lg-8">
										                    <input class="form-control" type="text" value="janesemail@gmail.com">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-lg-3 control-label">Time Zone:</label>
										                <div class="col-lg-8">
										                    <div class="ui-select">
										                        <select id="user_time_zone" class="form-control">
										                            <option value="Hawaii">(GMT-10:00) Hawaii</option>
										                            <option value="Alaska">(GMT-09:00) Alaska</option>
										                            <option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)</option>
										                            <option value="Arizona">(GMT-07:00) Arizona</option>
										                            <option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)</option>
										                            <option value="Central Time (US &amp; Canada)"
										                            selected="selected">(GMT-06:00) Central Time (US &amp; Canada)</option>
										                            <option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)</option>
										                            <option value="Indiana (East)">(GMT-05:00) Indiana (East)</option>
										                        </select>
										                    </div>
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-md-3 control-label">Username:</label>
										                <div class="col-md-8">
										                    <input class="form-control" type="text" value="janeuser">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-md-3 control-label">Password:</label>
										                <div class="col-md-8">
										                    <input class="form-control" type="password" value="11111122333">
										                </div>
										            </div>
										            <div class="form-group">
										                <label label-default="" class="col-md-3 control-label">Confirm password:</label>
										                <div class="col-md-8">
										                    <input class="form-control" type="password" value="11111122333">
										                </div>
										            </div>
										         </form>
									        </div>
									    </div>
									</div>	
								</div>
								<div class="panel-footer">
									<div class="container-fluid nopadding">
										<div class="row-fluid text-right">
									       	<input type="button" class="btn btn-primary" value="Сохранить"> <span></span>
									        <input type="reset" class="btn btn-default" value="Отмена">
										</div>
									</div>
								</div>
							</div>
							<br>
						</div>
						<!-- div class="col-md-3 text-center">
							<div class = "right">
								Rigth
							</div>
						</div-->
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