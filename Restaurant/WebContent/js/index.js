
function bindData(data){
	$("#tbId").empty();
	var info = data.pageInfo;
	
	$(info).each(function(){
		var html = "<tr class='odd'>";
		html += "<td><input type='checkbox' name='bookId' value='" + this.bid + "' /></td>";
		html += "<td class='title'>" + this.bookName + "</td>";
		html += "<td>￥" + this.b_price + "</td>";
		html += "<td>" + this.stock + "</td>";
		html += "<td class='thumb'><img src='" + this.image + "' /></td>";
		html += "</tr>";
		
		$("#tbId").append($(html));
	});

}