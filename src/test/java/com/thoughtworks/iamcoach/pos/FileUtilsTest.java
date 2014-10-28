package com.thoughtworks.iamcoach.pos;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileUtilsTest {
    @Test
    public void getTest() throws IOException {

        FileUtils fileUtils = mock(FileUtils.class);
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("line1", "line2", "line3");

        List list = fileUtils.get("cart.txt");
        assertThat(list.size()).isEqualTo(9);
    }
}
