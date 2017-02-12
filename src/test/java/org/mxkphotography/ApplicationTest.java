package org.mxkphotography;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringApplication.class)
public class ApplicationTest {

    @Test
    public void main() throws Exception {
        PowerMockito.mockStatic(SpringApplication.class);
        Application.main(new String[0]);
    }

}