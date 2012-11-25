package uk.co.villainrom.pulser.disablebatteryfullalert;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class DisableBatteryFullAlert implements IXposedHookLoadPackage {
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		// TODO Auto-generated method stub
		if (lpparam.packageName.equals("com.android.systemui")) 
		{
			try {
				findAndHookMethod("com.android.systemui.power.PowerUI", lpparam.classLoader, "notifyFullBatteryNotification",
						XC_MethodReplacement.DO_NOTHING);
			} catch (Throwable t) { XposedBridge.log(t); }
		
		}
	};
	

}
