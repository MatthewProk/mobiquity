package api;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static testutils.TestGroups.IMPLEMENTED;

public class MQ_0000_03_MobiquityTest3 {

    @Description("Preconditions: there is simple test 3" +
            "Complete TEST 3")
    @Title("Completing the test 3")
    @Test(groups = {IMPLEMENTED})
    public void mq_test_0000_02() {
        fail("This tests is needed to be failed!");
    }
}
