package dim.proj.xutilsdemo;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnFocusChange;
import com.lidroid.xutils.view.annotation.event.OnLongClick; 

import dim.proj.xutilsdemo.bitmap.BitmapDemoActivity;
import dim.proj.xutilsdemo.db.DbDemoActivity;
import dim.proj.xutilsdemo.http.HttpDemoActivity;
import dim.proj.xutilsdemo.log.LogDemoActivity;
import dim.proj.xutilsdemo.view.ViewDemoActivity; 
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

//setContentView()
@ContentView(R.layout.activity_main)

public class MainActivity extends Activity {
	private final static String TAG="xUtils Demo--->>";
	//findViewById();
	@ViewInject(R.id.textTitle)
	TextView textTitle;
	 
	//按钮点击监听
	@OnClick(R.id.btnView)
	public  void btnViewClick(View v)
	{
		  LogUtils.allowI=true;
		  LogUtils.allowD=true;
		  //v.getId()==R.id.btnView?
		//  Log.i(TAG, " log"+v.getId());
		//  LogUtils.d(TAG+v.getId());
		  Log.i(TAG, " log"+v.getId());
		 
			Intent viewDemoI=new Intent().setClass(MainActivity.this, ViewDemoActivity.class);
			startActivity(viewDemoI);
	}
	
	@OnClick(R.id.httpDemo)
	public void httpDemo(View v)
	{
		Intent httpDemoI=new Intent().setClass(MainActivity.this, HttpDemoActivity.class);
		startActivity(httpDemoI);
	}
	@OnClick(R.id.bitmapDemo)
	public void bitmapDemo(View v)
	{
		quickStartActivity(MainActivity.this,BitmapDemoActivity.class,false);
	}
	@OnClick(R.id.dbDemo)
	public void dbDemo(View v)
	{
		quickStartActivity(MainActivity.this,DbDemoActivity.class,false);
	}
	@OnClick(R.id.logDemo) 
	public void logDemo(View v)
	{
		quickStartActivity(MainActivity.this,LogDemoActivity.class,false);
	}
	//长按 按钮监听
	@OnLongClick(R.id.btnView)
	public void btnViewLClick(View v)
	{
		
	}
	
	//焦点变化监听
	@OnFocusChange(R.id.btnView)
	public void foucsChange(View v)
	{
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		ViewUtils.inject(this); 
		textTitle.setText("xUtils Demo !");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
/**
 * 
*@param packageContext: A Context of the application package implementing this class.  
*@param cls :The class name to set, equivalent to setClassName(context, cls.getName()).
 * @param finished
 */
	public void quickStartActivity(Context packageContext, Class<?> cls,boolean finished)
	{
		Intent i=new Intent().setClass(packageContext, cls);
		startActivity(i);
		if(finished)finish();
	}
}
