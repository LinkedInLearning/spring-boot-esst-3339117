package linkedin.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DirtySecretsRestController.class)
public class DirtySecretsRestControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DirtySecretsRepository repository;

  @Test
  public void shouldSaveSecrets() throws Exception {
    // Mock Repository initialisieren
    var mockSecret = new DirtySecret();
    mockSecret.setId("test-123");
    when(this.repository.save(any())).thenReturn(mockSecret);

    // Controller aufrufen
    this.mockMvc
        .perform(MockMvcRequestBuilders.post("/dirty-secrets")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"name\": \"Linda\", \"secret\": \"Cheated her son into Stanford.\" }"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
  }

}
