public class Main {

    public static void main(String[] args) {
        Administration administration = new Administration();
        TestAudio audio1 = new TestAudio("Adresse 1");
        TestAudio audio2 = new TestAudio("Adresse 2");
        TestAudio audio3 = new TestAudio("Adresse 3");
        administration.addToList(audio1);
        administration.addToList(audio2);
        administration.addToList(audio3);

        System.out.println(administration.listItems());
    }
}
