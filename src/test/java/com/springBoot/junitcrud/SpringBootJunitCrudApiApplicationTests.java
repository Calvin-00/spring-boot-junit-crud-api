package com.springBoot.junitcrud;

import com.springBoot.junitcrud.model.Shop;
import com.springBoot.junitcrud.repository.ShopRepo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringBootJunitCrudApiApplicationTests {

	@Autowired
	ShopRepo shopRepo;

	@Test
	@Order(1)
	public void testSave(){
		Shop s = new Shop();
		s.setId(1L);
		s.setName("Banana");
		s.setPrice(500.00);
		shopRepo.save(s);
//		assertNotNull(shopRepo.findById(1L).get());  //get method
		assertNotNull(shopRepo.findById(1L));
	}

	@Test
	@Order(2)
	public void testReadAll(){   //testing all products in the shop
		List <Shop> list =shopRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleProduct () {   // testing a single product in the shop
		Shop s = shopRepo.findById(1L).get();
		assertEquals("Banana", s.getName());
	}

	@Test
	@Order(4)
	public void testUpdate () {
		Shop s = shopRepo.findById(1L).get();
		s.setPrice(800.00);
		shopRepo.save(s);
		assertNotEquals(500.00, shopRepo.findById(1L).get().getPrice());
	}

	@Test
	@Order(5)
	public void testDelete () {
		shopRepo.deleteById(1L);
		assertThat(shopRepo.existsById(1L)).isFalse();
	}

}
