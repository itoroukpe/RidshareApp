import javax.persistence.*;          // For Entity, Id, GeneratedValue, etc.
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.io.IOException;



// --- Expense.java (Entity) ---
@Entity
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Double amount;
    private String description;
    private LocalDate date;
    @ManyToOne private User user;
}
