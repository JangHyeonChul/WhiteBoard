package com.moon.whiteboard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;



@SpringBootTest
class WhiteBoardApplicationTests {



    @AfterEach


    @Test
    void contextLoads() {

        int i = 1;
        Assertions.assertThat(i).isEqualTo(1);
    }

    @Test
    void contextLoads1() {

    }

}
