package com.example.ex.no11;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
public class MainActivity extends Activity {
public static int count = 0;
Button b;
static ImageView iv;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
iv = (ImageView) findViewById(R.id.imageView1);
iv.setVisibility(View.INVISIBLE);
}
public static void showImage() {
iv.setVisibility(View.VISIBLE);
}
public void startAlert(View view) {
iv.setVisibility(View.INVISIBLE);
EditText text = (EditText) findViewById(R.id.editText1);
int time = Integer.parseInt(text.getText().toString());
Intent intent = new Intent(this, MyBroadCastReceiver.class);
PendingIntent pend_intent = PendingIntent.getBroadcast(
this.getApplicationContext(), 0, intent, 0);
// calls the alarm
AlarmManager alarmManager = (AlarmManager) 
getSystemService(ALARM_SERVICE);
alarmManager.set(AlarmManager.RTC_WAKEUP, 
System.currentTimeMillis()
+ (time * 10000), pend_intent);
}
aravindonlineclasses.com
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is 
present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
}