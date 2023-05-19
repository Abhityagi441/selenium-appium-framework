package com.pages.LiveMint.genericPages;
import com.pages.LiveMint.web.PhotosPage;
import com.pages.LiveMint.web.WSJPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPhotosPage {
    private static CommonPhotosPage commonPhotosPage;
    private static GlobalVars globalVars;

    public static CommonPhotosPage getInstance()
    {
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars = GlobalVars.getInstance();
        if(commonPhotosPage==null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                   commonPhotosPage= new PhotosPage();
                    break;

                case Constants.ANDROID_WEB:
                    commonPhotosPage=new com.pages.LiveMint.android_mweb.PhotosPage();
                    break;
                case Constants.IOS_WEB:
                    commonPhotosPage=new com.pages.LiveMint.ios_mweb.PhotosPage();
                    break;
            }

        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPhotosPage;
    }

    public abstract boolean checkPhotoPagelayout(String URL) ;
    public abstract boolean checkPhotosView(String URL);


}
