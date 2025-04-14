// --- AuthService.java ---
@Service
public class AuthService {
    @Autowired private UserRepository userRepository;

    public User register(User user) {
        // password hashing, mfa flag logic here
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password)); // hash check in real app
    }
}
