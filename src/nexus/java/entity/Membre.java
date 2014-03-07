
package nexus.java.entity;

public class Membre {

	private int idMembre;
        private String nom;
	private String prenom;
	private String adresse;
	private String sexe;
	private int codePostal;
	private String ville;
	private String pays;
        private String login;
	private String mdpasse;
	

	public Membre() {
	}

	public Membre(int idMembre) {
		this.idMembre = idMembre;
	}

	public Membre(int idMembre, String login, String mdpasse, String nom, String prenom, String adresse, String sexe,
			int codePostal, String ville, String pays) {
		this.idMembre = idMembre;
		this.login = login;
		this.mdpasse = mdpasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sexe = sexe;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		
	}

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdpasse() {
        return mdpasse;
    }

    public void setMdpasse(String mdpasse) {
        this.mdpasse = mdpasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
	
}

