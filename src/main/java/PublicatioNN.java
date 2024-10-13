import java.time.LocalDateTime;

public class PublicatioNN {
	
	    private String contenu;
	    private LocalDateTime tempsPublication;
	    private String auteur;

	    public void Publication(String contenu, LocalDateTime tempsPublication, String auteur) {
	        this.contenu = contenu;
	        this.tempsPublication = tempsPublication;
	        this.auteur = auteur;
	    }

	    public String getContenu() {
	        return contenu;
	    }

	    public LocalDateTime getTempsPublication() {
	        return tempsPublication;
	    }

	    public String getAuteur() {
	        return auteur;
	    }
	}