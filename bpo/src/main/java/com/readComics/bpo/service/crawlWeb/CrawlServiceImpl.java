package com.readComics.bpo.service.crawlWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.readComics.bpo.repositories.categoryRepository.ICategoryRepository;
import com.readComics.bpo.repositories.productRepository.IProductRepository;
import com.readComics.bpo.utils.FileService;

@Service
@Transactional
public class CrawlServiceImpl implements ICrawService {

	@Autowired
	private FileService fileService;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IAuthorRepository authorRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

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
	public Map<String, String> getInforComic(String url) {
		Map<String, String> comicsMap = new HashMap<>();

		try {
			Document document = Jsoup.connect(url).get();

			Element element = document.getElementsByClass("list-stories").first();

			Elements elements = element.getElementsByTag("li");

			for (Element e : elements) {
				Product product = new Product();

				AuthorComic author = new AuthorComic();

				Element tagAComic = e.getElementsByTag("a").first();

				Element tagPComic = e.getElementsByTag("p").first();

				product.setNameProduct(tagAComic.attr("title"));

				product.setUrlComic(tagAComic.attr("href"));

				author.setNameAuthor(tagPComic.text());

				if (!authorRepository.existsAuthorComicByNameAuthor(author.getNameAuthor())) {

					authorRepository.save(author);
				}

				if (!productRepository.existsProductByNameProduct(product.getNameProduct())) {

					product.setAuthor(author);

					productRepository.save(product);
				}

				comicsMap.put(product.getNameProduct(), author.getNameAuthor());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comicsMap;

	}

	@Override
	public void getCateogryOfComic(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getDetailComic() {

		List<Product> listProduct = productRepository.findAll();

		try {
			for (Product p : listProduct) {

				Document document = Jsoup.connect(p.getUrlComic()).get();

				Element element = document.getElementById("story-detail");

				Element imgComic = element.getElementsByTag("img").first();

				p.setImg(imgComic.attr("href"));

				Element categoryComicList = element.getElementsByClass("story_categories").first();

				Elements categoryComic = categoryComicList.getElementsByTag("a");

				String categoryStr = "";

				for (Element e : categoryComic) {
					if (!e.equals(categoryComic.last())) {

						if (categoryRepository.existsCategoryByNameCategory(e.attr("title"))) {

							categoryStr += e.attr("title") + "-";
						}
					} else {
						if (categoryRepository.existsCategoryByNameCategory(e.attr("title"))) {

							categoryStr += e.attr("title");
						}
					}

				}
				
				p.setCategory(categoryStr);
				
				Element elementDescription = element.getElementsByClass("description").first();
				
				System.out.println(elementDescription.text());
				
				p.setDescription(elementDescription.text());
				
				Element divInforComic = element.getElementsByClass("infos").first();
				
				Element viewComicElement = divInforComic.getElementsByTag("p").get(3);
				
//				p.setView(Integer.parseInt(viewComicElement.text()));
				
				System.out.println("view comic: " + viewComicElement.text());
				
				Thread.sleep(1500);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listProduct;
	}

	@Override
	public List<Chapter> getDetailChapter() {
		// TODO Auto-generated method stub
		return null;
	}

}
