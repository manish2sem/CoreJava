package CoreJava.J_Importent.CallBack.DeepMeaning;

public class WebSiteTimeUpdater {
	public static void main(String[] args) {
		System.out.println("Starting WebSiteTimeUpdater ...");
        SystemTimer SystemTimer = new SystemTimer();
        TimeUpdaterCallBack webSiteCallBackUpdater = new WebSiteTimeUpdaterCallBack();
        SystemTimer.registerCallBackForUpdatesEveryHour(webSiteCallBackUpdater);
    }

}
