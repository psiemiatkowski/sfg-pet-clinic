package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner markSnow = new Owner();
        markSnow.setFirstName("Mark");
        markSnow.setLastName("Snow");

        Owner lanaLang = new Owner();
        lanaLang.setFirstName("Lana");
        lanaLang.setLastName("Lang");

        ownerService.save(markSnow);
        ownerService.save(lanaLang);

        System.out.println("Loaded owners...");

        Vet nadiaThompson = new Vet();
        nadiaThompson.setFirstName("Nadia");
        nadiaThompson.setLastName("Thompson");

        Vet adamDwayne = new Vet();
         adamDwayne.setFirstName("Adam");
        adamDwayne.setLastName("Dwayne");

        vetService.save(nadiaThompson);
        vetService.save(adamDwayne);

        System.out.println("Loaded vets...");


    }
}
