package com.traveleasy.backend;

import com.traveleasy.backend.support.TestMailConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestMailConfig.class)
class TravelEasyBackendApplicationTests {

    @Test
    void contextLoads() {
    }
}
