var x = parseInt($('#money').text());
var pwd;
$.ajaxw({
	type: "post",
	url: "/order/defrayOrBuy.action",
	async: false,
	data: "orderMoney=" + x + "&password=" + pwd,
	dataType: "json",
	success: function(data, textStatus, jqXHR) {
		if(data)
			return;
		$.ajaxw({
			type: "post",
			url: "/home/getAccountMoney.action",
			async: false,
			data: "",
			dataType: "json",
			success: function(data, textStatus, jqXHR) {
				$('#money').text(data);
			}
		});
	}
});

$.ajaxw({
	type: "post",
	url: "/home/addAccount.action",
	async: false,
	data: "pwd="+pwd+"&password=" + password,
	dataType: "json",
	success: function(data, textStatus, jqXHR) {
		if(data)
			alert("设置成功");
	}
});