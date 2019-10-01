package ru.example.orders;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public abstract class BaseContractsTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        RestAssuredMockMvc.mockMvc(
                MockMvcBuilders
                        .webAppContextSetup(webApplicationContext)
                        .build()
        );
    }
}
