package com.coderhouse.Clase8;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.model.Invoice;
import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.repository.ProductRepository;
import com.coderhouse.Clase8.repository.InvoiceRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productoRepository;
	@Autowired
	private ClienteRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;


	public static void main(String[] args) {
		SpringApplication.run(Clase8Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");


		//Creación de Productos

		try {
			Product taza = new Product();
			taza.setTitle("Taza");
			taza.setCode("79055100495");
			taza.setDescription("Puede contener hasta 400mL");
			taza.setPrice(100);
			taza.setStock(100);
			this.productoRepository.save(taza);

			Product buzo = new Product();
			buzo.setTitle("Buzo GAP");
			buzo.setCode("82746260035");
			buzo.setDescription("Diferentes colores especiales para esta temporada invernal");
			buzo.setPrice(5000);
			buzo.setStock(250);
			this.productoRepository.save(buzo);

			Product zapatillas = new Product();
			zapatillas.setTitle("Zapatillas Superstar");
			zapatillas.setCode("02485673645");
			zapatillas.setDescription("Adidas de cuero");
			zapatillas.setPrice(10000);
			zapatillas.setStock(100);
			this.productoRepository.save(zapatillas);

			Product escoba = new Product();
			escoba.setTitle("Escoba");
			escoba.setCode("94383746535");
			escoba.setDescription("Limpia cualquier superficie");
			escoba.setPrice(500);
			escoba.setStock(100);
			this.productoRepository.save(escoba);

			Product celular = new Product();
			celular.setTitle("Iphone 13");
			celular.setCode("04093847535");
			celular.setDescription("Ultima generación");
			celular.setPrice(1000);
			celular.setStock(200);
			this.productoRepository.save(celular);

        Optional<Product> productoObtenido = this.productoRepository.findById(10);

		if (productoObtenido.isPresent()) System.out.println(productoObtenido.get());
		else System.out.println("No se encontró el producto.");

			//Creación de Clientes

			Cliente cliente1 = new Cliente();
			cliente1.setName("Juana");
			cliente1.setLastname("Sanchez");
			cliente1.setDocnumber("36943886");
			this.clientRepository.save(cliente1);

			Cliente cliente2 = new Cliente();
			cliente2.setName("German");
			cliente2.setLastname("Rodriguez");
			cliente2.setDocnumber("25837447");
			this.clientRepository.save(cliente2);

			Cliente cliente3 = new Cliente();
			cliente3.setName("Braian");
			cliente3.setLastname("Chavez");
			cliente3.setDocnumber("43525388");
			this.clientRepository.save(cliente3);

			Cliente cliente4 = new Cliente();
			cliente4.setName("Fernanda");
			cliente4.setLastname("Gonzales");
			cliente4.setDocnumber("22832005");
			this.clientRepository.save(cliente4);

			Cliente cliente5 = new Cliente();
			cliente5.setName("Irina");
			cliente5.setLastname("Hernandez");
			cliente5.setDocnumber("34702334");
			this.clientRepository.save(cliente5);

        Optional<Cliente> clienteSeleccionado = this.clientRepository.findById(1);

		if (clienteSeleccionado.isPresent()) System.out.println(clienteSeleccionado.get());
		else System.out.println("No se encontró el cliente.");

			//Creación de Invoice/Facturas

			Optional<Cliente> Juana = this.clientRepository.findById(1);

			Invoice invoice1 = new Invoice();
			Juana.ifPresent(invoice1::setClient);
			invoice1.setCreated_at("13-03");
			invoice1.setTotal(500);
			this.invoiceRepository.save(invoice1);

			Invoice invoice2 = new Invoice();
			Juana.ifPresent(invoice2::setClient);
			invoice2.setCreated_at("15-03");
			invoice2.setTotal(500);
			this.invoiceRepository.save(invoice2);

			Optional<Cliente> German = this.clientRepository.findById(2);

			Invoice invoice3 = new Invoice();
			German.ifPresent(invoice3::setClient);
			invoice3.setCreated_at("15-03");
			invoice3.setTotal(500);
			this.invoiceRepository.save(invoice3);

			Invoice invoice4 = new Invoice();
			German.ifPresent(invoice4::setClient);
			invoice4.setCreated_at("15-03");
			invoice4.setTotal(1000);
			this.invoiceRepository.save(invoice4);

			Juana = this.clientRepository.findById(1);
			System.out.println(Juana.get().getInvoice());

		} catch(Exception e) {
			System.out.println(e.getMessage());
			}



	}
}
