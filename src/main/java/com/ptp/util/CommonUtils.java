package com.ptp.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {
	/**
	 * 
	 * @Description:拼接数据库字段
	 * @param str
	 * @return
	 * @Author:王海章 2016年9月26日 下午5:28:43
	 * @update1:
	 *
	 */
	public static String getDBFieldName(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				if (i != 0) {
					sb.append("_" + Character.toLowerCase(str.charAt(i)));
				} else {
					sb.append(Character.toLowerCase(str.charAt(i)));
				}
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}


	/**
	 * @Decription: 拼接Set<Map<String,Map<String,Object>>>集合,父子类之间集合拼接。 [{
	 *              parentId:{ parentName:"", children:[ { childId:0,
	 *              childName:"" } ] } }]
	 * @return List<Object>
	 * @throws Exception 
	 * @Author:王海章 2016年10月9日 下午2:08:24
	 * @update1:
	 *
	 */
	public static <T> Set<Map<Object, Map<String, Object>>> getTreeMap(List<T> list) throws Exception {
		if(isNullObj(list)){
			return null;
		}
		Set<Map<Object, Map<String, Object>>> listObj=new HashSet<Map<Object, Map<String, Object>>>();
		Map<Object,Map<String,Object>> mapParent=new HashMap<Object,Map<String,Object>>();
		Set<Object> listIds=new HashSet<Object>();
		Map<Object,Object> mapNames=new HashMap<Object,Object>();
		for (T t : list) {
			if(!isNullObj(t)){
				listIds.add(invokeMetyReflect(t,"parentId"));
				mapNames.put(invokeMetyReflect(t,"id"), invokeMetyReflect(t,"name"));
			}
		}
		for(Object id : listIds){
			if(!isNullObj(id) && (int)id != 0){
				getMapPatent(list, id, mapNames.get(id), mapParent);
			}
		}
		listObj.add(mapParent);
		return listObj;
	}
	/**
	 * 
	 * @Description:获取Map<Object,Map<String,Object>>
	 * @param list
	 * @param id
	 * @return
	 * @throws Exception
	 * @Author:王海章  2016年10月9日 下午4:01:24
	 * @update1: 
	 *
	 */
	private static <T> Map<Object,Map<String,Object>> getMapPatent(List<T> list, Object id, Object name,Map<Object,Map<String,Object>> mapParent) throws Exception {
		for(T tFirstParent :list){
			Object idParent=invokeMetyReflect(tFirstParent,"parentId");
			if(id == idParent){

				Map<String,Object> mapChildren=new HashMap<String,Object>();
				mapChildren.put("parentName", name);
				List<T> listChildren=new ArrayList<T>();
				for(T tChildren :list){
					if(idParent == invokeMetyReflect(tChildren,"parentId")){
						listChildren.add(tChildren);
					}
				}
				mapChildren.put("children", listChildren);
				mapParent.put(id, mapChildren);
			}
		}
 		return mapParent;
	}
	/**
	 * 
	 * @Description:判断是否非空
	 * @param obj
	 * @return
	 * @Author:王海章  2016年10月9日 下午3:33:01
	 * @update1: 
	 *
	 */
	public static boolean isNullObj(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof List) {
			return ((List) obj).size() == 0;
		}
		if (obj instanceof String) {
			return ((String) obj).trim().equals("");
		}
		if( obj instanceof Map){
			return ((Map)obj).isEmpty();
		}
		return false;
	}
	/**
	 * 
	 * @Description:通过反射调用方法
	 * @param t 对象
	 * @param fName
	 * @return
	 * @throws Exception
	 * @Author:王海章  2016年10月9日 下午3:32:01
	 * @update1: 
	 *
	 */
	public static <T> Object invokeMetyReflect(T t,String fName) throws Exception{
		Class<? extends Object> clazz = t.getClass();
		
		Field[] fds = clazz.getDeclaredFields();
		
		for (Field field : fds) {// 遍历该数组
			
			String fieldName = field.getName();// 得到字段名，
			
			Method method = clazz.getMethod("get"+changeFistCap(fName), null);// 根据字段名找到对应的get方法，null表示无参数

            if (fName.equals(fieldName) && method != null) {// 比较是否在字段数组中存在name字段，如果不存在短路，如果存在继续判断该字段的get方法是否存在，同时存在继续执行
                Object obj = method.invoke(t, null);// 调用该字段的get方法
                return obj;
            }
        }
		return null;
	}
	/**
	 * 
	 * @Description:
	 * @param src
	 * @return
	 * @Author:王海章  2016年10月9日 下午3:32:21
	 * @update1: 
	 *
	 */
	public static String changeFistCap(String src){
		if(!isNullObj(src)){
			StringBuilder sb=new StringBuilder(src);
			sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
			return sb.toString();
		}
		return "";
	}
	
	/**
	 * 
	 * @Description: 图形布局
	 * @param
	 * @return Map<String,String>
	 * @Author: 张珈箕
	 * @update1: 
	 *
	 */
	public static Map<Object,Object> roundMap(int x,int y, int r ,double n){
		if (n == 0.0) {
			return null;
		}
		
		Map<Object,Object> map=new HashMap<Object,Object>();
		int temp = (int) Math.ceil(n/4);
		int temp2 =  (int) (Math.PI/temp);
		for (int i = 1; i <= temp; i++) {
			int key = (int) (x + Math.cos(temp2*i*Math.PI/180)*r);
			int value = (int) (y +  Math.sin(temp2*i*Math.PI/180)*r);
			int key1 = (int) (x - Math.cos(temp2*i*Math.PI/180)*r);
			int value1 = (int) (y -  Math.sin(temp2*i*Math.PI/180)*r);
			map.put(key, value);
			map.put(key + 1, value1);
			map.put(key1 + 2, value);
			map.put(key1 + 3, value1);
		}
		return map;
	}



	public static String getMD5(String originString) {
		String result = null;
		if (originString != null) {
			try {
				// 指定加密的方式为MD5
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 进行加密运算
				byte bytes[] = md.digest(originString.getBytes());
				for (int i = 0; i < bytes.length; i++) {
					// 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
					String str = Integer.toHexString(bytes[i] & 0xFF);
					if (str.length() == 1) {
						str += "F";
					}
					result += str;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result.toUpperCase();
	}

	public static String convertDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}

	/**
	 * 前台js提交的中文数据，转换为utf-8
	 * @param
	 * @return
	 */
	public static Map<String,Object> convertEncoding(Map<String,Object> map){
		Map<String,Object> newMap = new HashMap<>();
		for (Map.Entry<String,Object> entry : map.entrySet()){
			if (entry.getKey().contains("Name")){
				String value = (String) entry.getValue();
				try {
					value = new String(value.getBytes("iso-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				newMap.put(entry.getKey(), value);
			}else {
				newMap.put(entry.getKey(),entry.getValue());
			}
		}
		return newMap;
	}


    /**
     * yyyy-MM-dd'T'HH:mm:ss'Z'
     * @param utcTimeStr
     * @param utcFormat
     * @return
     */
	public static String utc2Local(String utcTimeStr, String utcFormat){
		SimpleDateFormat format = new SimpleDateFormat(utcFormat);
		Date date = null;
		try {
			date = format.parse(utcTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+8);
		String showTime = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
		return showTime;

	}

    public static String utc2Local(String utcTimeStr){
	    if (!utcTimeStr.contains("T") || !utcTimeStr.contains("Z")){
            return utcTimeStr;
        }
        String fullTime = utcTimeStr.replace("T"," ").replace("Z","");
	    String showTime = fullTime.split(" ")[1];
        return showTime;

    }


    public static String setToString(Set<String> set){
		StringBuffer stringBuffer = new StringBuffer();
		for (String str : set){
			stringBuffer.append(str);
		}
		return stringBuffer.toString();

	}

	/**
	 * 判断两个字符串数组是否相等
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean compareTwoStringArray(String[] arr1, String[] arr2){
		if (arr1 == null || arr2 == null){
			throw new RuntimeException("字符串数组参数为null");
		}
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = Arrays.asList(arr2);
		Collections.sort(list1);
		Collections.sort(list2);
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();

		for (String s : list1){
			buffer1.append(s);
		}
		for (String s : list2){
			buffer2.append(s);
		}
		return buffer1.toString().equals(buffer2.toString());
	}

	public static Map<String, String> getFormKV(String params){
		Map<String, String> kvMap = new HashMap<>();
		if (StringUtils.isBlank(params)){
			return kvMap;
		}

		String[] kvArray = params.split("&");
		for (String kv : kvArray){
			String[] kvs = kv.split("=");
			String k = kvs[0];
			String v = "";
			if (kvs.length >= 2){
				v = kvs[1];
			}
			kvMap.put(k, v);
		}
		return kvMap;
	}


	public static String xmlConvert(String str){
		if (str == null){
			throw new RuntimeException("参数为空");
		}
		String newStr = str.replaceAll("&", "&amp;")
				.replaceAll("\"", "&quot;")
				.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;")
				.replaceAll("&", "&amp;");
		return newStr;
	}

	public static List<String> covertIpList(String[] pressureMachines) {
		List<String> ipList = new ArrayList<>();
		for (String ip : pressureMachines) {
			ipList.add(ip.split("-")[0]);
		}
		return ipList;
	}


	public static void main(String[] args) {
		String params = "123";
		System.out.println(getFormKV(params));
	}
}
