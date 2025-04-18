import org.springframework.data.jpa.repository.JpaRepository;


// --- UserRepository.java ---
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
