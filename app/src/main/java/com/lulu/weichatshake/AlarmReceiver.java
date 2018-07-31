package com.lulu.weichatshake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Intent i = new Intent(arg0, LongRunningService.class);
		arg0.startService(i);
	}
	/*可以看到，LongRunningService 果然如我们所愿地运行着，每隔一小时都会打印一条日
	志。这样，当你真正需要去执行某个定时任务的时候，只需要将打印日志替换成具体的任务
	逻辑就行了。*/
}
