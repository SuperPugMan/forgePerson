
$(function(){	
	

	
/*	 $(".pullDownList").append("<li class=''>"+"<i class='list-icon-2'></i> "
			    +"<a href=''target='_blank'>订单的5555gg</a> "+"<span></span></li>");*/
	


		//var flag=false;
/*
	    $.ajax({
	   
	        url: "ProductCategoryServlet?methon=yiji",  //需要提交的服务器地址（自己写的servlet@WebServlet("/news/*")）
	        type: "post",  //请求的方式
	        //data: {"pageNum": pageNum},  //传递给服务器的参数
	        async: false,
	        success: function (data) {  //回调函数
	          var data=$.parseJSON(data);
	       	                 	         
	            $.each(data, function (i, dom) {
	                //一个dom就是一个用户对象
	               
	            	 $(".pullDownList").append(
	            			 
	            			 "<li name="+dom.id+" class=''>"
	            			 +"<i class='list-icon-2'></i>"	         			    
	            			 +"<a href=''>"+dom.name+"</a>"
	            			 +"<span></span></li>"
	            			 );
	                	               
	            });	            

	        },
	         
	    }); 
	    
*/
 
    
    //=============================
	    
	    

		
		// 导航左侧栏js效果 start
		$(".pullDownList li").hover(function(){
			$(".yMenuListCon").fadeIn();
			var index=$(this).index(".pullDownList li");
			if (!($(this).hasClass("menulihover")||$(this).hasClass("menuliselected"))) {
				
				
				/*var name=$(this).attr("name");
				
				
				alert($name+"====");
				
				
				var flag=false;
				
				
				 $(".yMenuLCinList").html('');
				 
				
				 
		          $(".yMenuListCon").append("" +
		          		"<div class='yMenuListConin'>"
	            			 +"<div class='yMenuLCinList'>"
	            			 +"<h3>"
	            			 +"<a href='' class='yListName'>精品男装</a><a href=''class='yListMore'>更多 ></a>"
	            			 +"</h3>"
	            			 +"<p id='pinjie'><a href='' class='ecolor610'>大牌上新4442</a> <a href=''>商场同款223</a> "
	            			 +"</p>" 
	            			 +"</div> "
	            			 +"</div>");

			    $.ajax({
			    	
			   
			        url: "ProductCategoryServlet?methon=erji",  //需要提交的服务器地址（自己写的servlet@WebServlet("/news/*")）
			        type: "post",  //请求的方式
			        data: {"pageNum": name},  //传递给服务器的参数
			        async: false,
			        success: function (data) {  //回调函数
			          var data=$.parseJSON(data);
	
			            $.each(data, function (i, dom) {
			                //一个dom就是一个用户对象			            	
			            	//做拼接			            	
			            	 $("#pinjie").append("<a href=''>"+dom.name+000+"</a>");			            			            	
			                //"<li class=''>"+"<i class='list-icon-1'></i> "+"<a href='' target='_blank'>"+dom.name+"</a> /"+"<span></span></li>"
			            	
			            });			            

			         
		            
			        },
		      
			    }); 
			    
				*/
			
				
				
				$($(".yBannerList")[index]).css("display","block").siblings().css("display","none");
				
				//通过下标
												
				
				$($(".yBannerList")[index]).removeClass("ybannerExposure");
				setTimeout(function(){
				$($(".yBannerList")[index]).addClass("ybannerExposure");
				},60)
			}else{	
			}
			$(this).addClass("menulihover").siblings().removeClass("menulihover");
				$(this).addClass("menuliselected").siblings().removeClass("menuliselected");
			$($(".yMenuListConin")[index]).fadeIn().siblings().fadeOut();
		},function(){
			
		})
		$(".pullDown").mouseleave(function(){
			$(".yMenuListCon").fadeOut();
			$(".yMenuListConin").fadeOut();
			$(".pullDownList li").removeClass("menulihover");

		})
		// 导航左侧栏js效果  end
		
		
		
	})
	    
	    
	    
	
	
	//异步随时导入样式
 /*  flag = true; 
	          var loadFile;

	          loadFile = setInterval(function() {//定时检测    
	               if(flag) {//如果数据已经处理完毕
	            	   
	            	   //$.getScript('js/index.js');
	              	   loadjscssfile('css/base.css', "css"); //加载你的css文件
	                   loadjscssfile('css/home.css', "css"); //加载你的css文件
	                   loadjscssfile('js/jquery.js', "js"); //加载你的js文件
	                   loadjscssfile('js/index.js', "js"); //加载你的js文件
	                   loadjscssfile(' js/jquery-1.12.4.js', "js"); //加载你的js文件                  
	                   clearTimeout(t);//取消定时检测节省开销
	                   
	               }
	           },50);
	          */

	            
/*
	            //渲染分页  总记录数  当前页码  每页数据量
	              $('#pagination').pagination(data.total, {
	                current_page:pageNum,//当前第几页
	                items_per_page: data.pageSize,
	                callback: load,  //回调函数
	                num_edge_entries: 2,
	                load_first_page: true,
	                prev_show_always:false,
	                next_show_always:false,
	                prevCls:'prev',		//上一页class
	                nextCls:'next',		//下一页class
	                prev_text: '上一页',
	                next_text: '下一页'
	            });  */


  /* error: function (XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
	}
	        */



	    
	    
	    
	    
    
/*    
    $.ajax({
        type: 'GET',
        url: '/Handler/MenuPermissionsASHX.ashx?Func=GetEasyUIMenuList',
        async: false,//同步
        dataType: 'json',
        success: function (json) {
            _menus = eval('(' + json.data + ')');

            $.each(_menus.menus, function (i, n) {
                menulist += "<li>";
                menulist += '<a href="#"> <i class="fa fa fa-bar-chart-o"></i><span class="nav-label">' + n.menuname + '</span><span class="fa arrow"></span></a> ';
                menulist += '<ul class="nav nav-second-level">';
                $.each(n.menus, function (j, o) {

                    menulist += '<li><a class="J_menuItem"  href="' + o.url + '"  title="' + o.menuname + '">' + o.menuname + '</a></li> ';

                })
                menulist += '</ul>';
                menulist += '</li>';
            })

            flag = true;                
            $("#side-menu").html(menulist);

        },
        error: function (xhr, status, error) {
            alert("操作失败"); //xhr.responseText
        }
    });    
 
    var loadFile;

   loadFile = setInterval(function() {//定时检测    
        if(flag) {//如果数据已经处理完毕
            loadjscssfile('static/Bootstrap/css/bootstrap.min.css', "css"); //加载你的css文件
            loadjscssfile('static/jQuery/jquery-2.1.1.js', "js"); //加载你的js文件
            loadjscssfile('static/Bootstrap/js/bootstrap.min.js', "js"); //加载你的js文件
            clearTimeout(t);//取消定时检测节省开销
        }
    },50);

    
    */
//=====================================    
    
 