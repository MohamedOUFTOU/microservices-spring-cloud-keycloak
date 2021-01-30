package com.enset.billingservice.controlers;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.repositories.BillRepository;
import com.enset.billingservice.repositories.ProductItemRepository;
import com.enset.billingservice.services.CostumerServiceClient;
import com.enset.billingservice.services.ProductServiceClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BillRestControler {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CostumerServiceClient costumerServiceClient;
    private ProductServiceClient productServiceClient;

    public BillRestControler(BillRepository billRepository, ProductItemRepository productItemRepository, CostumerServiceClient costumerServiceClient, ProductServiceClient productServiceClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.costumerServiceClient = costumerServiceClient;
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/bills/full/{id}")
    Bill getBill(HttpServletRequest request,@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCostumer(costumerServiceClient.findCostumerById(request.getHeader("Authorization"),bill.getCostumerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productServiceClient.findProductById(request.getHeader("Authorization"),pi.getProductID()));
        });
        return bill;
    }

    @GetMapping("/bills/full")
    Page<Bill> getBills(HttpServletRequest request, Pageable pageable){
        Page<Bill> bills = billRepository.findAll(pageable);
        bills.forEach(bill -> {
            bill.setCostumer(costumerServiceClient.findCostumerById(request.getHeader("Authorization"),bill.getCostumerID()));
            bill.setProductItems(productItemRepository.findByBillId(bill.getId()));
            bill.getProductItems().forEach(pi->{
                pi.setProduct(productServiceClient.findProductById(request.getHeader("Authorization"),pi.getProductID()));
            });
        });

        return bills;
    }
}
