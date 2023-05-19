package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.BookmarkPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBookmarkPage {
    private static CommonBookmarkPage commonBookmarkPage;
    private static GlobalVars globalVars;

    public static CommonBookmarkPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonBookmarkPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.IOS_NATIVE:
                    commonBookmarkPage = new BookmarkPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonBookmarkPage = new com.pages.LiveMint.android_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBookmarkPage;
    }

public abstract boolean checkBookmarkFunctionalityRedirectionToLoginPage();
    public abstract boolean checkBookmarkFunctionalityRedirectionAfterLogin(String email, String password);
    public abstract boolean checkBookmarkFunctionalityRedirectionAsSubscribedUser(String email, String password);
public abstract boolean checkBookmarkFunctionalityOnStoryDetailPage();
public abstract boolean checkBookmarkPageEmptyForNonLoggedUser();
public abstract boolean checkBookmarkStoryOnBookmarkPage(String email, String password);
}
