package com.pages.Healthshots.generic;
import com.pages.Healthshots.web.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHomePage {
    private static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;

    public static CommonHomePage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonHomePage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                	commonHomePage= new HomePage();
                    break;
          /*      case Constants.ANDROID_WEB:
                    commonHomePage = new com.pages.Healthshots.AndroidWebPages.HomePage();
                    break;
                    */
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHomePage;
    }
    public abstract boolean checkTwitterSharingFromLatestStory(String email, String password);
    public abstract boolean checkFacebookSharingFromLatestStory(String email, String password);

}
