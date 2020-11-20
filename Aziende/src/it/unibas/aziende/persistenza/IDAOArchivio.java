package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Archivio;

public interface IDAOArchivio {
    public Archivio carica() throws DAOException;
}
