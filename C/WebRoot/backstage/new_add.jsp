<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
           心健新闻-添加
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
         <script src="laydate/laydate.js"></script>
        
        <style type="text/css">
        
        	.site-demo-upbar{
        		border:1px black solid;
        	}
        	
        	.layui-input{
        	height:50px;
        }
        *{margin:0;padding:0;list-style:none;}
		.box{width:970px; padding:10px 20px; background-color:#fff; margin:10px auto;}
		.demo2{margin:25px 0;}
		.layinput{height: 22px;line-height: 22px;width: 150px;margin: 0;}
        </style>   
    </head>
    
    <body>
        <div class="x-body">
            <form id="form" class="layui-form" action="../NewsServlet?method=addNews" method="post" enctype="multipart/form-data">
           <!--   <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>序号
              </label>
                    <div class="layui-input-inline">
                        <input type="text" id="link" name="id" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div> -->
                <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>模块
                    </label>
                    <div class="layui-input-inline">
                        <select lay-verify="required" name="module">
                                <option>
                                </option>
                                <optgroup label="模块">
                                    <option value="心健新闻" selected>心健新闻</option>
                                    <option value="媒体报道">媒体报道</option>
                                    <option value="心理新闻">心理新闻</option>
                                </optgroup>
                            </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>标题
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="link" name="title" required lay-verify="required"
                        autocomplete="off" class="layui-input">
                    </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>发表时间
                    </label>
                    <div class="layui-input-inline">
                    
                        <!-- <input type="text" id="link" name="link" required lay-verify="required"
                        autocomplete="off" class="layui-input"> -->
                        
                        <input placeholder="请输入日期"  id="link" name="createTime" required lay-verify="required"  autocomplete="off" class="layui-input laydate-icon" onClick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" >
                    </div>
                </div>
            
                <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>轮播图
                    </label>
                    <div class="layui-input-inline">
                      <div class="site-demo-upbar">
                        <input type="file" name="img" id="test">
                      </div>
                    </div>
                </div>
                
           <!--    要修改 -->
              <!--   <div class="layui-form-item">
                    <label  class="layui-form-label">图片
                    </label>
                    <img id="" width="400" src="">
                </div> -->
                
                
                <div class="layui-form-item">
                    <label for="desc" class="layui-form-label">
                        <span class="x-red">*</span>文字信息
                    </label>
                    <div class="layui-input-inline">
                        <textarea id="L_content" name="content" placeholder="简介" class="layui-textarea fly-editor" style="height: 260px;"></textarea>
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    
                    <!--  class="layui-btn" lay-filter="add" lay-submit="" -->
                  <button class="layui-btn" onclick="banner_del(this)">增加 </button>
                   
                    
                   <!--  <input  type="submit" value="完成"  > -->
                </div>
            </form>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="./js/x-layui.js" charset="utf-8">
        </script>
       <script type="text/javascript">
       
         /*  function co(data){
            
            layer.confirm("增加成功",function (index) {
                    // 获得frame索引
                    layer.msg('已成功!',{icon:1,time:2000});
                    
                    var index = parent.layer.getFrameIndex(window.name);
                    
                    //关闭当前frame
                    parent.layer.close(index);
                  
                });
            
             $("#form").submit(); 
            
            
                    
            }; */
            
            
             function banner_del(obj){
                layer.confirm('确认增加？',function(index){
                    //发异步删除数据
                   
                    layer.msg('已增加!',{icon:1,time:2000});
                     
                    /* window.location="NewsServlet?method=del&id="+id; */
                     // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                    $("#form").submit();
                });
              
            }
       
       
       
!function(){
laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
laydate({elem: '#demo'});//绑定元素
}();
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});
//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});

            layui.use(['form','layer','upload'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;


              //图片上传接口
              layui.upload({
                url: './upload.json' //上传接口
                ,success: function(res){ //上传成功后的回调
                    console.log(res);
                  $('#LAY_demo_upload').attr('src',res.url);
                }
              });
            
           
              
            });
        </script>
    </body>

</html>