public class CharacterWrapperUse {
    public static void main(String[] args){
        String input = "Hello123! @2025";
        int letters = 0;
        int digits = 0;
        int specials = 0;
        for(char ch : input.toCharArray()){
            if(Character.isLetter(ch)) letters++;
            else if(Character.isDigit(ch)) digits++;
            else if(Character.isWhitespace(ch)){}
            else specials++;
        }
        System.out.println("Total letters: " + letters);
        System.out.println("Total digits: " + digits);
        System.out.println("Total special characters: " + specials);
    }
}

