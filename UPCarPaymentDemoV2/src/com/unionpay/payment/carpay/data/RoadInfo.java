package com.unionpay.payment.carpay.data;

import java.io.Serializable;

import com.baidu.mapapi.model.LatLng;

public class RoadInfo implements Serializable/*, Comparable<RoadInfo>*/ {
	public RoadInfo( String road, String direction, LatLng ll, int roadCon) {
		super();
		this.road = road;
		this.direction = direction;
		this.ll = ll;
		this.roadCon = roadCon;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 118680528878270420L;
	private String road;// 那一条路
	private String direction;// 导航方向
	private LatLng ll;// 点的坐标
	private int roadCon;// 路况，

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public LatLng getLl() {
		return ll;
	}

	public void setLl(LatLng ll) {
		this.ll = ll;
	}

	public int getRoadCon() {
		return roadCon;
	}

	public void setRoadCon(int roadCon) {
		this.roadCon = roadCon;
	}

	/* 按照路况，和道路点的索引来排序 */
	/*@Override
	public int compareTo(RoadInfo another) {
		if (roadCon != another.getRoadCon()) {
			return roadCon - another.getRoadCon();
		} else {
			return roadIndex - another.getRoadIndex();
		}
	}*/

}
