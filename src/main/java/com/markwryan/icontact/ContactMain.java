package com.markwryan.icontact;

import org.robovm.apple.coregraphics.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.uikit.*;

public class ContactMain extends UIApplicationDelegateAdapter {

	private UIWindow window = null;
	private int clickCount = 0;

	@Override
	public boolean didFinishLaunching(UIApplication application,
			UIApplicationLaunchOptions launchOptions) {

		final UIButton button = UIButton.create(UIButtonType.RoundedRect);
		final UILabel label = new UILabel();
		label.setFrame(new CGRect(115.0d, 150.0d, 100d, 100d));
		
		button.setBackgroundColor(UIColor.cyan());
		button.setFrame(new CGRect(115.0d, 121.0d, 91.0d, 37.0d));
		button.setTitle("Click me!", UIControlState.Normal);

		button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside(UIControl control, UIEvent event) {
				label.setText("Click # " + (++clickCount));
				button.setTitle("Click Me!", UIControlState.Normal);
			}
		});

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setBackgroundColor(UIColor.lightGray());
		window.addSubview(label);
		window.addSubview(button);
		window.makeKeyAndVisible();

		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, ContactMain.class);
		pool.close();
	}
}