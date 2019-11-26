package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

//        Original method by John Thompson
//        int petTypeCount = petTypeService.findAll().size();
//
//        if (petTypeCount == 0 ) {
//            loadData();
//        }

        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }

    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("DOG");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("CAT");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Owner markSnow = new Owner();
        markSnow.setFirstName("Mark");
        markSnow.setLastName("Snow");
        markSnow.setAddress("Prosta 25");
        markSnow.setCity("Warsaw");
        markSnow.setTelephone("+48 725 589 632");

        Pet markSnowsPet = new Pet();
        markSnowsPet.setName("Lara");
        markSnowsPet.setPetType(savedDogPetType);
        markSnowsPet.setOwner(markSnow);
        markSnowsPet.setBirthDate(LocalDate.of(2014, 5, 24));
        markSnow.getPets().add(markSnowsPet);

        ownerService.save(markSnow);

        Owner lanaLang = new Owner();
        lanaLang.setFirstName("Lana");
        lanaLang.setLastName("Lang");
        lanaLang.setAddress("Wspolna 36");
        lanaLang.setCity("Krakow");
        lanaLang.setTelephone("+48 785 471 968");

        Pet lanaLangsPet = new Pet();
        lanaLangsPet.setName("Filemon");
        lanaLangsPet.setPetType(savedCatPetType);
        lanaLangsPet.setOwner(lanaLang);
        lanaLangsPet.setBirthDate(LocalDate.of(2018, 11, 17));
        lanaLang.getPets().add(lanaLangsPet);

        ownerService.save(lanaLang);

        System.out.println("Loaded owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription("RADIOLOGY");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("SURGERY");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("DENTISTRY");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded specialties...");

        Vet nadiaThompson = new Vet();
        nadiaThompson.setFirstName("Nadia");
        nadiaThompson.setLastName("Thompson");
        nadiaThompson.getSpecialties().add(savedRadiology);

        Vet adamDwayne = new Vet();
        adamDwayne.setFirstName("Adam");
        adamDwayne.setLastName("Dwayne");
        adamDwayne.getSpecialties().add(savedSurgery);
        adamDwayne.getSpecialties().add(savedDentistry);

        vetService.save(nadiaThompson);
        vetService.save(adamDwayne);

        System.out.println("Loaded vets...");
    }
}
