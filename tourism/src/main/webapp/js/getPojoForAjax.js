function getPojo(uri, param, pojo, successFun, errorFun) {

	$.ajax({
		type: "post",
		url: uri,
		async: true,
		data: param,
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
			var arr = JsonPojo.prototype.parseArray(data, pojo);
			successFun(arr, textStatus, jqXHR);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			errorFun(XMLHttpRequest, textStatus, errorThrown);
		}
	});

}
/*解析对象*/
function JsonPojo() {}
JsonPojo.prototype.parseObject = function(jsonString, object) {
	var json = JSON.parse(jsonString);
	var obj = object.__proto__.create(json.result);
	obj.setPage(json.page);
};
JsonPojo.prototype.parseArray = function(jsonString, object) {
	var list = new Array();
	var json = JSON.parse(jsonString);
	var array = json.result;
	var page = new Page(json.page);
	for(var i = 0; i < array.length; i++) {
		var obj = object.__proto__.create(object, array[i]);
		obj.__proto__.setPage(page);
		list.push(obj);
	}
	return list;
};

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

/*景点对象*/
function ViewPoint(viewPoint) {
	this.id;
	this.viewpointname;
	this.code;
	this.viewpointsummary;
	this.viewticket;
	this.visitnum;
	this.viewid;
	this.viewpointdesc;
	this.init(viewPoint);
}
ViewPoint.prototype.__proto__ = pojo.prototype;
ViewPoint.prototype.constructor = ViewPoint;

/*景区路线对象*/
function ViewRoute(viewRoute) {
	this.id;
	this.viewid;
	this.routes;
	this.routeprice;
	this.ordernum;
	this.init(viewRoute);
}
ViewRoute.prototype.__proto__ = pojo.prototype;
ViewRoute.prototype.constructor = ViewRoute;

/*景区套餐对象*/
function ViewSetMenu(viewSetMenu) {
	this.id;
	this.viewid;
	this.setmenus;
	this.ordernum;
	this.orderprice;
	this.days;
	this.visitors;
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