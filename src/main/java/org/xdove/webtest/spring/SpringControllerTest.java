package org.xdove.webtest.spring;

import com.alibaba.fastjson.JSONObject;
import lombok.Setter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.xdove.webtest.AbstractWebTest;
import org.xdove.webtest.context.Context;
import org.xdove.webtest.DataProtocol;
import org.xdove.webtest.IDFetch;
import org.xdove.webtest.asserts.ResultAssert;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@EnableTransactionManagement
@Transactional
@Setter
public abstract class SpringControllerTest extends AbstractWebTest {

    protected ResultAssert<MvcResult> resultAssert;
    protected IDFetch idFetch;
    protected DataProtocol dataProtocol;
    protected Context context;

    @Autowired
    protected MockMvc mvc;

}
