package com.housekeeping.cache;

import java.io.File;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> mMemoryCache;
	public DiskLruCache mDiskCache;
	private static final int DISK_CACHE_SIZE = 1024 * 1024 * 20; // 10MB
	private static final String DISK_CACHE_SUBDIR = "thumbnails";

	public BitmapCache(Context context) {
		int maxSize = 10 * 1024 * 1024;
		mMemoryCache = new LruCache<String, Bitmap>(maxSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
		File cacheDir = DiskLruCache
				.getDiskCacheDir(context, DISK_CACHE_SUBDIR);
		mDiskCache = DiskLruCache.openCache(context, cacheDir, DISK_CACHE_SIZE);

	}

	@Override
	public Bitmap getBitmap(String url) {
		Bitmap bitmap = mMemoryCache.get(url);
		if (bitmap == null) {
			bitmap = mDiskCache.get(url);
		}
		return bitmap;
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mDiskCache.put(url, bitmap);
		mMemoryCache.put(url, bitmap);
	}

}
