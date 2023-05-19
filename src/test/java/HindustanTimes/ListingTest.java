package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonListingPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListingTest extends BaseTest {
    private static CommonListingPage listingPage;


    @BeforeMethod
    public void beforeMethod(){
        listingPage=CommonListingPage.getInstance();
    }


    @Author(name = "Mahantesh")
    @Description("QAAUT-522(web),QAAUT-546(android-mweb),QAAUT-632(amp), QAAUT-902(ios_amp), QAAUT-570(ios-mweb) : To verify pagination is working on listing pages")
    @Test
    public void verifyPaginationIsWorkingOnListingPages() {
        boolean isStepTrue = false;
        isStepTrue = listingPage.checkPaginationWorkingOnListingPages();
        Assert.assertTrue(isStepTrue, "check Pagination working on Listing pages has been Failed");
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-654(ios-amp): To verify 'view more' button is working on listing pages")
    @Test
    public void verifyViewMoreButtonOnListingPages() {
        boolean isStepTrue = false;
        isStepTrue = listingPage.checkViewMoreButtonOnListingPages();
        Assert.assertTrue(isStepTrue, "check view more button on Listing pages has been Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1436(Android-amp): To verify scroll on page is working")
    @Test
    public void verifyScrollDownOnListingPages() {
        boolean isStepTrue = false;
        isStepTrue = listingPage.scrollDownToBottomOfTheWorldNewsPage();
        Assert.assertTrue(isStepTrue, "check view more button on Listing pages has been Failed");
    }
}
