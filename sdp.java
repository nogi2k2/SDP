// Visitor 1
interface Visitor1 {
    void visit(Book book);
    void visit(Dvd dvd);
}

class Visitor1Impl implements Visitor1 {
    @Override
    public void visit(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }

    @Override
    public void visit(Dvd dvd) {
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Star: " + dvd.getStar());
    }
}

// Visitor 2
interface Visitor2 {
    void visit(Item item);
}

class Visitor2Impl implements Visitor2 {
    @Override
    public void visit(Item item) {
        System.out.println("Title: " + item.getTitle());
        System.out.println("Price: " + item.getPrice());
        if (item instanceof Book) {
            Book book = (Book) item;
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
        } else if (item instanceof Dvd) {
            Dvd dvd = (Dvd) item;
            System.out.println("Star: " + dvd.getStar());
        }
    }
}

// Visitable
interface Visitable {
    void accept(Visitor1 visitor);
    void accept(Visitor2 visitor);
}

class Book extends Item implements Visitable {
    private String author;
    private String publisher;

    public Book(String title, int price, String author, String publisher) {
        super(title, price);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public void accept(Visitor1 visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(Visitor2 visitor) {
        visitor.visit(this);
    }
}

class Dvd extends Item implements Visitable {
    private String star;

    public Dvd(String title, int price, String star) {
        super(title, price);
        this.star = star;
    }

    public String getStar() {
        return star;
    }

    @Override
    public void accept(Visitor1 visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(Visitor2 visitor) {
        visitor.visit(this);
    }
}
