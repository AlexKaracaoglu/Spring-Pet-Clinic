package learn.springpetclinic.bootstrap;

import learn.springpetclinic.model.Owner;
import learn.springpetclinic.model.Vet;
import learn.springpetclinic.services.OwnerService;
import learn.springpetclinic.services.VetService;
import learn.springpetclinic.services.map.OwnerServiceMap;
import learn.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    private final OwnerService ownerService;
    private final VetService vetService;
    

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("FN1");
        owner1.setLastName("LN1");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("FN2");
        owner2.setLastName("LN2");

        ownerService.save(owner2);

        System.out.println("Loaded owners!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("FN1");
        vet1.setLastName("LN1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("FN2");
        vet2.setLastName("LN2");

        vetService.save(vet2);

        System.out.println("Loaded vets!");

    }
}
