
class Temperatura {
    private String gLunes;
    private String gMartes;
    private String gMiercoles;
    private String gJueves;
    private String gViernes;
    private String gSabado;
    private String gDomingo;
    
    public Temperatura(String gLunes, String gMartes, String gMiercoles, String gJueves, String gViernes, String gSabado, String gDomingo) {
    	this.setgLunes(gLunes);
    	this.setgMartes(gMartes);
    	this.setgMiercoles(gMiercoles);
    	this.setgJueves(gJueves);
    	this.setgViernes(gViernes);
    	this.setgSabado(gSabado);
    	this.setgDomingo(gDomingo);
    }

	public String getgDomingo() {
		return gDomingo;
	}

	public void setgDomingo(String gDomingo) {
		this.gDomingo = gDomingo;
	}

	public String getgSabado() {
		return gSabado;
	}

	public void setgSabado(String gSabado) {
		this.gSabado = gSabado;
	}

	public String getgViernes() {
		return gViernes;
	}

	public void setgViernes(String gViernes) {
		this.gViernes = gViernes;
	}

	public String getgJueves() {
		return gJueves;
	}

	public void setgJueves(String gJueves) {
		this.gJueves = gJueves;
	}

	public String getgMiercoles() {
		return gMiercoles;
	}

	public void setgMiercoles(String gMiercoles) {
		this.gMiercoles = gMiercoles;
	}

	public String getgMartes() {
		return gMartes;
	}

	public void setgMartes(String gMartes) {
		this.gMartes = gMartes;
	}

	public String getgLunes() {
		return gLunes;
	}

	public void setgLunes(String gLunes) {
		this.gLunes = gLunes;
	}
}


