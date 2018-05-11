
<!-- 这个是修改新闻内容的页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>心健新闻231-编辑</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="backstage/css/x-admin.css" media="all">

</head>

<body>
	<div class="x-body">
	
	
						<%-- <%
                         StringBuffer img=new StringBuffer() ;
                          %>
	 --%>
	
		<form action="NewsServlet?method=updateNews" class="layui-form"  method="post" enctype="multipart/form-data">
			
			<div class="layui-form-item">	
	    		<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>序号 </label>
				<div class="layui-input-inline">						
					<input type="text" id="link" name="id" required
						lay-verify="required" autocomplete="off" class="layui-input" readonly value="${requestScope.news.id}">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>模块 </label>
				<div class="layui-input-inline">
					<select lay-verify="required" name="module" >
						<option></option>
						<optgroup label="模块">
							<option value="心健新闻" selected >心健新闻</option>
							<option value="媒体报道">媒体报道</option>
							<option value="心理新闻">心理新闻</option>
						</optgroup>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>标题 </label>
				<div class="layui-input-inline">
					<input type="text" id="link" name="title" required
						lay-verify="required" autocomplete="off" class="layui-input" value="${requestScope.news.title}">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>发表时间 </label>
				<div class="layui-input-inline">
				
				<input value="${requestScope.news.createTime}" placeholder="请输入日期" name="createTime" class="layui-input laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" >
					<!-- input type="text" id="link" name="link" required
						lay-verify="required" autocomplete="off" class="layui-input"> -->
				</div>
			</div>

			<div class="layui-form-item">
				<label for="link" class="layui-form-label"> <span
					class="x-red">*</span>图片</label>
				<div class="layui-input-inline">
					<div class="site-demo-upbar">
						<!-- <input type="file" name="file" class="layui-upload-file" id="test"> -->
						
						
						  <input name="file" type="file" class="opt_input"  onchange="showPreview(this)" />   
						  
						  
					</div>
				</div>
			</div>
			<div class="layui-form-item">
			
			
				<label class="layui-form-label">图片 </label> 
				
			
                         
                         <c:if test="${not empty requestScope.news.img}">
                         
                          <%--  <c:set var="num" value="${requestScope.news.img}" scope="request"></c:set> --%>
                           
                         <%-- 	<%                        	
                    		img=(String)request.getAttribute("num");                   		
  							 request.removeAttribute("num");
                   			img=img.substring(img.lastIndexOf("\\")+1,img.length());
                   			 %> --%>
                   			  <img id="portrait" src="upload/${requestScope.news.img}" alt="无图" width="56" height="56">
                         </c:if>
                         <c:if test="${empty requestScope.news.img}">
                         <c:set var="num" value="not" scope="request"></c:set>
                         		<img id="portrait" src="" alt="无图" width="56" height="56">
                         </c:if>

				
				
			<div class="layui-form-item">
				<label for="desc" class="layui-form-label"> <span
					class="x-red">*</span>文字信息 </label>
				<div class="layui-input-inline">
					<textarea id="L_content" name="content" placeholder="简介"
						class="layui-textarea fly-editor" style="height: 260px;">${news.content}</textarea>
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				
				<input type="submit" value="完成">
				<!-- <input type="submit" class="layui-btn" lay-filter="add" lay-submit="">完成</button> -->
			</div>
		</form>
	</div>
	<script src="backstage/lib/layui/layui.js" charset="utf-8">
		
	</script>
	<script src="backstage/js/x-layui.js" charset="utf-8">
		
	</script>
	
	<script src="backstage/laydate/laydate.js"></script>


<script type="text/javascript">


		function showPreview(source) {

			var file = source.files[0];

			if (window.FileReader) {

				var fr = new FileReader();

				console.log(fr);

				var portrait = document.getElementById('portrait');

				fr.onloadend = function(e) {

					portrait.src = e.target.result;

				};

				fr.readAsDataURL(file);

				portrait.style.display = 'block';

			}

		}
	</script>





<script type="text/javascript">
	!function() {
		laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
		laydate({
			elem : '#demo'
		});//绑定元素
	}();
	//日期范围限制
	var start = {
		elem : '#start',
		format : 'YYYY-MM-DD',
		min : laydate.now(), //设定最小日期为当前日期
		max : '2099-06-16', //最大日期
		istime : true,
		istoday : false,
		choose : function(datas) {
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var end = {
		elem : '#end',
		format : 'YYYY-MM-DD',
		min : laydate.now(),
		max : '2099-06-16',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas; //结束日选好后，充值开始日的最大日期
		}
	};
	laydate(start);
	laydate(end);
	//自定义日期格式
	laydate({
		elem : '#test1',
		format : 'YYYY年MM月DD日',
		festival : true, //显示节日
		choose : function(datas) { //选择日期完毕的回调
			alert('得到：' + datas);
		}
	});
	//日期范围限定在昨天到明天
	laydate({
		elem : '#hello3',
		min : laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
		max : laydate.now(+1)
	//+1代表明天，+2代表后天，以此类推
	});
</script>

	
	
	
	
	<script>
		layui.use([ 'form', 'layer', 'upload' ], function() {
			$ = layui.jquery;
			var form = layui.form(), layer = layui.layer;

			//图片上传接口
			layui.upload({
				url : './upload.json' //上传接口
				,
				success : function(res) { //上传成功后的回调
					console.log(res);
					$('#LAY_demo_upload').attr('src', res.url);
				}
			});

			//监听提交
			form.on('submit(add)', function(data) {
				console.log(data);
				//发异步，把数据提交给php
				layer.alert("增加成功", {
					icon : 6
				}, function() {
					// 获得frame索引
					var index = parent.layer.getFrameIndex(window.name);
					//关闭当前frame
					parent.layer.close(index);
				});
				return false;
			});

		});
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>

</html>