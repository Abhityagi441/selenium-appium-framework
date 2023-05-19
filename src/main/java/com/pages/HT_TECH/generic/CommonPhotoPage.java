package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.NewsPage;
import com.pages.HT_TECH.web.PhotoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPhotoPage {
    private static CommonPhotoPage commonPhotoPage;
    private static GlobalVars globalVars;

    public static CommonPhotoPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPhotoPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonPhotoPage = new PhotoPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPhotoPage;
    }
    public abstract boolean checkPagination();
    public abstract boolean checkPhotosStories();

    public abstract boolean checkURLChange();


}
