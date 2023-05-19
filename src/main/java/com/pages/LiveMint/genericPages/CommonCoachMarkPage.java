package com.pages.LiveMint.genericPages;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCoachMarkPage {
    private static CommonCoachMarkPage commonCoachMarkPage;
    private static GlobalVars globalVars;

    public static CommonCoachMarkPage getInstance() {
        System.out.println("******************* beforeMethod 'CoachMark Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCoachMarkPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.IOS_NATIVE:
                    commonCoachMarkPage = new com.pages.LiveMint.ios_native.CoachMarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'CoachMark Page' ends here *******************");
        return commonCoachMarkPage;
    }

    public abstract boolean checkCoachMarkOnFirstLaunch();

    public abstract boolean checkCoachMarkSkipButton();

    public abstract boolean checkCoachMarkNextButton();

    public abstract boolean checkCoachMarkDoneButton();

    public abstract void checkAllNotification();

    public abstract boolean checkNewsAndExploreCoachMark();
}
