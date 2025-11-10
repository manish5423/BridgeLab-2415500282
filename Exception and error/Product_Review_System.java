public class ProductReviewSystem {
    static class InvalidRatingException extends Exception { InvalidRatingException(String m){ super(m); } }
    static class EmptyReviewException extends Exception { EmptyReviewException(String m){ super(m); } }
    static void submitReview(int rating, String comment) throws InvalidRatingException, EmptyReviewException {
        if(rating < 1 || rating > 5) throw new InvalidRatingException("Rating must be 1 to 5");
        if(comment == null || comment.trim().isEmpty()) throw new EmptyReviewException("Review comment cannot be empty");
        System.out.println("Review accepted. Rating: " + rating + " Comment: " + comment);
    }
    public static void main(String[] args){
        try{
            submitReview(6, "Good");
        } catch(InvalidRatingException e){
            System.out.println("Rating error: " + e.getMessage());
        } catch(EmptyReviewException e){
            System.out.println("Review error: " + e.getMessage());
        }
        try{
            submitReview(4, "");
        } catch(InvalidRatingException e){
            System.out.println("Rating error: " + e.getMessage());
        } catch(EmptyReviewException e){
            System.out.println("Review error: " + e.getMessage());
        }
    }
}

