function getPojoForAjax(uri, param, pojo, responseFun, successFun, errorFun) {
	$.ajaxw({
		type: "post",
		url: uri,
		async: false,
		data: param,
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
			if(!data)
			   return;
			var vo = responseFun(data, textStatus, jqXHR);
			if(successFun)
				successFun(vo, textStatus, jqXHR);
		},
		error: errorFun
	});

}
(function($) {
	$.ajaxw = function(ajaxJson) {

		$.ajax({
			type: ajaxJson.type,
			url: getRootPath(ajaxJson.url),
			async: ajaxJson.async,
			data: ajaxJson.data,
			dataType: ajaxJson.dataType,
			beforeSend: function() {
				$.fn.jqLoading({ height: 100, width: 240 });
			},
			complete: function(data) {
				$.fn.jqLoading("destroy");
			},
			success: function(data, textStatus, jqXHR) {
				if(jqXHR.status == 253) {
					top.location.href = getRootPath("/");
					return;
				}
				if(ajaxJson.success)
					ajaxJson.success(data, textStatus, jqXHR);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				if(XMLHttpRequest.status == 405) {
					globalEroor(XMLHttpRequest, textStatus, errorThrown);
					return;
				}
				if(ajaxJson.error)
					ajaxJson.error(XMLHttpRequest, textStatus, errorThrown);
				else
					globalEroor(XMLHttpRequest, textStatus, errorThrown);
			}
		});

	}
})(jQuery);

function globalEroor(XMLHttpRequest, textStatus, errorThrown) {
	$("body").append("<input type='hidden' id='top_msg_error'></input>")

	$("#top_msg_error").manhua_msgTips({
		Event: "onblur", //响应的事件
		timeOut: 2200, //提示层显示的时间
		msg: "状态码：" + XMLHttpRequest.status + ";响应信息：" + XMLHttpRequest.responseText, //显示的消息
		speed: 300, //滑动速度
		type: "error" //提示类型（1、success 2、error 3、warning）
	});
	$("#top_msg_error").trigger('onblur');

	$("#top_msg_error").off();
	$("body").remove("#top_msg_error");
}
/*单一城市集合*/
function getPojo(uri, param, pojo, successFun, errorFun) {

	getPojoForAjax(uri, param, pojo, function(data, textStatus, jqXHR) {
		var jsonString = JSON.stringify(data);
		data = JSON.parse(jsonString);
		var vo;
		if(data.length || data.result && data.result.length)
			vo = JsonPojo.prototype.parseArray(jsonString, pojo);
		else
			vo = JsonPojo.prototype.parseObject(jsonString, pojo);
		return vo;
	}, successFun, errorFun);

}

/*分组  省集合*/
function getGroupPojo(uri, param, pojo, successFun, errorFun) {

	getPojoForAjax(uri, param, pojo, function(data, textStatus, jqXHR) {
		var jsonString = JSON.stringify(data);
		data = JSON.parse(jsonString);
		var vo = new GroupPojo();
		var arr = data.groupItems;
		for(var i = 0; i < arr.length; i++) {
			var key = arr[i].key;
			var items = arr[i].items;
			var page = items.page;
			var result = JsonPojo.prototype.parseArray(JSON.stringify(items), pojo);
			vo.push(key, result, page);
		}
		return vo;
	}, successFun, errorFun);

}
/*解析对象*/
function JsonPojo() {}
JsonPojo.prototype.parseObject = function(jsonString, object) {
	var json = JSON.parse(jsonString);
	return object.__proto__.create(object, json);
};
JsonPojo.prototype.parseArray = function(jsonString, object) {
	var list = new Array();
	var json = JSON.parse(jsonString);
	var array = json;
	if(json.page) {
		var array = json.result;
		var page = new Page(json.page);
	}

	for(var i = 0; i < array.length; i++) {
		var obj = object.__proto__.create(object, array[i]);
		if(page)
			obj.__proto__.setPage(page);
		list.push(obj);
	}
	return list;
};

/*分组对象*/

function GroupPojo() {
	this.groupItems = [];

	function GroupItem() {
		this.key;
		this.result;
		this.page;
	}
	this.push = function(key, result, page) {
		var groupItem = new GroupItem();
		groupItem.key = key;
		groupItem.result = result;
		groupItem.page = page;
		this.groupItems.push(groupItem);
	}

	this.iterator = function(indexFun, key, result, page) {

		for(var index = 0; index < this.groupItems.length; index++) {
			if(indexFun)
				indexFun();
			if(key)
				key(this.groupItems[index].key);
			if(result) {
				var pojoList = this.groupItems[index].result;
				for(var i = 0; i < pojoList.length; i++)
					result(pojoList[i]);

			}
			if(page)
				page(this.groupItems[index].page, this.groupItems[index].key);
		}
	}
}

/*分页对象*/
function Page(page) {

	this.pages = 0; //页数
	this.totalNum = 0; //总条数

	this.pageNum = 1; //当前页数
	this.pageSize = 0; //页条数

	this.startRow = 0; //起始条数
	this.endRow = 0; //终止条数
	this.init(page);

}
Page.prototype.create = function(page) {
	var p = new Page();
	if(!page) {
		return p;
	}
	p.init(page);
	return p;
};
Page.prototype.init = function(page) {
	if(!page)
		return;
	this.pages = page.pages;
	this.totalNum = page.totalNum;
	this.pageNum = page.pageNum;
	this.pageSize = page.pageSize;
	this.startRow = page.startRow;
	this.endRow = page.endRow;
};
/*接口*/
function pojo() {
	this.page;
}
pojo.prototype.setPage = function(page) {
	this.page = page;
};
pojo.prototype.create = function(pojo, pojoData) {
	var vo = Object.create(pojo);
	if(pojoData)
		vo.init(pojoData);
	return vo;
}
pojo.prototype.init = function(pojoData) {
	if(!pojoData)
		return;
	for(var key in pojoData) {
		var value = pojoData[key];
		if(value)
			this[key] = value;
	}
}

/*省份对象*/
function Province(province) {
	this.namecode;
	this.name;
	this.init(province);
}
Province.prototype.__proto__ = pojo.prototype;
Province.prototype.constructor = Province;
/*城市对象*/
function City(city) {
	this.code;
	this.name;
	this.provincecode;
	this.init(city);
}
City.prototype.__proto__ = pojo.prototype;
City.prototype.constructor = City;

/*景区对象*/
function View(view) {
	this.id;
	this.viewname;
	this.code;
	this.citycode;
	this.viewkewwords;
	this.viewsummary;
	this.viewseason;
	this.rebate;
	this.visitnum;
	this.viewdesc;
	this.init(view);
}
View.prototype.__proto__ = pojo.prototype;
View.prototype.constructor = View;

/*景点描述对象*/
function ViewDesc(viewDesc) {
	this.id;
	this.opentime;
	this.palytime;
	this.viewdesc;
	this.viewhistory;
	this.positionmsg;
	this.ticketmsg;
	this.weather;
	this.init(viewDesc);
}
ViewDesc.prototype.__proto__ = pojo.prototype;
ViewDesc.prototype.constructor = ViewDesc;

/*景点美食对象*/
function Eat(eat) {
	this.id;
	this.eatname;
	this.code;
	this.viewid;
	this.eatdesc;
	this.init(eat);
}
Eat.prototype.__proto__ = pojo.prototype;
Eat.prototype.constructor = Eat;


/*景区套餐对象*/
function ViewSetMenu(viewSetMenu) {
	this.id;
	this.viewid;
	this.menuname;
	this.ordernum;
	this.orderprice;
	this.rebate;
	this.days;
	this.visitors;
	this.tickettypeid;
	this.expenseinvoices;
	this.usagemethod;
	this.activedate;
	this.backrule;
	this.menudesc;
	this.init(viewSetMenu);
}
ViewSetMenu.prototype.__proto__ = pojo.prototype;
ViewSetMenu.prototype.constructor = ViewSetMenu;

/*用户对象*/
function User(user) {
	this.id;
	this.username;
	this.realname;
	this.phone;
	this.email;
	this.sex;
	this.birth;
	this.address;
	this.init(user);
}
User.prototype.__proto__ = pojo.prototype;
User.prototype.constructor = User;

/*旅游人员对象*/
function Visitors(visitors) {
	this.id;
	this.userid;
	this.realname;
	this.idcardno;
	this.init(visitors);
}
Visitors.prototype.__proto__ = pojo.prototype;
Visitors.prototype.constructor = Visitors;

/*票对象*/
function Ticket(ticket) {
	this.id;
	this.setmenuid;
	this.number;
	this.status;
	this.createdate;
	this.init(ticket);
}
Ticket.prototype.__proto__ = pojo.prototype;
Ticket.prototype.constructor = Ticket;
/*票类型对象*/
function TicketType(tickettype) {
	this.id;
	this.code;
	this.typedesc;
	this.init(tickettype);
}
TicketType.prototype.__proto__ = pojo.prototype;
TicketType.prototype.constructor = TicketType;

/*订单对象*/
function Order(order) {
	this.id;
	this.setmenuid;
	this.userid;
	this.status;
	this.createdate;
	this.updatedate;
	this.init(order);
}
Order.prototype.__proto__ = pojo.prototype;
Order.prototype.constructor = Order;

/*订单详情对象*/
function OrderDetail(orderDetail) {
	this.id;
	this.orderid;
	this.ticketid;
	this.visitorid;
	this.createdate;
	this.updatedate;
	this.init(orderDetail);
}
OrderDetail.prototype.__proto__ = pojo.prototype;
OrderDetail.prototype.constructor = OrderDetail;

/*住所对象*/
function Hotel(hotel) {
	this.id;
	this.hotelname;
	this.hotelphone;
	this.code;
	this.viewid;
	this.hotelcategory;
	this.hoteldesc;
	this.init(hotel);
}
Hotel.prototype.__proto__ = pojo.prototype;
Hotel.prototype.constructor = Hotel;

/*住所详情对象*/
function HotelRoom(hotelRoom) {
	this.id;
	this.roomname;
	this.roomno;
	this.roomprice;
	this.hotelid;
	this.roomdesc;
	this.init(hotelRoom);
}
HotelRoom.prototype.__proto__ = pojo.prototype;
HotelRoom.prototype.constructor = HotelRoom;

/*餐饮对象*/
function Eatery(eatery) {
	this.id;
	this.eateryname;
	this.code;
	this.viewid;
	this.eaterycategory;
	this.consume;
	this.eaterydesc;
	this.init(eatery);
}
Eatery.prototype.__proto__ = pojo.prototype;
Eatery.prototype.constructor = Eatery;

/*评论对象*/
function Comment(comment) {
	this.id;
	this.code;
	this.viewdesc;
	this.userid;
	this.status;
	this.arguenum;
	this.createdate;
	this.init(comment);
}
Comment.prototype.__proto__ = pojo.prototype;
Comment.prototype.constructor = Comment;

/*项目路径*/
function getRootPath(path) {
	/*//获取当前网址，如： http://localhost:8083/projectName/welcome.html
	var curWwwPath = window.document.location.href;
	
	//获取主机地址之后的目录，如： /projectName/welcome.html
	var pathName = window.document.location.pathname;
	
	//获取带"/"的项目名，如：/projectName
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/'));

	return projectName+path;*/
	return path;
}
/*更改form表单action属性*/
/*url参数获取*/
$(function() {

	$("form").attr("action", function() { return getRootPath($(this).attr("action")) });

	/*为jquery添加获取url参数函数(不适用转发)*/
	(function($) {
		$.getUrlParam = function(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if(r != null) return unescape(r[2]);
			return null;
		}
	})(jQuery);

});

/*ajax返回框提示*/
$(function() {
	$.fn.manhua_msgTips = function(options) {
		var defaults = {
			Event: "click",
			timeOut: 300,
			msg: "thank you!",
			speed: 300,
			type: "success"
		};
		var options = $.extend(defaults, options);
		var bid = parseInt(Math.random() * 100000);
		$("body").prepend('<div id="tip_container' + bid + '" class="container tip_container"><div id="tip' + bid + '" class="mtip"><i class="micon"></i><span id="tsc' + bid + '"></span><i id="mclose' + bid + '" class="mclose"></i></div></div>');
		var $this = $(this);
		var $tip_container = $("#tip_container" + bid)
		var $tip = $("#tip" + bid);
		var $tipSpan = $("#tsc" + bid);
		var $colse = $("#mclose" + bid);

		clearTimeout(window.timer);

		$this.off();
		$this.on(options.Event, function() {
			$tip.attr("class", options.type).addClass("mtip");
			$tipSpan.html(options.msg);
			$tip_container.slideDown(options.speed);

			window.timer = setTimeout(function() {
				$tip_container.slideUp(options.speed);
			}, options.timeOut);

		});

		$tip_container.on("mouseover", function() {
			clearTimeout(window.timer);
		});

		$tip_container.on("mouseout", function() {
			window.timer = setTimeout(function() {
				$tip_container.slideUp(options.speed);
			}, options.timeOut);
		});

		$colse.on("click", function() {
			$tip_container.slideUp(options.speed);
		});
	}
});

/*加载等待插件*/
(function($) {
	$.fn.jqLoading = function(option) {
		var defaultVal = {
			backgroudColor: "#ECECEC", //背景色
			backgroundImage: "images/loading.gif", //背景图片
			text: "正在加载中，请耐心等待....", //文字 
			width: 150, //宽度
			height: 60, //高度
			type: 0 //0全部遮，1 局部遮

		};
		var opt = $.extend({}, defaultVal, option);

		if(opt.type == 0) {
			//全屏遮
			openLayer();
		} else {
			//局部遮(当前对象应为需要被遮挡的对象)
			openPartialLayer(this);
		}

		//销毁对象
		if(option === "destroy") {
			closeLayer();
		}

		//设置背景层高
		function height() {

			return $(document).height();

		};

		//设置背景层宽
		function width() {

			return $(document).width();

		};

		/*==========全部遮罩=========*/
		function openLayer() {
			//背景遮罩层
			var layer = $("<div id='layer'></div>");
			layer.css({
				zIndex: 9998,
				position: "absolute",
				height: height() + "px",
				width: width() + "px",
				background: "black",
				top: 0,
				left: 0,
				filter: "alpha(opacity=30)",
				opacity: 0.3

			});

			//图片及文字层
			var content = $("<div id='content'></div>");
			content.css({
				textAlign: "left",
				position: "absolute",
				zIndex: 9999,
				height: opt.height + "px",
				width: opt.width + "px",
				top: "50%",
				left: "50%",
				verticalAlign: "middle",
				background: opt.backgroudColor,
				borderRadius: "8px",
				fontSize: "13px"
			});

			content.append("<img style='vertical-align:middle;margin:" + (opt.height / 5) + "px; 0 0 5px;margin-right:5px;' src='" + opt.backgroundImage + "' /><span style='text-align:center; vertical-align:middle;'>" + opt.text + "</span>");
			$("body").append(layer).append(content);
			var top = content.css("top").replace('px', '');
			var left = content.css("left").replace('px', '');
			content.css("top", (parseFloat(top) - opt.height / 2)).css("left", (parseFloat(left) - opt.width / 2));

			return this;
		}

		//销毁对象
		function closeLayer() {
			$("#layer,#content,#partialLayer").remove();
			return this;
		}

		/*==========局部遮罩=========*/
		function openPartialLayer(obj) {

			var eheight = $(obj).css("height"); //元素带px的高宽度
			var ewidth = $(obj).css("width");
			var top = $(obj).offset().top; // 元素在文档中位置 滚动条不影响
			var left = $(obj).offset().left;

			var layer = $("<div id='partialLayer'></div>");
			layer.css({
				style: 'z-index:9998',
				position: "absolute",
				height: eheight,
				width: ewidth,
				background: "black",
				top: top,
				left: left,
				filter: "alpha(opacity=60)",
				opacity: 0.6,
				borderRadius: "3px",
				dispaly: "block"
			});
			$("body").append(layer);

			return this;
		}
	};

})(jQuery)