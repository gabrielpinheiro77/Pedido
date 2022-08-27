package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enumns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Bith Date (DD/MM/YYYY) : ");
		Date birthDate = sdf.parse(sc.next());
		Cliente cliente = new Cliente(name, email, birthDate);
		System.out.println("Enter order data: ");
		Date momentDate = new Date();
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(momentDate, OrderStatus.valueOf(status), cliente);
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		for(int i = 0; i<n;i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: $ ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			Product produto = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity, productPrice, produto);
			order.addItem(item);
		}
		
		System.out.println(order);
		
		
		sc.close();

	}

}
