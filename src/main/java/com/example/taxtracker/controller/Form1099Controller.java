import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/forms")
public class Form1099Controller {
    @Autowired private UserRepository userRepo;
    @Autowired private IncomeRepository incomeRepo;
    @Autowired private Form1099Service form1099Service;

    @GetMapping("/1099/{userId}")
    public ResponseEntity<byte[]> download1099(@PathVariable Long userId) throws IOException {
        User user = userRepo.findById(userId).orElseThrow();
        List<Income> incomes = incomeRepo.findByUserId(userId);
        byte[] pdf = form1099Service.generate1099Form(user, incomes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("form-1099.pdf").build());

        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}
