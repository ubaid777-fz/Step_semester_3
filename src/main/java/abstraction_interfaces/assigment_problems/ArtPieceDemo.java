abstract class ArtPiece {
    static int counter = 1;
    final String pieceId;

    ArtPiece() {
        pieceId = "P" + counter++;
    }

    abstract String describe();

    String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    String title;

    Painting(String title) {
        this.title = title;
    }

    String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    String title;

    Sculpture(String title) {
        this.title = title;
    }

    String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class ArtPieceDemo {
    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());
        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}
