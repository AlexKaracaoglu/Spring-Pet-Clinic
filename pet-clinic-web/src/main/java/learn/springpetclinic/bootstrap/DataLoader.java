package learn.springpetclinic.bootstrap;

import learn.springpetclinic.model.Owner;
import learn.springpetclinic.model.PetType;
import learn.springpetclinic.model.Vet;
import learn.springpetclinic.services.OwnerService;
import learn.springpetclinic.services.PetTypeService;
import learn.springpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("FNO2");
        owner2.setLastName("LNO2");

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
