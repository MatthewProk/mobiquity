package api;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertTrue;
import static testutils.TestGroups.IMPLEMENTED;

public class MQ_0000_01_MobiquityTest1 {

    @Description("Preconditions: there is simple test 1" +
            "Complete TEST 1")
    @Title("Completing the test 1")
    @Test(groups = {IMPLEMENTED})
    public void mq_test_0000_01() {
        assertTrue(true);
    }
}
