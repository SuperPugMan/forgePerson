<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentelella Alela! |</title>

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
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="../vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="../vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
           <jsp:include   page="PageLeft.jsp" flush="true"/>


			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Form Upload</h3>
						</div>
						<div class="x_panel">
							<div class="x_title">
								<h2>
									Form Design <small>different form elements</small>
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
									action="/forge_CMS/NewsServlet?method=message"
									method="post">

									<div class="form-group">
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="first-name">News	Title <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input type="text" id="first-name" required="required"
												class="form-control col-md-7 col-xs-12"  name="title">
										</div>

										<!-- form date pickers -->
										<div class="x_panel" style="">
											<div class="x_title">
												<h2>
													Date Pickers <small> Available with multiple
														designs</small>
												</h2>
												<ul class="nav navbar-right panel_toolbox">
													<li><a class="collapse-link"><i
															class="fa fa-chevron-up"></i></a></li>
													<li class="dropdown"><a href="#"
														class="dropdown-toggle" data-toggle="dropdown"
														role="button" aria-expanded="false"><i
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
												<div class="row calendar-exibit">
													<div class="col-md-3">
														<fieldset>
															<div class="control-group">
																<div class="controls">
																	<div
																		class="col-md-11 xdisplay_inputx form-group has-feedback">
																		<input type="text"
																			class="form-control has-feedback-left"
																			id="single_cal1" placeholder="First Name"
																			aria-describedby="inputSuccess2Status" name="datetime"> <span
																			class="fa fa-calendar-o form-control-feedback left"
																			aria-hidden="true"></span> <span
																			id="inputSuccess2Status" class="sr-only">(success)</span>
																	</div>
																</div>
															</div>
														</fieldset>
													</div>
												</div>

											</div>
										</div>
										<!-- /form datepicker -->
									</div>
									<div class="col-md-12 col-sm-12 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>
													Text areas<small>Sessions</small>
												</h2>
												<ul class="nav navbar-right panel_toolbox">
													<li><a class="collapse-link"><i
															class="fa fa-chevron-up"></i></a></li>
													<li class="dropdown"><a href="#"
														class="dropdown-toggle" data-toggle="dropdown"
														role="button" aria-expanded="false"><i
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
												<div id="alerts"></div>
												<div class="btn-toolbar editor" data-role="editor-toolbar"
													data-target="#editor-one">
													<div class="btn-group">
														<a class="btn dropdown-toggle" data-toggle="dropdown"
															title="Font"><i class="fa fa-font"></i><b
															class="caret"></b></a>
														<ul class="dropdown-menu">
														</ul>
													</div>

													<div class="btn-group">
														<a class="btn dropdown-toggle" data-toggle="dropdown"
															title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b
															class="caret"></b></a>
														<ul class="dropdown-menu">
															<li><a data-edit="fontSize 5">
																	<p style="font-size:17px">Huge</p>
															</a></li>
															<li><a data-edit="fontSize 3">
																	<p style="font-size:14px">Normal</p>
															</a></li>
															<li><a data-edit="fontSize 1">
																	<p style="font-size:11px">Small</p>
															</a></li>
														</ul>
													</div>

													<div class="btn-group">
														<a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i
															class="fa fa-bold"></i></a> <a class="btn" data-edit="italic"
															title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
														<a class="btn" data-edit="strikethrough"
															title="Strikethrough"><i class="fa fa-strikethrough"></i></a>
														<a class="btn" data-edit="underline"
															title="Underline (Ctrl/Cmd+U)"><i
															class="fa fa-underline"></i></a>
													</div>

													<div class="btn-group">
														<a class="btn" data-edit="insertunorderedlist"
															title="Bullet list"><i class="fa fa-list-ul"></i></a> <a
															class="btn" data-edit="insertorderedlist"
															title="Number list"><i class="fa fa-list-ol"></i></a> <a
															class="btn" data-edit="outdent"
															title="Reduce indent (Shift+Tab)"><i
															class="fa fa-dedent"></i></a> <a class="btn"
															data-edit="indent" title="Indent (Tab)"><i
															class="fa fa-indent"></i></a>
													</div>

													<div class="btn-group">
														<a class="btn" data-edit="justifyleft"
															title="Align Left (Ctrl/Cmd+L)"><i
															class="fa fa-align-left"></i></a> <a class="btn"
															data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i
															class="fa fa-align-center"></i></a> <a class="btn"
															data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i
															class="fa fa-align-right"></i></a> <a class="btn"
															data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i
															class="fa fa-align-justify"></i></a>
													</div>

													<div class="btn-group">
														<a class="btn dropdown-toggle" data-toggle="dropdown"
															title="Hyperlink"><i class="fa fa-link"></i></a>
														<div class="dropdown-menu input-append">
															<input class="span2" placeholder="URL" type="text"
																data-edit="createLink" />
															<button class="btn" type="button">Add</button>
														</div>
														<a class="btn" data-edit="unlink" title="Remove Hyperlink"><i
															class="fa fa-cut"></i></a>
													</div>

													<div class="btn-group">
														<a class="btn"
															title="Insert picture (or just drag & drop)"
															id="pictureBtn"><i class="fa fa-picture-o"></i></a> <input
															type="file" data-role="magic-overlay"
															data-target="#pictureBtn" data-edit="insertImage" />
													</div>

													<div class="btn-group">
														<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i
															class="fa fa-undo"></i></a> <a class="btn" data-edit="redo"
															title="Redo (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
													</div>
												</div>
												<div id="editor-one" class="editor-wrapper" ></div>
												<textarea name="descr" id="descr" style="display:block;" ></textarea>
												<br />
												<div class="ln_solid"></div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Resizable
														Text area</label>
													<div class="col-md-9 col-sm-9 col-xs-12">
														<textarea class="resizable_textarea form-control"
															placeholder="This text area automatically resizes its height as you fill in more text courtesy of autosize-master it out..."></textarea>
													</div>
												</div>
											</div>
										</div>
									</div>
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
						
					

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Dropzone multiple file uploader</h2>
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
									<p>Drag multiple files to the box below for multi upload or
										click to select files. This is for demonstration purposes
										only, the files are not uploaded to any server.</p>
									<form action="/forge_CMS/NewsServlet?method=upload" class="dropzone" enctype="multipart/form-data" method="post"></form>
									<br /> <br /> <br /> <br />

									
								</div>


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

	<!-- jQuery -->
	<script src="../vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
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
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="../vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="../vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="../vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="../vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="../vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="../vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="../vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="../vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="../vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
</body>
</html>