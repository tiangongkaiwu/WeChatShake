package com.lulu.weichatshake;

import java.util.Date;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class LongRunningService extends Service{
//	public LocationClient mLocationClient = null;
//	public BDLocationListener myListener = new MyLocationListener();
	private final Intent intent = new Intent("com.example.communication.RECEIVER");
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressLint("NewApi") @Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub

//		Log.e("cyj", "execute at"+new Date().toString());


//		mLocationClient = new LocationClient(getApplicationContext()); // 澹版槑LocationClient绫�
//		mLocationClient.registerLocationListener(myListener); // 娉ㄥ唽鐩戝惉鍑芥暟
//		initLocation();//鍒濆鍖栧畾浣嶆ā寮�
//		/**
//		 * start锛氬惎鍔ㄥ畾浣峉DK銆� stop锛氬叧闂畾浣峉DK銆傝皟鐢╯tart涔嬪悗鍙渶瑕佺瓑寰呭畾浣嶇粨鏋滆嚜鍔ㄥ洖璋冨嵆鍙��
//		 * 寮�鍙戣�呭畾浣嶅満鏅鏋滄槸鍗曟瀹氫綅鐨勫満鏅紝鍦ㄦ敹鍒板畾浣嶇粨鏋滀箣鍚庣洿鎺ヨ皟鐢╯top鍑芥暟鍗冲彲銆�
//		 * 濡傛灉stop涔嬪悗浠嶇劧鎯宠繘琛屽畾浣嶏紝鍙互鍐嶆start绛夊緟瀹氫綅缁撴灉鍥炶皟鍗冲彲銆�
//		 * 濡傛灉寮�鍙戣�呮兂鎸夌収鑷繁閫昏緫璇锋眰瀹氫綅锛屽彲浠ュ湪start涔嬪悗鎸夌収鑷繁鐨勯�昏緫璇锋眰locationclient
//		 * .requestLocation()鍑芥暟锛屼細涓诲姩瑙﹀彂瀹氫綅SDK鍐呴儴瀹氫綅閫昏緫锛岀瓑寰呭畾浣嶅洖璋冨嵆鍙��
//		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				mLocationClient.start();// 寮�濮嬪畾浣�
//				syncSingleStatistics();
				Intent intent = null;
				if(intent == null){
					intent = new Intent("com.example.communication.RECEIVER");
				}
 			intent.putExtra("progress", "aa");
			sendBroadcast(intent);
			}
		}).start();
		
		
		//璁惧畾瀹氭椂浠诲姟锛氬洜涓轰竴鏃﹀惎鍔↙ongRunningService,灏变細鍦╫nStartCommand()鏂规硶閲�
		//璁惧畾涓�涓畾鏃朵换鍔★紝杩欐牱涓�灏忔椂鍚嶢larmReceiver鐨刼nReceive锛堬級鏂规硶灏卞皢寰楀埌鎵ц锛岀劧鍚�
		//鎴戜滑鍦ㄨ繖閲屽啀娆″惎鍔↙ongRunningService锛岃繖鏍峰氨褰㈡垚浜嗕竴涓案涔呯殑寰幆锛屼繚璇丩ongRunningService
		//鍙互姣忛殧涓�灏忔椂灏变細鍚姩涓�娆★紝涓�涓暱鏈熷湪鍚庡彴瀹氭椂杩愯鐨勬湇鍔¤嚜鐒朵篃灏卞畬鎴愪簡銆�
		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		int anHour = 5*1000;//
		long triggerAtTime = SystemClock.elapsedRealtime()+anHour;
		Intent i = new Intent(this,AlarmReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
		manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
		
		return super.onStartCommand(intent, flags, startId);
	}
	/**
	 * 同步单体统计数据
	 * http://10.21.8.78:8888/setSpeed?action=cotrol&sn=1&val=456
	 */
//	private void syncSingleStatistics() {
//		Log.e("cyj", "uploadcount:" + MainActivity.count);
//		String url = "http://10.21.8.78:8888/setSpeed?";
//		OkHttpUtils
//				.get(url)
//				.params("action", "cotrol")
//				.params("sn", "1")
//				.params("val", MainActivity.count + "")
//				.execute(new StringCallback() {
//					@Override
//					public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//
//
//						super.onError(isFromCache, call, response, e);
////                        aHandler.sendEmptyMessage(CLOSE_DIALOG);
////                        Util.logcatByCQH("onError syncSingleStatistics:" + e);
//					}
//
//					@Override
//					public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
//
////                        Util.logcatByCQH("onResponse syncSingleStatistics:" + s);
//						if (response.isSuccessful()) {
//							MainActivity.count = 0;
//							Log.e("cyj", "clearcount:" + MainActivity.count);
//						}
//					}
//				});
//	}
	
	
	/**
	 * 楂樼簿搴﹀畾浣嶆ā寮忥細杩欑瀹氫綅妯″紡涓嬶紝浼氬悓鏃朵娇鐢ㄧ綉缁滃畾浣嶅拰GPS瀹氫綅锛屼紭鍏堣繑鍥炴渶楂樼簿搴︾殑瀹氫綅缁撴灉锛�
	 * 浣庡姛鑰楀畾浣嶆ā寮忥細杩欑瀹氫綅妯″紡涓嬶紝涓嶄細浣跨敤GPS锛屽彧浼氫娇鐢ㄧ綉缁滃畾浣嶏紙Wi-Fi鍜屽熀绔欏畾浣嶏級锛�
	 * 浠呯敤璁惧瀹氫綅妯″紡锛氳繖绉嶅畾浣嶆ā寮忎笅锛屼笉闇�瑕佽繛鎺ョ綉缁滐紝鍙娇鐢℅PS杩涜瀹氫綅锛岃繖绉嶆ā寮忎笅涓嶆敮鎸佸鍐呯幆澧冪殑瀹氫綅銆�
	 */
//	private void initLocation() {
//		LocationClientOption option = new LocationClientOption();
//		option.setLocationMode(LocationMode.Hight_Accuracy);// 鍙�夛紝榛樿楂樼簿搴︼紝璁剧疆瀹氫綅妯″紡锛岄珮绮惧害锛屼綆鍔熻�楋紝浠呰澶�
//		option.setCoorType("bd09ll");// 鍙�夛紝榛樿gcj02锛岃缃繑鍥炵殑瀹氫綅缁撴灉鍧愭爣绯�
//		int span = 1000;
//		option.setScanSpan(span);// 鍙�夛紝榛樿0锛屽嵆浠呭畾浣嶄竴娆★紝璁剧疆鍙戣捣瀹氫綅璇锋眰鐨勯棿闅旈渶瑕佸ぇ浜庣瓑浜�1000ms鎵嶆槸鏈夋晥鐨�
//		option.setIsNeedAddress(true);// 鍙�夛紝璁剧疆鏄惁闇�瑕佸湴鍧�淇℃伅锛岄粯璁や笉闇�瑕�
//		option.setOpenGps(true);// 鍙�夛紝榛樿false,璁剧疆鏄惁浣跨敤gps
//		option.setLocationNotify(true);// 鍙�夛紝榛樿false锛岃缃槸鍚﹀綋gps鏈夋晥鏃舵寜鐓�1S1娆￠鐜囪緭鍑篏PS缁撴灉
//		option.setIsNeedLocationDescribe(true);// 鍙�夛紝榛樿false锛岃缃槸鍚﹂渶瑕佷綅缃涔夊寲缁撴灉锛屽彲浠ュ湪BDLocation.getLocationDescribe閲屽緱鍒帮紝缁撴灉绫讳技浜庘�滃湪鍖椾含澶╁畨闂ㄩ檮杩戔��
//		option.setIsNeedLocationPoiList(true);// 鍙�夛紝榛樿false锛岃缃槸鍚﹂渶瑕丳OI缁撴灉锛屽彲浠ュ湪BDLocation.getPoiList閲屽緱鍒�
//		option.setIgnoreKillProcess(false);// 鍙�夛紝榛樿true锛屽畾浣峉DK鍐呴儴鏄竴涓猄ERVICE锛屽苟鏀惧埌浜嗙嫭绔嬭繘绋嬶紝璁剧疆鏄惁鍦╯top鐨勬椂鍊欐潃姝昏繖涓繘绋嬶紝榛樿涓嶆潃姝�
//		option.SetIgnoreCacheException(false);// 鍙�夛紝榛樿false锛岃缃槸鍚︽敹闆咰RASH淇℃伅锛岄粯璁ゆ敹闆�
//		option.setEnableSimulateGps(false);// 鍙�夛紝榛樿false锛岃缃槸鍚﹂渶瑕佽繃婊ps浠跨湡缁撴灉锛岄粯璁ら渶瑕�
//		mLocationClient.setLocOption(option);
//
//
//	}
	/**
	 * BDLocationListener鎺ュ彛鏈�1涓柟娉曢渶瑕佸疄鐜帮細 1.鎺ユ敹寮傛杩斿洖鐨勫畾浣嶇粨鏋滐紝鍙傛暟鏄疊DLocation绫诲瀷鍙傛暟銆�
	 * BDLocation绫伙紝灏佽浜嗗畾浣峉DK鐨勫畾浣嶇粨鏋滐紝鍦˙DLocationListener鐨刼nReceive鏂规硶涓幏鍙栥��
	 * 閫氳繃璇ョ被鐢ㄦ埛鍙互鑾峰彇error code锛屼綅缃殑鍧愭爣锛岀簿搴﹀崐寰勭瓑淇℃伅銆傚叿浣撴柟娉曡鍙傝�冪被鍙傝�冦��
	 */
//	public class MyLocationListener implements BDLocationListener {
//
//		@Override
//		public void onReceiveLocation(BDLocation location) {
//
////			tv.setText(location.getAddrStr());
//			Log.e("aa", location.getAddrStr()+location.getTime());
////			鍙戦�丄ction涓篶om.example.communication.RECEIVER鐨勫箍鎾�
//			intent.putExtra("progress", location.getAddrStr()+location.getTime());
//			sendBroadcast(intent);
//			mLocationClient.stop();
//			/*// Receive Location
//			StringBuffer sb = new StringBuffer(256);
//			sb.append("time : ");
//			sb.append(location.getTime());
//			sb.append("\nerror code : ");
//			sb.append(location.getLocType());
//			sb.append("\nlatitude : ");
//			sb.append(location.getLatitude());
//			sb.append("\nlontitude : ");
//			sb.append(location.getLongitude());
//			sb.append("\nradius : ");
//			sb.append(location.getRadius());
//			if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS瀹氫綅缁撴灉
//				sb.append("\nspeed : ");
//				sb.append(location.getSpeed());// 鍗曚綅锛氬叕閲屾瘡灏忔椂
//				sb.append("\nsatellite : ");
//				sb.append(location.getSatelliteNumber());
//				sb.append("\nheight : ");
//				sb.append(location.getAltitude());// 鍗曚綅锛氱背
//				sb.append("\ndirection : ");
//				sb.append(location.getDirection());// 鍗曚綅搴�
//				sb.append("\naddr : ");
//				sb.append(location.getAddrStr());
//				sb.append("\ndescribe : ");
//				sb.append("gps瀹氫綅鎴愬姛");
//
//			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 缃戠粶瀹氫綅缁撴灉
//				sb.append("\naddr : ");
//				sb.append(location.getAddrStr());
//				// 杩愯惀鍟嗕俊鎭�
//				sb.append("\noperationers : ");
//				sb.append(location.getOperators());
//				sb.append("\ndescribe : ");
//				sb.append("缃戠粶瀹氫綅鎴愬姛");
//			} else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 绂荤嚎瀹氫綅缁撴灉
//				sb.append("\ndescribe : ");
//				sb.append("绂荤嚎瀹氫綅鎴愬姛锛岀绾垮畾浣嶇粨鏋滀篃鏄湁鏁堢殑");
//			} else if (location.getLocType() == BDLocation.TypeServerError) {
//				sb.append("\ndescribe : ");
//				sb.append("鏈嶅姟绔綉缁滃畾浣嶅け璐ワ紝鍙互鍙嶉IMEI鍙峰拰澶т綋瀹氫綅鏃堕棿鍒發oc-bugs@baidu.com锛屼細鏈変汉杩芥煡鍘熷洜");
//			} else if (location.getLocType() == BDLocation.TypeNetWorkException) {
//				sb.append("\ndescribe : ");
//				sb.append("缃戠粶涓嶅悓瀵艰嚧瀹氫綅澶辫触锛岃妫�鏌ョ綉缁滄槸鍚﹂�氱晠");
//			} else if (location.getLocType() == BDLocation.TypeCriteriaException) {
//				sb.append("\ndescribe : ");
//				sb.append("鏃犳硶鑾峰彇鏈夋晥瀹氫綅渚濇嵁瀵艰嚧瀹氫綅澶辫触锛屼竴鑸槸鐢变簬鎵嬫満鐨勫師鍥狅紝澶勪簬椋炶妯″紡涓嬩竴鑸細閫犳垚杩欑缁撴灉锛屽彲浠ヨ瘯鐫�閲嶅惎鎵嬫満");
//			}
//			sb.append("\nlocationdescribe : ");
//			sb.append(location.getLocationDescribe());// 浣嶇疆璇箟鍖栦俊鎭�
//			List<Poi> list = location.getPoiList();// POI鏁版嵁
//			if (list != null) {
//				sb.append("\npoilist size = : ");
//				sb.append(list.size());
//				for (Poi p : list) {
//					sb.append("\npoi= : ");
//					sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
//				}
//			}
//			Log.i("BaiduLocationApiDem", sb.toString());*/
//		}
//	}
	// public int getLocType ( )
	/**
	 * 浣嶇疆鎻愰啋浣跨敤
	 */
	/**
	 * 浣嶇疆鎻愰啋鏈�澶氭彁閱�3娆★紝3娆¤繃鍚庡皢涓嶅啀鎻愰啋銆� 鍋囧闇�瑕佸啀娆℃彁閱掞紝鎴栬�呰淇敼鎻愰啋鐐瑰潗鏍囷紝閮藉彲閫氳繃鍑芥暟SetNotifyLocation()鏉ュ疄鐜般��
	 * //浣嶇疆鎻愰啋鐩稿叧浠ｇ爜 mNotifyer = new NotifyLister();
	 * mNotifyer.SetNotifyLocation(42.03249652949337
	 * ,113.3129895882556,3000,"gps"
	 * );//4涓弬鏁颁唬琛ㄨ浣嶇疆鎻愰啋鐨勭偣鐨勫潗鏍囷紝鍏蜂綋鍚箟渚濇涓猴細绾害锛岀粡搴︼紝璺濈鑼冨洿锛屽潗鏍囩郴绫诲瀷(gcj02,gps,bd09,bd09ll)
	 * mLocationClient.registerNotify(mNotifyer);
	 * //娉ㄥ唽浣嶇疆鎻愰啋鐩戝惉浜嬩欢鍚庯紝鍙互閫氳繃SetNotifyLocation 鏉ヤ慨鏀逛綅缃彁閱掕缃紝淇敼鍚庣珛鍒荤敓鏁堛��
	 * //BDNotifyListner瀹炵幇 public class NotifyLister extends BDNotifyListener{
	 * public void onNotify(BDLocation mlocation, float distance){
	 * mVibrator01.vibrate(1000);//鎸姩鎻愰啋宸插埌璁惧畾浣嶇疆闄勮繎 } } //鍙栨秷浣嶇疆鎻愰啋
	 * mLocationClient.removeNotifyEvent(mNotifyer);
	 */

}
