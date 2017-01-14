function validateNameisHave(){
	var username=$("#zcname").val();
	if(username=="")
		return;
	$.ajax({
		
	    type:"post",
		url: "/tourism/home/getUserByName.action",
		dataType:"json",
		data:"username="+username,
		success: function(data, textStatus, jqXHR){
		    if(data){
//		    	alert("该用户名已被使用");
		    	$("#zcname").val("");
		    	$("#zcname").addClass("invalid");
		    	$("#zcname").attr("placeholder","该用户名 '"+username+"' 已被使用");
		    }
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {

		}
		
	});
	
}