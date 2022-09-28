package com.readComics.bpo.service.crawlWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.readComics.bpo.model.AuthorComic;
import com.readComics.bpo.model.Category;
import com.readComics.bpo.model.Chapter;
import com.readComics.bpo.model.Product;
import com.readComics.bpo.repositories.authorRepository.IAuthorRepository;
import com.readComics.bpo.repositories.productRepository.IProductRepository;
import com.readComics.bpo.utils.FileService;

@Service
@Transactional
public class CrawlServiceImpl implements ICrawService {

	@Autowired
	FileService fileService;
	
	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	IAuthorRepository authorRepository;

	public void getConnectWithWeb() {

		try {
			Document document = Jsoup.connect("https://dtruyen.com/truyen-dich/").get();

			Element element = document.getElementsByClass("categories clearfix").first();

			Elements elements = element.getElementsByTag("a");

			System.out.println(document);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProductFormWeb(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> getProductFromWeb(String url) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Category> getAllCategory(String url) {
		List<Category> categoryList = new ArrayList();
		try {
			Document document = Jsoup.connect(url).get();

			Element element = document.getElementsByClass("categories clearfix").first();

			Elements elements = element.getElementsByTag("a");

			for (Element e : elements) {

				Category category = new Category();

				category.setNameCategory(e.attr("title"));

				categoryList.add(category);
			}

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryList;
	}

	@Override
	public Optional<Category> getCategoryFromWeb(String url) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Chapter> getAllChapterOfProductFromWeb(String url, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorComic> getAllAuthorComicFromWeb(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getNameComic(String url) {
		try {
			List<String> urlComic = new ArrayList();
			
			Document document = Jsoup.connect(url).get();
			
			Element element = document.getElementsByClass("list-stories").first();
			
			Elements elements = element.getElementsByTag("li");
			
			for(Element e : elements ) {
				Product product = new Product();
				
				AuthorComic author = new AuthorComic();
				
				Element tagAComic = e.getElementsByTag("a").first();
				
				Element tagPComic = e.getElementsByTag("p").first();
				
				product.setNameProduct(tagAComic.attr("title"));
				
				author.setNameAuthor(tagPComic.text());
				
				urlComic.add(tagAComic.attr("href"));
				
				authorRepository.save(author);
				
				product.setAuthor(author);
				
				productRepository.save(product);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getAuthorComic(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getImgComic(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getCateogryOfComic(String url) {
		// TODO Auto-generated method stub

	}

}
