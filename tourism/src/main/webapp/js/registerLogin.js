function validateNameisHave(){
	var username=$("#zcname").val();
	if(username=="")
		return;
	$.ajax({
	    type:"post",
		url: getRootPath("/home/getUserByName.action"),
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

			alert(XMLHttpRequest.responseText);
		}
		
	});
	
}
function reg(){
	var username=$("#zcname").val();
	var password=$("#password-zc").val();
	var email=$("#email").val();
	var code=$("#code").val();
	if(username=="")
		return;
	$.ajax({
	    type:"post",
		url: getRootPath("/home/registerUser.action"),
		dataType:"json",
		data:"username="+username+"&password="+password+"&email="+email+"&code="+code,
		success: function(data, textStatus, jqXHR){
		    if(data==2){
		    	$("#code").val("");
		    	$("#code").addClass("invalid");
		    	$("#code").attr("placeholder","验证码错误");
		    }else if(data==1)
		    	alert('注册成功,请查收邮件，激活用户');
		    else if(data==0)
		    	alert('注册失败');
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {

			alert(XMLHttpRequest.responseText);
		}
		
	});
	
}
function changeCode(){
	var src=$("#imgCode").attr("src")+"?date="+new Date().getTime();
	$("#imgCode").attr("src",src);
}
