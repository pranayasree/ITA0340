package com.example.ex.no10;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class MainActivity extends Activity {
Button b;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
b = (Button) findViewById(R.id.btnGenerateNotifications);
b.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View arg0) {
Intent intent = new Intent(MainActivity.this,
SubActivity.class);
PendingIntent pendIntent = PendingIntent.getActivity(
MainActivity.this, 0, intent, 0);
NotificationCompat.Builder builder = new
NotificationCompat.Builder(MainActivity.this);
/* builder.setContentTitle("Normal Regular 
Notification");
builder.setContentText("ContentText,ContentText,ContentText,ContentText
,ContentText,ContentText,ContentText");
builder.setSmallIcon(R.drawable.ic_launcher);
builder.setTicker("Message from 
Developer.Android....");
builder.setAutoCancel(true);
builder.setContentIntent(pendIntent);*/
Notification notif = builder.build();
NotificationManager nm = 
(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
nm.notify(234, notif);
aravindonlineclasses.com
Notification notiMail = new Notification.Builder(
MainActivity.this)
.setTicker("Message from 
Developer.Android....")
.setContentTitle("Marshmallow@developer.android.in")
.setContentText("Android 6.0")
.setSmallIcon(R.drawable.ic_launcher)
.setContentIntent(pendIntent).setAutoCancel(true)
.build();
NotificationManager notificationManager = 
(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
notificationManager.notify(0, notiMail);
}
});
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is 
present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
}
