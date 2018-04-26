/*
 * 自己增加的js
 * */

  /*单击登录，滑块弹出*/
  $(document).ready(function () {
	  $("#aa").click(function () {
		  if($("#login").valid()){
			  $("#slider_block").css("display","block");
		  }      
	 });
});