package edu.iu.c322.assetmanagement.licensingservice.controller;

import edu.iu.c322.assetmanagement.licensingservice.model.License;
import edu.iu.c322.assetmanagement.licensingservice.repository.LicenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    /*

    private final WebClient orderService;

    public AssetsController(WebClient.Builder webClientBuilder) {
        assetsService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }


    @GetMapping("/{id}")
    public Invoice findByLicenseId(@PathVariable int orderId){
        Order order =  orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .bodyToMono(Order.class).block();
        Invoice invoice = new Invoice();
        invoice.setTotal(order.total());
        invoice.setPayment(order.payment());
        // add the rest of the data items
        return invoice;
    }
    */


    private LicenseRepository repository;

    public AssetsController(LicenseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<License> getAssets(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Assets> getAssetsById(@PathVariable int id){
        return repository.findById(id);
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Assets assets){
        Assets addedLicense = repository.save(assets);
        return addedLicense.getId();
    }
     */

}
