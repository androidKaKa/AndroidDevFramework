package dim.proj.xutilsdemo.db;

import java.util.List;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ContentView;

import dim.proj.xutilsdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

@ContentView(R.layout.db_demo)
public class DbDemoActivity extends Activity{
	private String TAG="dbUtils-->>";
@Override
protected void onCreate(Bundle savedInstanceState) {

	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	ViewUtils.inject(this);
	DbUtils db=DbUtils.create(this); 
    db.configAllowTransaction(true);
    db.configDebug(true);

	User userOne=new User();
    User userTwo=new User();
	Student stuOne=new Student();
	try {
		userOne.setEmail("dim@phlin.com");
		db.save(userOne);
		//db.saveBindingId(userOne);
		userTwo.setEmail("test@tt.com");
		db.save(userTwo);
		
		stuOne.setAge(18);
		stuOne.setGrade(88);
		stuOne.setHeight(163);
		stuOne.setName("DeMaXiYa");
		db.save(stuOne);
		//db.saveBindingId(userTwo);
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		List<User> list = db.findAll(User.class);
		list.get(0).getEmail();
		Log.i(TAG, list.get(0).getEmail());
		Log.i(TAG, list.get(1).getEmail());
		
		List<Student> stu= db.findAll(Student.class);
		Log.i(TAG, "length of list "+stu.size());
		Log.i(TAG, ""+stu.get(0).getAge());
		try {
			Log.i(TAG, ""+stu.get(1).getAge());
		} catch (Exception e) {
			// TODO: handle exception
			Log.i(TAG,"out of array");
		}
	
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
