package com.KeaweAquarian.ExpenseTracker;

import com.KeaweAquarian.ExpenseTracker.Repository.CategoryRepository;

//@Configuration
public class DbConfig {
    private CategoryRepository categoryRepository;

    public DbConfig(CategoryRepository categoryRepository){
        super();
        this.categoryRepository = categoryRepository;
    }

//        @Bean
//        CommandLineRunner commandLineRunner(
//                CategoryRepository repository){
//            return args -> {
//                 Category cat1 = new Category(
//                        1L,
//                        "Auto Loan "
//                );
//                Category cat2 = new Category(
//                        2L,
//                        "House Loan "
//                );
//                Category cat3 = new Category(
//                        3L,
//                        "Bank Loan "
//                );
//                repository.saveAll(
//                        List.of(cat1, cat2, cat3 )
//                );
//            };
//        }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            UserRepository repository2){
//        return args -> {
//            User cat4 = new User(
//                    1L,
//                    "Ken ", "ken@gmail.com", null
//            );
//            User cat5 = new User(
//                    2L,
//                    "Rich ", "Rich@gmail.com", null
//            );
//            User cat6 = new User(
//                    3L,
//                    "Tim ", "Time@gmail.com", null
//            );
//            repository2.saveAll(
//                    List.of(cat4, cat5, cat6 )
//            );
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            ExpenseRepository repository){
//        return args -> {
//
//            Expense cat1 = new Expense(100L, null, " new York" ,new Category(
//                    1,
//                    "Auto Loan ", null
//            ),new User(
//                    1L,
//                    "Ken ", "ken@gmail.com", null
//            ));
//            Expense cat2 = new Expense(101L, null, " ford" ,new Category(
//                    1,
//                    "Auto Loan ", null
//            ),new User(
//                    1L,
//                    "Ken ", "ken@gmail.com", null
//            ));
//            Expense cat3 = new Expense(102L, null, " grand" ,new Category(
//                    1,
//                    "Auto Loan ", null
//            ),new User(
//                    1L,
//                    "Ken ", "ken@gmail.com", null
//            ));
//            repository.saveAll(
//                    List.of(cat1, cat2, cat3 )
//            );
//        };
//    }

}
