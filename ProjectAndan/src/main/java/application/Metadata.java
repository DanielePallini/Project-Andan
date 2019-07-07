package data;

/**
 * Classe che descrive i metadati
 * 
 * @author Andrea Giuliani Daniele Pallini
 *
 */

public class Metadata {
    private String alias;
    private String sourceField;
    private String type;
	public Metadata() {
		
	}
	/**
	 * 
	 * Costruttore di un oggetto metadata
	 * 
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
	public Metadata(String alias, String sourceField, String type) {
	
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	
	/**
	 * Restituisce l'alias del campo considerato
	 * @return alias l'alias del campo
	 */

	public String getAlias() {
		return alias;
	}
	
	/**
	 * Imposta l'alias 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	/**
	 * Restituisce il nome del campo considerato nel file
	 * @return sourceField nome del campo
	 */
	public String getSourceField() {
		return sourceField;
	}
	
	/**
	 * Imposta il nome del campo nell'oggetto metadata
	 * @param sourceField
	 */
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	
	/**
	 * Restituisce il tipo dei dati del campo considerato
	 * @return type tipo dei dati del campo
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Imposta il tipo dei dati del campo considerato
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}

