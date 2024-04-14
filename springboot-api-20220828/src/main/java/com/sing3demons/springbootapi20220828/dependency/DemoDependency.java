package com.sing3demons.springbootapi20220828.dependency;

public class DemoDependency {
    public static void main(String[] args) {
        {
            Address address = new Address();
            address.setAddressNO("344/11");
            address.setAddressName("Bangkok...");
            Customer customer = new Customer(address);
            System.out.println(customer.getAddress().getAddressName());
            System.out.println(customer.getAddress().getAddressNO());
        }
        {
            Customer customer = new Customer();
            Address address = new Address();
            address.setAddressName("japan");
            address.setAddressNO("333");
            customer.setAddress(address);
            System.out.println(customer.getAddress().getAddressNO());
            System.out.println(customer.getAddress().getAddressName());

        }
    }
}
