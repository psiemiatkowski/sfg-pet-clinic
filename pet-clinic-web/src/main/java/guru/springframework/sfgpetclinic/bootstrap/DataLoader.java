package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");

        PetType cat = new PetType();
        cat.setName("cat");

        petTypeService.save(dog);
        petTypeService.save(cat);

        System.out.println("Loaded pet types...");

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
