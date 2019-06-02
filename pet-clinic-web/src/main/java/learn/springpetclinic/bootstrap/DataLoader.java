package learn.springpetclinic.bootstrap;

import learn.springpetclinic.model.*;
import learn.springpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
    
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("Specialty1");
        Specialty savedSpecialty1 = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Specialty2");
        Specialty savedSpecialty2 = specialtyService.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("Specialty3");
        Specialty savedSpecialty3 = specialtyService.save(specialty3);

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

        Visit visit = new Visit();
        visit.setPet(owner2Pet);
        visit.setDate(LocalDate.now());
        visit.setDescription("Visit for owner 2's pet");

        visitService.save(visit);

        System.out.println("Loaded owners!");

        Vet vet1 = new Vet();
        vet1.setFirstName("FNV1");
        vet1.setLastName("LNV1");
        vet1.getSpecialties().add(savedSpecialty1);
        vet1.getSpecialties().add(savedSpecialty3);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("FNV2");
        vet2.setLastName("LNV2");
        vet1.getSpecialties().add(savedSpecialty2);

        vetService.save(vet2);

        System.out.println("Loaded vets!");
    }
}
