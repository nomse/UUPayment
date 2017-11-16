package com.unionpay.payment.carpay.utils;

import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.model.LatLng;

public class MoveUtil {

	/**
	 * 根据点获取图标转的角度，初始化图标指向使用
	 */
	public static double getAngle(int startIndex,Polyline mPolyline) {// 起点调用，调用方法getAngle(start,end),加上了一个判断
		if ((startIndex + 1) >= mPolyline.getPoints().size()) {
			throw new RuntimeException("index out of bonds");
		}
		LatLng startPoint = mPolyline.getPoints().get(startIndex);
		LatLng endPoint = mPolyline.getPoints().get(startIndex + 1);
		return getAngle(startPoint, endPoint);
	}

	/**
	 * 根据两点算取图标转的角度
	 */
	public static double getAngle(LatLng fromPoint, LatLng toPoint) {
		double slope = getSlope(fromPoint, toPoint);
		if (slope == Double.MAX_VALUE) {
			if (toPoint.latitude > fromPoint.latitude) {// 纬度相等，看经度大小，0或者180
				return 0;
			} else {
				return 180;
			}
		}
		float deltAngle = 0;
		if ((toPoint.latitude - fromPoint.latitude) * slope < 0) {
			deltAngle = 180;
		}
		double radio = Math.atan(slope);// 斜率的反三角函数
		double angle = 180 * (radio / Math.PI) + deltAngle - 90;
		return angle;
	}

	/**
	 * 根据点和斜率算取截距
	 */
	public static double getInterception(double slope, LatLng point) {

		double interception = point.latitude - slope * point.longitude;
		return interception;
	}

	/**
	 * 算斜率
	 */
	public static double getSlope(LatLng fromPoint, LatLng toPoint) {
		if (toPoint.longitude == fromPoint.longitude) {// 纬度相等，返回最大值标志
			return Double.MAX_VALUE;
		}
		double slope = ((toPoint.latitude - fromPoint.latitude) / (toPoint.longitude - fromPoint.longitude));
		return slope;

	}
	/**
	 * 计算x方向每次移动的距离
	 */
	public static double getXMoveDistance(double slope,double DISTANCE) {
		if (slope == Double.MAX_VALUE) {
			return DISTANCE;
		}
		return Math.abs((DISTANCE * slope) / Math.sqrt(1 + slope * slope));
	}

}
