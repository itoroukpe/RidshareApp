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
