package com.fkhrayef.day20.Controller;

import com.fkhrayef.day20.Model.Customer;
import com.fkhrayef.day20.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    @PostMapping("")
    public ApiResponse addCustomer(@RequestBody Customer customer) {
        int id = 1;
        if (!customers.isEmpty()) {
            id = customers.get(customers.size() - 1).getId() + 1;
        }
        if (customer.getBalance() < 0) {
            return new ApiResponse("Invalid Balance, Must Be Positive!", "400");
        } else {
            customers.add(new Customer(id, customer.getUsername(), customer.getBalance()));
            return new ApiResponse("Customer Added Successfully!", "200");
        }
    }

    @PutMapping("/{customerId}")
    public ApiResponse updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        // Get the customer by their id
        Customer customerToUpdate = null;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                customerToUpdate = c;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (customerToUpdate != null) {
            customerToUpdate.setUsername(customer.getUsername());
            customerToUpdate.setBalance(customer.getBalance());
            return new ApiResponse("Customer Updated Successfully!", "200");
        } else {
            return new ApiResponse("Customer Not Found!", "404");
        }
    }

    @PutMapping("/{customerId}/deposit")
    public ApiResponse depositCustomer(@PathVariable("customerId") int customerId, @RequestParam("amount") double amount) {
        // Get the customer by their id
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }

        // Deposit amount
        if (customer != null) {
            customer.setBalance(customer.getBalance() + amount);
            return new ApiResponse(amount + " Deposited Successfully!", "200");
        } else {
            return new ApiResponse("Customer Not Found!", "404");
        }
    }

    @PutMapping("/{customerId}/withdrawal")
    public ApiResponse withdrawCustomer(@PathVariable("customerId") int customerId, @RequestParam("amount") double amount) {
        // Get the customer by their id
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }

        // Withdraw amount if feasible
        if (customer != null) {
            if (customer.getBalance() >= amount) {
                customer.setBalance(customer.getBalance() - amount);
                return new ApiResponse(amount + " Withdrawn Successfully!", "200");
            } else {
                return new ApiResponse("Insufficient Fund!", "400");
            }
        } else {
            return new ApiResponse("Customer Not Found!", "404");
        }
    }

    @DeleteMapping("/{customerId}")
    public ApiResponse deleteCustomer(@PathVariable("customerId") int customerId) {
        // Get the customer by their id
        Customer customerToDelete = null;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                customerToDelete = c;
                break;
            }
        }

        // If found, update it. If not, return not found!
        if (customerToDelete != null) {
            customers.remove(customerToDelete);
            return new ApiResponse("Customer Deleted Successfully!", "200");
        } else {
            return new ApiResponse("Customer Not Found!", "404");
        }
    }

}
