<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>

<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">



<link href='css/uniform.default.css' rel='stylesheet'>
<link href='css/colorbox.css' rel='stylesheet'>
<link href='css/jquery.cleditor.css' rel='stylesheet'>
<link href='css/jquery.noty.css' rel='stylesheet'>
<link href='css/noty_theme_default.css' rel='stylesheet'>
<link href='css/elfinder.min.css' rel='stylesheet'>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Dropzone.js -->
<link href="../vendors/dropzone/dist/min/dropzone.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link href="../vendors/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link href="../vendors/select2/dist/css/select2.min.css"
	rel="stylesheet">
<!-- Switchery -->
<link href="../vendors/switchery/dist/switchery.min.css"
	rel="stylesheet">
<!-- starrr -->
<link href="../vendors/starrr/dist/starrr.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="../vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">
<style type="text/css">
#newsDate {
	transform: translate(-12.5px, 3px);
}

#newscontent {
	transform: translate(310px, -40px);
}

#newscontenttext {
	transform: translate(230px, -20px);
}

#newsimage {
	transform: translate(305px, -40px);
}

#newsimagetext {
	transform: translate(245px, -20px);
}
</style>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<jsp:include page="PageLeft.jsp" flush="true" />
					<!-- page content -->
					<div class="right_col" role="main">
						<div class="">
							<div class="page-title">
								<div class="title_left">
									<h3>欢迎新闻新增</h3>
								</div>
								<div class="x_panel">
									<div class="x_title">
										<h2>
											新增新闻 <small>请新增一条新闻</small>
										</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
											<li class="dropdown"><a href="#" class="dropdown-toggle"
												data-toggle="dropdown" role="button" aria-expanded="false"><i
													class="fa fa-wrench"></i></a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Settings 1</a></li>
													<li><a href="#">Settings 2</a></li>
												</ul></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<br />
										<form id="demo-form2" data-parsley-validate
											class="form-horizontal form-label-left"
											action="/forge_CMS/news?method=message" method="post"
											enctype="multipart/form-data">

											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12"
													for="first-name">请输入新增新闻标题 <span class="required">*</span>
												</label>
												<div class="col-md-6 col-sm-6 col-xs-12">
													<input type="text" id="first-name" required="required"
														class="form-control col-md-7 col-xs-12" name="title">
												</div>
												<!-- form date pickers -->
												<div class="x_content">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="first-name">请输入新增新闻日期 <span class="required">*</span>
													</label>
													<div class="row calendar-exibit">
														<div class="col-md-3">
															<fieldset>
																<div class="control-group">
																	<div class="control-group">
																		<div class="controls">
																			<input type="text" class="input-xlarge datepicker"
																				name="createTime" id="date01" value="04/24/18">
																		</div>
																	</div>
																</div>
															</fieldset>
														</div>
													</div>
												</div>
												<!-- /form datepicker -->
											</div>
											<!-- 富文本编辑器 -->
											<label class="control-label" for="textarea2"
												id="newscontenttext">新闻内容 <span>*</span></label>
											<div class="control-group">
												<div class="controls" id="newscontent">
													<textarea class="cleditor" id="textarea2" rows="3"
														name="content"></textarea>
												</div>
											</div>
											<!-- 富文本编辑器结束 -->
											<!-- 文件上传开始 -->
											<div class="control-group">
												<label class="control-label" id="newsimagetext">新闻图片<span>*</span></label>
												<div class="controls" id="newsimage">
													<input name="img" type="file">
												</div>
											</div>
											<!-- 文件上传结束 -->
											<div class="form-group">
												<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
													<button class="btn btn-primary" type="button">Cancel</button>
													<button class="btn btn-primary" type="reset">Reset</button>
													<button type="submit" class="btn btn-success">Submit</button>
												</div>
											</div>
											<div class="ln_solid"></div>

										</form>
									</div>
								</div>
								<div class="title_right">
									<div
										class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									</div>
								</div>
							</div>




						</div>
					</div>
					<!-- /page content -->

					<!-- footer content -->
					<footer>
						<div class="pull-right">
							Gentelella - Bootstrap Admin Template by <a
								href="https://colorlib.com">Colorlib</a>
						</div>
						<div class="clearfix"></div>
					</footer>
					<!-- /footer content -->
				</div>
			</div>


			<!-- FastClick -->
			<script src="../vendors/fastclick/lib/fastclick.js"></script>
			<!-- NProgress -->
			<script src="../vendors/nprogress/nprogress.js"></script>
			<!-- Dropzone.js -->
			<script src="../vendors/dropzone/dist/min/dropzone.min.js"></script>

			<!-- Custom Theme Scripts -->
			<script src="../build/js/custom.min.js"></script>
			<!-- jQuery -->
			<script src="../vendors/jquery/dist/jquery.min.js"></script>
			<!-- Bootstrap -->
			<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
			<!-- FastClick -->
			<script src="../vendors/fastclick/lib/fastclick.js"></script>
			<!-- NProgress -->
			<script src="../vendors/nprogress/nprogress.js"></script>
			<!-- bootstrap-progressbar -->
			<script
				src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
			<!-- iCheck -->
			<script src="../vendors/iCheck/icheck.min.js"></script>
			<!-- bootstrap-daterangepicker -->
			<script src="../vendors/moment/min/moment.min.js"></script>
			<script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
			<!-- bootstrap-wysiwyg -->
			<script
				src="../vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
			<script src="../vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
			<script src="../vendors/google-code-prettify/src/prettify.js"></script>
			<!-- jQuery Tags Input -->
			<script src="../vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
			<!-- Switchery -->
			<script src="../vendors/switchery/dist/switchery.min.js"></script>

			<!-- Parsley -->
			<script src="../vendors/parsleyjs/dist/parsley.min.js"></script>
			<!-- Autosize -->
			<script src="../vendors/autosize/dist/autosize.min.js"></script>
			<!-- jQuery autocomplete -->
			<script
				src="../vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
			<!-- starrr -->
			<script src="../vendors/starrr/dist/starrr.js"></script>
			<!-- Custom Theme Scripts -->
			<script src="../build/js/custom.min.js"></script>






			<!-- jQuery -->
			<script src="js/jquery-1.7.2.min.js"></script>
			<!-- jQuery UI -->
			<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
			<!-- transition / effect library -->
			<script src="js/bootstrap-transition.js"></script>
			<!-- alert enhancer library -->
			<script src="js/bootstrap-alert.js"></script>
			<!-- modal / dialog library -->
			<script src="js/bootstrap-modal.js"></script>
			<!-- custom dropdown library -->
			<script src="js/bootstrap-dropdown.js"></script>
			<!-- scrolspy library -->
			<script src="js/bootstrap-scrollspy.js"></script>
			<!-- library for creating tabs -->
			<script src="js/bootstrap-tab.js"></script>
			<!-- library for advanced tooltip -->
			<script src="js/bootstrap-tooltip.js"></script>
			<!-- popover effect library -->
			<script src="js/bootstrap-popover.js"></script>



			<!-- autocomplete library -->
			<script src="js/bootstrap-typeahead.js"></script>
			<!-- tour library -->
			<script src="js/bootstrap-tour.js"></script>
			<!-- library for cookie management -->
			<script src="js/jquery.cookie.js"></script>
			<!-- calander plugin -->
			<script src='js/fullcalendar.min.js'></script>
			<!-- data table plugin -->
			<script src='js/jquery.dataTables.min.js'></script>
			<!-- select or dropdown enhancer -->
			<script src="js/jquery.chosen.min.js"></script>
			<!-- checkbox, radio, and file input styler -->
			<script src="js/jquery.uniform.min.js"></script>
			<!-- plugin for gallery image view -->
			<script src="js/jquery.colorbox.min.js"></script>
			<!-- rich text editor library -->
			<script src="js/jquery.cleditor.min.js"></script>
			<!-- notification plugin -->
			<script src="js/jquery.noty.js"></script>
			<!-- file manager library -->
			<script src="js/jquery.elfinder.min.js"></script>
			<!-- star rating plugin -->
			<script src="js/jquery.raty.min.js"></script>
			<!-- for iOS style toggle switch -->
			<script src="js/jquery.iphone.toggle.js"></script>
			<!-- autogrowing textarea plugin -->
			<script src="js/jquery.autogrow-textarea.js"></script>
			<!-- multiple file upload plugin -->
			<script src="js/jquery.uploadify-3.1.min.js"></script>
			<!-- history.js for cross-browser state change on ajax -->
			<script src="js/jquery.history.js"></script>
			<!-- application script for Charisma demo -->
			<script src="js/charisma.js"></script>
</body>
</html>