// --- Income.java (Entity) ---
@Entity
public class Income {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private Double amount;
    private LocalDate date;
    @ManyToOne private User user;
}
