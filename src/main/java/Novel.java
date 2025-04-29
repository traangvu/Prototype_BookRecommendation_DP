public class Novel extends Book {
    public Novel(String title, String author, String genre, int publicationYear) {
        super(title, author, genre, publicationYear);
    }

    @Override
    public Novel clone() {
        return (Novel) super.clone();
    }
}
