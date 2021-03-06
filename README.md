
		
## Project Andan
Il progetto ha l'obiettivo di creare una API che, tramite chiamate di tipo GET, restituisca dati, metadati e statistiche riguardo i tumori riscontrati in Italia nell'anno 2011. Il link contenente il JSON di partenza è il seguente: "https://www.dati.gov.it/api/3/action/package_show?id=4754c863-f86f-47ae-b105-dc9963227c34".
L'Applicazione effettua il download del file csv dal link presente all'interno del JSON sopra e con quello effettua il parsing della classe Tumore.
Tramite chiamate di tipo GET accessibili con diverse querystring l'Applicazione restituisce dati, metadati e statistiche dei diversi campi presenti nel file csv. C'è la possibilità in fase di richiesta di inserire filtri, in quel caso l'Applicazione restituisce solo gli oggetti della classe Tumore che rispettano le condizioni inserite dall'utente.
È possibile fare richiesta di 5 diversi campi: "periodo", "territorio", "patologia", "maschi", "femmine". I primi tre campi sono di tipo String, le operazioni di filtraggio svolte sono quelle del conteggio elementi unici e dell'operatore "not", che restituisce tutti i record del file csv che non sono uguali alla stringa passata.
"maschi" e "femmine", invece, sono campi di tipo int. Di seguito le operazioni svolte per questi ultimi: media, massimo, minimo, deviazione standard, conteggio elementi unici, somma.
Anche qui è presente la possibilità di inserire filtri in fase di richiesta: si può scrivere nella query string <, >, ==, not, and e dopo uno"/" il valore da confrontare per utilizzare quell'operatore come confronto.
L'utente ha la possibilità di effettuare le seguenti chiamate GET; *le parentesi graffe, dove presenti, stanno ad indicare che all'interno bisogna inserire i valori che si desidera cercare:*

 - [ ] */data*

	Restituisce tutti i record della classe Tumore ottenuti dal file csv.
	
	![Diagramma delle sequenze per i dati](https://lh3.googleusercontent.com/YBWslfkIucUl1FZRx7acz94OLai9NMGuVpxLr9MJUVDp-DRa6zbDpl_0nezw23E3suz0D73WaLE)

 - [ ] /data/{field}/{operator}/{value}
 
	Restituisce i record del csv che rispettano i filtri stabiliti in fase di richiesta. "field" è il campo, "operator" è l'operatore di confronto, value è il valore di confronto(può essere stringa o intero). Gli operatori disponibili sono "<, >, ==, not".
	
![Diagramma delle sequenze per i dati filtrati](https://lh3.googleusercontent.com/L5XeQQfGH43Egl111wak-B2C3wMcuvVQ006JiSBY1yiIW_mUTGSfDY5bjS6HFWWR1kXEs6f7WaY)
 - [ ] */data/{field1}/{value1}/{field2}/{value2}*
 
	Implementa il filtro AND. Restituisce i record del csv che rispettano *entrambi* i filtri stabiliti in fase di richiesta. "field1", "field2" sono i due campi richiesti, " value 1" è il valore che deve avere field 1," value 2" è il valore che deve avere "field 2".
	
	![Diagramma delle sequenze per l'AND](https://lh3.googleusercontent.com/sDhRv16-IDRJE5cmSjrI03iYhO589o6y2DmnqMJZuZg0HoIhpAKNM9xTYQ84XY52DDjjX9KKeWQ)
 - [ ] */metadata*
	Restituisce i metadati del file csv, cioè alias, nome del campo e tipo per ciascuno dei 5 campi della classe Tumore.
	
![Diagramma delle sequenze per i metadati](https://lh3.googleusercontent.com/qaH90WDvi_wSC-SDNIkfGAWvj4asWLuUAJRgOTDATJbhF8fcbQ-W3Q7LtmMpqNtHFAg3easkZ4Q)
 - [ ] */stats/{field}*
	Restituisce le statistiche del campo specificato in "field". Se il campo è di tipo int("maschi" o "femmine") l'Applicazione restituisce le operazioni media, massimo, minimo, deviazione standard, conteggio elementi unici, somma. Se invece il campo inserito è di tipo String ("periodo", "territorio", patologia"), la restituzione sarà il conteggio degli elementi unici con relativa stampa.
	
![Diagramma delle sequenze per le stats](https://lh3.googleusercontent.com/iTH1ffpuuzOpkLerDhYFHEuIsEMkf-QzcdjNb_LWqovsKAuGOHSTMvAgbk-lngUg9BurQYQa_L4)
 - [ ] */stats/{field}/{operator}/{value}*
 
	 Restituisce le statistiche del campo specifcato in "field" filtrato con l'operatore "operator" e con il valore "value". Se il campo è di tipo int, le operazioni disponibili sono <, >, ==, not; se il campo è di tipo String, indipendentemente da "operator", restituisce il numero di volte che il valore "value" è presente nel file csv.
	 
![Diagramma delle sequenze delle statistiche filtrate](https://lh3.googleusercontent.com/skJWlP7Mj7VTUNPElX3uNHgsFL4EVnPSpW5vHA-M8ah375rdkqLOWrvyp9HKAoGYH3-lGpZ13j4)

Questo è invece il diagramma dei casi d'uso:

![Diagramma dei casi d'uso](https://lh3.googleusercontent.com/28kv12EmyDrDQoTDR_LAwwO1insFgCI_sUO6WDN8-1mRvLpWHNTH7q5N6H7qEfC4ggKtx3w7UA4)

N.B Per una migliore visualizzazione fare riferimento a https://ibb.co/Zhv6mYT

Infine, di seguito il diagramma delle classi della nostra Application.

![Diagramma delle classi](https://lh3.googleusercontent.com/eReF19E9Lqit1WdcrFmUdfojR65SYKGne_t4657OC_DWHWEhKccke-7LDTRqnZ3Ei3Z06Tq7f1k)

N.B Per una migliore visualizzazione fare riferimento a https://ibb.co/7X02xfK

Enjoy!

				Andrea Giuliani Daniele Pallini

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEwMjIxODQ4MiwtMzM5NjgxNjQzLDc2MD
EzNDc0MV19
-->