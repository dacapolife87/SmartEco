package com.smarteco.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.SharedPreferences;

public class IMGUtil {

	//���� ������ ����Ʈ ��̷� ������
	public static byte[] getBytesFromFile(File file) throws IOException
	{
		InputStream is = new FileInputStream(file);
		// ũ�⸦ ���´�..
		long length = file.length();
		
		if(length> Integer.MAX_VALUE)
		{
			//file is too large
		}
		
		byte[] bytes = new byte[(int)length];
		int offset =0;
		int numRead =0;
		
		while(offset<bytes.length&&(numRead= is.read(bytes,offset,bytes.length - offset))>=0)
		{
			offset +=numRead;
		}
		if(offset<bytes.length){
			throw new IOException("bould not completely read file " + file.getName());
		}
		is.close();
		return bytes;
		
	}
	
	// app sharedPreferences �� �� ����
	public static String setAppPreferences(Activity context, String key, String value){
		String returnValue = null;
		SharedPreferences pref = null;
		pref = context.getSharedPreferences("FacebookTest",0);
		returnValue = pref.getString(key,"");
		
		return returnValue;
	}
}
