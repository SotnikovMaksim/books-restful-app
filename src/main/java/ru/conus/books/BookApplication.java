package ru.conus.books;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication
public class BookApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BookApplication.class)
                .beanNameGenerator(new FullyQualifiedAnnotationBeanNameGenerator())
                .run(args);
    }

}
