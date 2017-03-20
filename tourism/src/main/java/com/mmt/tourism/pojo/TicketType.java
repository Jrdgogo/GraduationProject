package com.mmt.tourism.pojo;

public enum TicketType {
	CHILD("child","儿童票",0.90),
	MAN("man","成人票",0.60),
	ELDER("elder","老人票",0.70);
	
	private String type;
	private String desc;
	private Double rebate;
	
	private TicketType(String type,String desc,double rebate){
		this.type=type;
		this.desc=desc;
		this.rebate=rebate;
	}
	
	public static TicketType getTicketTypeByType(String type){
		for(TicketType ticketType:TicketType.values()){
			if(ticketType.type.equals(type))
				return ticketType;
		}
		throw new RuntimeException("无该枚举类型");
	}
	public static TicketType getTicketTypeByDesc(String desc){
		for(TicketType ticketType:TicketType.values()){
			if(ticketType.desc.equals(desc))
				return ticketType;
		}
		throw new RuntimeException("无该枚举类型");
	}
	public static TicketType getTicketTypeByRebate(double rebate){
		for(TicketType ticketType:TicketType.values()){
			if(ticketType.rebate.equals(rebate))
				return ticketType;
		}
		throw new RuntimeException("无该枚举类型");
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public double getRebate() {
		return rebate;
	}
	
	

}
