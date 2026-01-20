package custom_type;

import domain_objects.BillingDetails;
import domain_objects.Product;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {
    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry){
        return new BillingDetails(
                entry.get("FirstName"),
                entry.get("LastName"),
                entry.get("StreetAddress"),
                entry.get("City"),
                entry.get("ZIPCode"),
                entry.get("Phone"),
                entry.get("Email"));
    }
    @DataTableType
    public Product productEntry(String name){
        return new Product(name);
    }
}


