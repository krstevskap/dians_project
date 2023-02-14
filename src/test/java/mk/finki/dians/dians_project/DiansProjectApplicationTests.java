package mk.finki.dians.dians_project;

import mk.finki.dians.dians_project.service.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
class DiansProjectApplicationTests {

    MockMvc mockMvc;

    @Autowired
    UserService userService;

    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac)  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        initData();
    }

    private void initData(){
        if(!dataInitialized){
            String user="userTest";
            userService.register(user,user,user,user,user,user);

            dataInitialized=true;
        }
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetHomePage() throws Exception {
        MockHttpServletRequestBuilder productRequest = MockMvcRequestBuilders.get("/home");

        this.mockMvc.perform(productRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void testMapPage() throws Exception {
        MockHttpServletRequestBuilder mapRequest = MockMvcRequestBuilders.get("/maps");
        this.mockMvc.perform(mapRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("maps"));
    }

}
