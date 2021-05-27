package org.xdove.webtest.asserts;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MockSuccessAssert implements ResultAssert<MvcResult> {

    private DefaultMockResultAssert defaultMockResultAssert;
    private AssertContext context;
    private String url;

    public MockSuccessAssert(AssertContext context) {
        this.defaultMockResultAssert = new DefaultMockResultAssert();
        this.context = context;

    }

    public void getCheck(MvcResult r) {
        defaultMockResultAssert.getCheck(r);
    }

    public void updateCheck(MvcResult r) {
        defaultMockResultAssert.updateCheck(r);
        try {

            //TODO
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void createCheck(MvcResult r) {

    }

    public void deleteCheck(MvcResult r) {

    }
}
