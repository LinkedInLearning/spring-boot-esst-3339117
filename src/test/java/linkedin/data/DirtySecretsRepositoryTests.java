package linkedin.data;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
class DirtySecretsRepositoryTests {

	@Autowired
	private DirtySecretsRepository repository;

	@Container
	@ServiceConnection
	static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(
			DockerImageName.parse("postgres:latest"));

	@Test
	void shouldSaveDirtySecretInPostgres() {
		// Secret erstellen
		var dirtySecret = new DirtySecret();
		dirtySecret.setName("Freddy");
		dirtySecret.setSecret("Killed an elderly couple and did time.");

		// Secret speichern
		var savedSecret = this.repository.save(dirtySecret);

		// Generierte Id prüfen
		assertNotNull(savedSecret.getId());
	}

}
