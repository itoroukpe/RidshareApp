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
