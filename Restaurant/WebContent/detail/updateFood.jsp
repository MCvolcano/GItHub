﻿
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			
				
					<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 更新新菜品
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="#" id="myform" method="post" enctype="multipart/form-data" onsubmit="return false;">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
                            <select name="cid" style="width:80px">
	                            
			   						<option value="${param.cname }" 
			   							selected="selected"
			   						>${param.cname }</option>
			   						
			   					
                            </select>
                             *<input type="hidden" name="id" value="${param.id }" /></td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="foodName" class="InputStyle" value="${param.name }"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="price" class="InputStyle" value="${param.price }"/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="mprice" class="InputStyle" value="${param.vprice }"/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="introduce" class="TextareaStyle">粤菜白灼虾，大件！</textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								
									<img style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;' 
									src="style/images/baizhuoxia.jpg">
									<input type="hidden" name="image" value="${param.image }">
								
								<input type="file" name="imageUrl"/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
					 <input type="submit" value="修改" class="FunctionButtonInput" onclick="updateClick()">
				
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>

<script type="text/javascript">
	
	function updateClick(){
		$.ajax({
			type:"post",
			url:"/Restaurant/update?method=updateDishes",
			data:$("#myform").serialize(),
			dataType:"json",
			success:function(data){
				
				if (data.code == 0) {
					alert(data.mag);
				} else {
					window.location.href="/Restaurant/detail/foodList.html";	
				}
			}
		});
	}
</script>
</body>
</html>
