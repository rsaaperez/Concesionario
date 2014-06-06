/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;

import java.io.*;

/**
 *
 * @author mperezsilva
 */
public class NuestroStream extends ObjectOutputStream {

    @Override
    protected void writeStreamHeader() throws IOException {
        // este método evita que apareza o encabezado cada vez que engadimos un rexistro no ficheiro
    }

    public NuestroStream(OutputStream o) throws IOException {
        super(o);
    }
}

