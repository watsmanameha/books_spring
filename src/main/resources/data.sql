truncate table books restart identity cascade;

insert into books (title, author, published_year, description) values
                                                                   ('Clean Code','Robert C. Martin', 1999, 'A handbook'),
                                                                   ('Refactoring','Martin Fowler', 2000, 'Improving the design of existing code');
