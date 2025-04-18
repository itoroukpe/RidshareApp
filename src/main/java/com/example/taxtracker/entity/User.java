import javax.persistence.*;          // For Entity, Id, GeneratedValue, etc.
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.io.IOException;



// --- User.java (Entity) ---
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;
    private String password;
    private String role; // DRIVER, FLEET_OWNER, ADMIN
    private String incomeSources; // CSV (Uber, Lyft, etc.)
    private boolean aiEnabled;
    private boolean mfaEnabled;
}
