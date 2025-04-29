public class Comics extends Book {
    public Comics(String title, String author, String genre, int publicationYear) {
        super(title, author, genre, publicationYear);
    }

    @Override
    public Comics clone() {
        return (Comics) super.clone();
    }
}
