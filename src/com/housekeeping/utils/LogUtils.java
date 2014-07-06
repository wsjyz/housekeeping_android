package com.housekeeping.utils;

import android.util.Log;

/**
 * @author wangli Log������
 * 
 */
public  class LogUtils {

	private static boolean sIsLogEnabled = true;// �Ƿ��LOG

	private static String sApplicationTag = "HouseKeeping";// LOGĬ��TAG

	private static final String TAG_CONTENT_PRINT = "%s:%s.%s:%d";

	private static StackTraceElement getCurrentStackTraceElement() {
		return Thread.currentThread().getStackTrace()[4];

	}

	//��ӡLOG
	public static void trace() {
		if (sIsLogEnabled) {
			android.util.Log.d(sApplicationTag,
					getContent(getCurrentStackTraceElement()));
		}
	}

	//��ȡLOG
	private static String getContent(StackTraceElement trace) {
		return String.format(TAG_CONTENT_PRINT, sApplicationTag,
				trace.getClassName(), trace.getMethodName(),
				trace.getLineNumber());
	}
	//��ӡĬ��TAG��LOG
	public static void traceStack() {
		if (sIsLogEnabled) {
			traceStack(sApplicationTag, android.util.Log.ERROR);
		}
	}

	// ��ӡLog��ǰ����ջ��Ϣ
	public static void traceStack(String tag, int priority) {

		if (sIsLogEnabled) {
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			android.util.Log.println(priority, tag, stackTrace[4].toString());
			StringBuilder str = new StringBuilder();
			String prevClass = null;
			for (int i = 5; i < stackTrace.length; i++) {
				String className = stackTrace[i].getFileName();
				int idx = className.indexOf(".java");
				if (idx >= 0) {
					className = className.substring(0, idx);
				}
				if (prevClass == null || !prevClass.equals(className)) {

					str.append(className.substring(0, idx));

				}
				prevClass = className;
				str.append(".").append(stackTrace[i].getMethodName())
						.append(":").append(stackTrace[i].getLineNumber())
						.append("->");
			}
			android.util.Log.println(priority, tag, str.toString());
		}
	}
	//ָ��TAG��ָ�����ݵķ���
	public static void d(String tag, String msg) {
		if (sIsLogEnabled) {
			Log.d(tag, getContent(getCurrentStackTraceElement())+">"+msg);
		}
	}
	//Ĭ��TAG���ƶ����ݵķ���
	public static void d(String msg) {
		if (sIsLogEnabled) {
			Log.d(sApplicationTag, getContent(getCurrentStackTraceElement())+">"+msg);
		}
	}
	//����Ķ�������淽����ͬ�����Զ��岻ͬ�ȼ���Debugger
	public static void i(String tag,String msg){
		
	}
	public static void w(String tag,String msg){
		
	}
	public static void e(String tag,String msg){
		
	}
}