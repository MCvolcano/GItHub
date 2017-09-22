
//针对所有的ajax请求的设置
//第一个参数是XMLHttpRequest 对象
//第二个参数textStatus 响应状态的文本表示
$.ajaxSetup({
		
	complete : function(xhr, textStatus){
		 //从http头信息取出 在filter定义的sessionstatus，判断是否是 timeout
	    if(xhr.getResponseHeader("sessionstatus")=="timeout"){ 
	        //从http头信息取出登录的url ＝ loginPath
	        if(xhr.getResponseHeader("loginPath")){
	            //alert("会话过期，请重新登陆!");
	            //打会到登录页面
	            window.location.replace(xhr.getResponseHeader("loginPath"));  
	        }
	    }
	}
});

function pagenation(data) {
	$(".page-spliter").empty();
	
	var perivousPage = data.currentPage == 1 ? 1 : data.currentPage - 1;
	var nextPage = data.currentPage == data.totalPage ? data.totalPage : data.currentPage + 1;
	
	var html = "<span>&lt;</span>";
	html += "<a href='javascript:loadData(1)'>首页</a>";
	
	html += "<a href='javascript:loadData(" + perivousPage + ")'>上一页</a>";
	
	for (var i = 1; i <= data.totalPage; i++){
		if(i == data.currentPage) {
			html += "<span class='current'>" + i + "</span>";
			
		} else {
			html += "<a href='javascript:loadData(" + i + ")'>" + i + "</a>";
		}
	}
	
	html += "<a href='javascript:loadData(" + nextPage + ")'>下一页</a>";
	
	html += "<a href='javascript:loadData(" + data.totalPage + ")'>尾页</a>";
	html += "<sapn>&gt</span>";
	$(".page-spliter").append($(html));
}

	