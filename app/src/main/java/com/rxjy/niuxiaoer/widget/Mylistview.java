package com.rxjy.niuxiaoer.widget;

import android.content.Context;
import android.widget.ListView;

public class Mylistview extends ListView{

	public Mylistview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public Mylistview(Context context,android.util.AttributeSet attrs){
		super(context, attrs);
		
	}
   @Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	   int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
			   MeasureSpec.AT_MOST);
	super.onMeasure(widthMeasureSpec, expandSpec);
}
}
