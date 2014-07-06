package com.housekeeping.net;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class NetMethod {
	private static RequestQueue queue;

	/* 使用Singleton模式创建线程安全的实例 */
	public static synchronized RequestQueue create(Context context) {
		if (queue == null)
			queue = Volley.newRequestQueue(context);
		return queue;
	}

	public void stringRequest(int method, String url, Listener listener,
			ErrorListener errorListener, final Map<String, String> params) {
		StringRequest sr = new StringRequest(method, url, listener,
				errorListener) {
			@Override
			protected Map<String, String> getParams() {
				return params;
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();
				params.put("Content-Type", "application/x-www-form-urlencoded");
				return params;
			}
		};
		queue.add(sr);
	}

	public void jsonObjectRequest(int method, String url, Listener listener,
			ErrorListener errorListener, final Map<String, String> params) {
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method,
				url, null, listener, errorListener) {
			@Override
			protected Map<String, String> getParams() {
				return params;
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("Accept", "application/json");
				headers.put("Content-Type", "application/json; charset=UTF-8");
				return headers;
			}
		};
		queue.add(jsonObjectRequest);
	}

	public void imageRequest(String url, Listener<Bitmap> listener,
			int maxWidth, int maxHeight, 
			ErrorListener errorListener) {
		ImageRequest imageRequest = new ImageRequest(url, listener, maxWidth,
				maxHeight, Bitmap.Config.ARGB_8888, errorListener);
		queue.add(imageRequest);
	}
	
	
}
