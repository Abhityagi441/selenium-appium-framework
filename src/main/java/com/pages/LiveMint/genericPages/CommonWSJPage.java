package com.pages.LiveMint.genericPages;
import com.pages.LiveMint.web.WSJPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonWSJPage {
    private static CommonWSJPage commonWSJPage;
    private static GlobalVars globalVars;

    public static CommonWSJPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars = GlobalVars.getInstance();
        if (commonWSJPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonWSJPage = new WSJPage();
                    break;
                case Constants.IOS_WEB:
                    commonWSJPage = new com.pages.LiveMint.ios_mweb.WSJPage();
                    break;

                case Constants.ANDROID_WEB:
                    commonWSJPage = new com.pages.LiveMint.android_mweb.WSJPage();
                    break;
            }

        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonWSJPage;
    }

    public abstract boolean checkWSJPagelayout() ;
       public abstract boolean checklshWSJPage();
    public abstract boolean checkTopNavLink();
    public abstract boolean checkrhsWSJPage();
    public abstract boolean checkWSJPagelayoutSubscribedUSer();
    public abstract boolean checkTopNavLinkSubscribeduser();
    public abstract boolean checklshWSJPageforSubscribedUser();
    public abstract boolean checkrHSNAVLinksforSubscribeduserWsj();
    public abstract boolean checkFirstStory();
    public abstract boolean checkFirstStoryWSjForSubscribedUser();

}
