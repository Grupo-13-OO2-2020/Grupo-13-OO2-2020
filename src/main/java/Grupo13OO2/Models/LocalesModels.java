package Grupo13OO2.Models;


public class LocalesModels {
	private LocalModel PrimerLocal;
	private LocalModel SegundoLocal;
	
	
	public LocalesModels(LocalModel primerLocal, LocalModel segundoLocal) {
		super();
		PrimerLocal = primerLocal;
		SegundoLocal = segundoLocal;
	}
	
	
	public LocalModel getPrimerLocal() {
		return PrimerLocal;
	}
	public void setPrimerLocal(LocalModel primerLocal) {
		PrimerLocal = primerLocal;
	}
	public LocalModel getSegundoLocal() {
		return SegundoLocal;
	}
	public void setSegundoLocal(LocalModel segundoLocal) {
		SegundoLocal = segundoLocal;
	}
	
	

	
	
	
	
	
	
	
}