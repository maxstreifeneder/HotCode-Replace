package com.maxstreifeneder.hotreload.handlers;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import cds.gen.catalogservice.Books;
import com.maxstreifeneder.hotreload.handlers.CatalogServiceHandler;

public class CatalogServiceHandlerTest {

	private CatalogServiceHandler handler = new CatalogServiceHandler();
	private Books book = Books.create();

	@Before
	public void prepareBook() {
		book.setTitle("title");
	}

	@Test
	public void testDiscount() {
		book.setStock(500);
		handler.discountBooks(Stream.of(book));
		assertEquals("title (discounted)", book.getTitle());
	}

	@Test
	public void testNoDiscount() {
		book.setStock(100);
		handler.discountBooks(Stream.of(book));
		assertEquals("title", book.getTitle());
	}

	@Test
	public void testNoStockAvailable() {
		handler.discountBooks(Stream.of(book));
		assertEquals("title", book.getTitle());
	}

}