import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.taxtracker.repository.UserRepository;



// --- ProfileController.java ---

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired private UserRepository userRepo;

    @PostMapping("/setup")
    public ResponseEntity<?> setupProfile(@RequestBody User user) {
        return ResponseEntity.ok(userRepo.save(user));
    }
}
