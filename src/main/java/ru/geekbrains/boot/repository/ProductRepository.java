package ru.geekbrains.boot.repository;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.boot.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductRepository {
    EntityManagerFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();
    EntityManager em = factory.createEntityManager();

    public List<Product> getAllProducts() {
        List<Product> allProducts = em.createQuery("from Product").getResultList();
        return allProducts;
    }
// Поиск по ID я реализовал, но в форме он ведь никуда не выводится и пока никак не используется. В задании было, я сдедал!
    public Product findProductById(long id) {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        return product;
    }
// Вот тут у меня вопрос. Я не совсем понял разницу между merge и persist. Я ппц сколько тут времени потерял пытаясь
// запушить объект в базу через персист. Каждый раз получал ошибку. Я правильно понимаю, что если объект создан не в
// рамках текущей сессии гибернейта, то он всегда detached? Следовательно его можно только мерджить?
    public void addProductToDB(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    public void deleteProductById(long id) {
        em.getTransaction().begin();
        Product productToDelete = em.find(Product.class, id);
        em.remove(productToDelete);
        em.getTransaction().commit();
    }
}
