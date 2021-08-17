package com.sahakian.controller;


import com.sahakian.controller.upload.UploadController;
import com.sahakian.controller.upload.UploadControllerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ContextConfiguration(classes = {UploadController.class})
@WebMvcTest(UploadControllerImpl.class)
class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMultipleFilesUploadRestController() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "Example.xml",
                "application/xml", this.getClass().getResourceAsStream("Example.xml"));

        mockMvc
                .perform(MockMvcRequestBuilders.multipart("/upload").file(file))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
