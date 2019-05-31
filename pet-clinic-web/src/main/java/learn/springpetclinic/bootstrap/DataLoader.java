package learn.springpetclinic.bootstrap;

import learn.springpetclinic.model.Owner;
import learn.springpetclinic.model.Pet;
import learn.springpetclinic.model.PetType;
import learn.springpetclinic.model.Vet;
import learn.springpetclinic.services.OwnerService;
import learn.springpetclinic.services.PetTypeService;
import learn.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("FNO1");
        owner1.setLastName("LNO1");
        owner1.setAddress("AddressO1");
        owner1.setCity("CityO1");
        owner1.setCity("PhoneO1");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(savedDogPetType);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("PetO1");
        owner1.getPets().add(owner1Pet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("FNO2");
        owner2.setLastName("LNO2");
        owner2.setAddress("AddressO2");
        owner2.setCity("CityO2");
        owner2.setCity("PhoneO2");

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(savedCatPetType);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setName("PetO2");
        owner2.getPets().add(owner2Pet);

        ownerService.save(owner2);

        System.out.println("Loaded owners!");

        Vet vet1 = new Vet();
        vet1.setFirstName("FNV1");
        vet1.setLastName("LNV1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("FNV2");
        vet2.setLastName("LNV2");

        vetService.save(vet2);

        System.out.println("Loaded vets!");

    }
}
