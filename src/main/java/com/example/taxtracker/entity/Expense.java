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
