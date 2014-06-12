/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.Instantaneo;
import Objetos.Tierra;
import Objetos.Encantamiento;
import Objetos.Conjuro;
import Objetos.Criatura;
import Objetos.Cartas;
import Objetos.Artefacto;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rsaaperez
 */
public class Metodos {

    public static boolean existe(String nomeBuscar) {
        Conexion cox = new Conexion();
        Cartas aux[][] = null;
        boolean existe = false;
        try {
            aux = (Cartas[][]) cox.seleccionarLista();
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < aux[i].length; j++) {
                    if (aux[i][j].getNombre().compareToIgnoreCase(nomeBuscar) == 0) {
                        existe = true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("erro existe " + ex.getMessage());
        } finally {
            return existe;
        }
    }

    //Creamos un metodo para que el usuario pueda añadir sus propias cartas.
    public static void insertar(File fichero, File fcria, File fencan, File finst, File fart, File ftier, File fconj) {
        Criatura cria = null;
        Encantamiento encan = null;
        Conjuro conj = null;
        Instantaneo instan = null;
        Artefacto arte = null;
        Tierra ti = null;
        NuestroStream fich = null;
        NuestroStream fcri = null;
        NuestroStream fen = null;
        NuestroStream fin = null;
        NuestroStream far = null;
        NuestroStream ft = null;
        NuestroStream fcon = null;
        int menu = Integer.parseInt(JOptionPane.showInputDialog("¿Que tipo de carta desea introducir?\n1.-Criatura.\n2.-Encantamiento.\n3.-Instantaneo.\n4.-Conjuro.\n5.-Artefacto.\n6.-Tierra.\n7.-Dejar de introducir cartas."));
        switch (menu) {
            case 1:
                cria = pedirCriatura(fcria);
                break;
            case 2:
                encan = pedirEncantamiento(fencan);
                break;
            case 3:
                instan = pedirInstantaneo(finst);
                break;
            case 4:
                conj = pedirConjuro(fconj);
                break;
            case 5:
                arte = pedirArtefacto(fart);
                break;
            case 6:
                ti = pedirTierra(ftier);
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Programa finalizado.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna opcion permitida.");
        }

        try {
            fich = new NuestroStream(new FileOutputStream(fichero, true));
            fcri = new NuestroStream(new FileOutputStream(fcria, true));
            fen = new NuestroStream(new FileOutputStream(fencan, true));
            fin = new NuestroStream(new FileOutputStream(finst, true));
            far = new NuestroStream(new FileOutputStream(fart, true));
            ft = new NuestroStream(new FileOutputStream(ftier, true));
            fcon = new NuestroStream(new FileOutputStream(fconj, true));
            if (menu == 1) {
                fich.writeObject(new Criatura(cria.getCmc(), cria.getColor(), cria.getHabilidad(), cria.getFuerza(), cria.getDefensa(), cria.getNombre(), cria.getTipo(), cria.getRareza()));
                fcri.writeObject(new Criatura(cria.getCmc(), cria.getColor(), cria.getHabilidad(), cria.getFuerza(), cria.getDefensa(), cria.getNombre(), cria.getTipo(), cria.getRareza()));
            }
            if (menu == 2) {
                fich.writeObject(new Encantamiento(encan.getCmc(), encan.getColor(), encan.getHabilidad(), encan.getNombre(), encan.getTipo(), encan.getRareza()));
                fen.writeObject(new Encantamiento(encan.getCmc(), encan.getColor(), encan.getHabilidad(), encan.getNombre(), encan.getTipo(), encan.getRareza()));
            }
            if (menu == 3) {
                fich.writeObject(new Instantaneo(instan.getCmc(), instan.getColor(), instan.getHabilidad(), instan.getNombre(), instan.getTipo(), instan.getRareza()));
                fin.writeObject(new Instantaneo(instan.getCmc(), instan.getColor(), instan.getHabilidad(), instan.getNombre(), instan.getTipo(), instan.getRareza()));
            }
            if (menu == 4) {
                fich.writeObject(new Conjuro(conj.getCmc(), conj.getColor(), conj.getHabilidad(), conj.getNombre(), conj.getTipo(), conj.getRareza()));
                fcon.writeObject(new Conjuro(conj.getCmc(), conj.getColor(), conj.getHabilidad(), conj.getNombre(), conj.getTipo(), conj.getRareza()));
            }
            if (menu == 5) {
                fich.writeObject(new Artefacto(arte.getCmc(), arte.getColor(), arte.getHabilidad(), arte.getNombre(), arte.getTipo(), arte.getRareza()));
                far.writeObject(new Artefacto(arte.getCmc(), arte.getColor(), arte.getHabilidad(), arte.getNombre(), arte.getTipo(), arte.getRareza()));
            }
            if (menu == 6) {
                fich.writeObject(new Tierra(ti.getHabilidad(), ti.getNombre(), ti.getTipo(), ti.getRareza()));
                ft.writeObject(new Tierra(ti.getHabilidad(), ti.getNombre(), ti.getTipo(), ti.getRareza()));
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            if (fich != null) {
                try {
                    fich.close();
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static Criatura pedirCriatura(File fich) {
        String nombre = null, color = null, rareza = null, habilidad = null, tipo = null;
        int cmc = 0, fuerza = -1, defensa = -1;
        Criatura carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre de la criatura que deseas añadir:");
            String cmana = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la criatura:");
            cmc = Integer.parseInt(cmana);
            color = JOptionPane.showInputDialog("Introduce el color o colores de la criatura:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza de la criatura:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades de la criatura:");
            do {
                String cf = JOptionPane.showInputDialog("Introduce su fuerza:");
                if (Integer.parseInt(cf) >= 0 && Integer.parseInt(cf) <= 15) {
                    fuerza = Integer.parseInt(cf);
                }
            } while (fuerza < 0 || fuerza > 15);
            do {
                String cd = JOptionPane.showInputDialog("Introduce su defensa:");
                if (Integer.parseInt(cd) >= 0 && Integer.parseInt(cd) <= 15) {
                    defensa = Integer.parseInt(cd);
                }
            } while (defensa < 0 || defensa > 15);
            tipo = "Criatura";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    public static Encantamiento pedirEncantamiento(File fich) {
        String nombre = null, color = null, rareza = null, habilidad = null, tipo = null;
        int cmc = 0;
        Encantamiento carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre del encantamiento que deseas añadir:");
            String emana = JOptionPane.showInputDialog("Introduce el coste de mana convertido del encantamiento:");
            cmc = Integer.parseInt(emana);
            color = JOptionPane.showInputDialog("Introduce el color o colores del encantamiento:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza del encnatamiento:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades del encantamiento:");
            tipo = "Encantamiento";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    public static Instantaneo pedirInstantaneo(File fich) {
        String nombre, color, rareza, habilidad, tipo;
        int cmc;
        Instantaneo carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre del instantaneo que deseas añadir:");
            String imana = JOptionPane.showInputDialog("Introduce el coste de mana convertido del instantaneo:");
            cmc = Integer.parseInt(imana);
            color = JOptionPane.showInputDialog("Introduce el color o colores del instantaneo:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza del instantaneo:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades del instantaneo:");
            tipo = "Instantaneo";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    public static Conjuro pedirConjuro(File fich) {
        String nombre, color, rareza, habilidad, tipo;
        int cmc;
        Conjuro carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre del conjuro que deseas añadir:");
            String comana = JOptionPane.showInputDialog("Introduce el coste de mana convertido del conjuro:");
            cmc = Integer.parseInt(comana);
            color = JOptionPane.showInputDialog("Introduce el color o colores del conjuro:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza del conjuro:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades del conjuro:");
            tipo = "Conjuro";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    public static Artefacto pedirArtefacto(File fich) {
        String nombre, color, rareza, habilidad, tipo;
        int cmc;
        Artefacto carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre del artefacto que deseas añadir:");
            String amana = JOptionPane.showInputDialog("Introduce el coste de mana convertido del artefacto:");
            cmc = Integer.parseInt(amana);
            color = JOptionPane.showInputDialog("Introduce el color o colores del artefacto:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza del artefacto:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades del artefacto:");
            tipo = "Artefacto";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    public static Tierra pedirTierra(File fich) {
        String nombre, color, rareza, habilidad, tipo;
        Tierra carta = null;
        boolean x = false;
        do {
            nombre = JOptionPane.showInputDialog("Introduce el nombre de la tierra que deseas añadir:");
            rareza = JOptionPane.showInputDialog("Introduce la rareza de la tierra:");
            habilidad = JOptionPane.showInputDialog("Introduce la habilidad o habilidades de la tierra:");
            tipo = "Tierra";
            boolean bol = existe(nombre);
            if (bol = true) {
                carta = new Tierra(habilidad, nombre, tipo, rareza);
                x = true;
            } else {
                JOptionPane.showMessageDialog(null, "Carta ya existente vuelva a intentarlo");
            }
        } while (x = false);
        return carta;
    }

    //Creamos un metodo que lea un fichero que contenga una serie de cartas.
    public static void leerLista(File fichero) {
        ObjectInputStream fich = null;
        Cartas aux = null;
        System.out.println("*****listado Cartas***** ");
        try {
            fich = new ObjectInputStream(new FileInputStream(fichero));
            aux = (Cartas) fich.readObject();
            while (fich != null) {
                //System.out.println(aux.toString());
                JOptionPane.showMessageDialog(null, aux);
                aux = (Cartas) fich.readObject();
            }
        } catch (EOFException e) {
            System.out.println("fin ficheiro " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("erro " + ex.getMessage());
        } finally {
            try {
                fich.close();
            } catch (IOException ex) {
                System.out.println("erro no peche ");
            }
        }
    }

    public static void buscar(File fich, File cria, File encan, File inst, File art, File tier, File conj) {
        //Scanner sc = null;
        Cartas c = null;
        Criatura cri = null;
        Encantamiento en = null;
        Conjuro con = null;
        Instantaneo in = null;
        Artefacto ar = null;
        Tierra t = null;
        int x = 0;
        ObjectInputStream ficha = null;
        boolean existe = false;
        try {
            String menu = JOptionPane.showInputDialog("¿De que tipo es la carta que buscas?\n1.-Criatura.\n2.-Encantamiento.\n3.-Conjuro.\n4.-Instantaneo.\n5.-Artefacto.\n6.-Tierra.");
            x = Integer.parseInt(menu);
            String opcion;
            try {

                switch (x) {

                    case 1:
                        String cartacri;
                        do {
                            int criatura = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Coste de mana convertido.\n4.-Color.\n5.-Habilidad.\n6.-Fuerza.\n7.-Defensa."));
                            if (criatura == 1) {
                                String ncria = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getNombre().compareToIgnoreCase(ncria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 3) {
                                String coscria = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la carta");
                                int cocri = Integer.parseInt(coscria);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getCmc() == cocri) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 4) {
                                String colcria = JOptionPane.showInputDialog("Introduce el color de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getColor().compareToIgnoreCase(colcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 5) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 6) {
                                int cfuerza = -1;
                                do {
                                    String fcria = JOptionPane.showInputDialog("Introduce la fuerza de la carta");
                                    if (Integer.parseInt(fcria) >= 0 && Integer.parseInt(fcria) <= 15) {
                                        cfuerza = Integer.parseInt(fcria);
                                    }
                                } while (cfuerza < 0 || cfuerza > 15);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getFuerza() == cfuerza) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (criatura == 7) {
                                int cdef = -1;
                                do {
                                    String dcria = JOptionPane.showInputDialog("Introduce la defensa de la carta");
                                    if (Integer.parseInt(dcria) >= 0 && Integer.parseInt(dcria) <= 15) {
                                        cdef = Integer.parseInt(dcria);
                                    }
                                } while (cdef < 0 || cdef > 15);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(cria));
                                    cri = (Criatura) ficha.readObject();
                                    while (fich != null) {
                                        if (cri.getDefensa() == cdef) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, cri);
                                            cri = (Criatura) ficha.readObject();
                                        }
                                    }

                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe == false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    case 2:
                        do {
                            int encantamiento = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Coste de mana convertido.\n4.-Color.\n5.-Habilidad.\n"));
                            if (encantamiento == 1) {
                                String ncria = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(encan));
                                    en = (Encantamiento) ficha.readObject();
                                    while (fich != null) {
                                        if (en.getNombre().compareToIgnoreCase(ncria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, en);
                                            en = (Encantamiento) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (encantamiento == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(encan));
                                    en = (Encantamiento) ficha.readObject();
                                    while (fich != null) {
                                        if (en.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, en);
                                            en = (Encantamiento) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (encantamiento == 3) {
                                String coscria = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la carta");
                                int cocri = Integer.parseInt(coscria);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(encan));
                                    en = (Encantamiento) ficha.readObject();
                                    while (fich != null) {
                                        if (en.getCmc() == cocri) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, en);
                                            en = (Encantamiento) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (encantamiento == 4) {
                                String colcria = JOptionPane.showInputDialog("Introduce el color de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(encan));
                                    en = (Encantamiento) ficha.readObject();
                                    while (fich != null) {
                                        if (en.getColor().compareToIgnoreCase(colcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, en);
                                            en = (Encantamiento) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (encantamiento == 5) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(encan));
                                    en = (Encantamiento) ficha.readObject();
                                    while (fich != null) {
                                        if (en.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, en);
                                            en = (Encantamiento) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe = false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada.");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    case 3:
                        do {
                            int conjuro = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Coste de mana convertido.\n4.-Color.\n5.-Habilidad.\n"));
                            if (conjuro == 1) {
                                String ncria = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(conj));
                                    con = (Conjuro) ficha.readObject();
                                    while (fich != null) {
                                        if (con.getNombre().compareToIgnoreCase(ncria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, con);
                                            con = (Conjuro) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (conjuro == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(conj));
                                    con = (Conjuro) ficha.readObject();
                                    while (fich != null) {
                                        if (con.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, con);
                                            con = (Conjuro) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (conjuro == 3) {
                                String coscria = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la carta");
                                int cocri = Integer.parseInt(coscria);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(conj));
                                    con = (Conjuro) ficha.readObject();
                                    while (fich != null) {
                                        if (con.getCmc() == cocri) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, con);
                                            con = (Conjuro) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (conjuro == 4) {
                                String colcria = JOptionPane.showInputDialog("Introduce el color de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(conj));
                                    con = (Conjuro) ficha.readObject();
                                    while (fich != null) {
                                        if (con.getColor().compareToIgnoreCase(colcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, con);
                                            con = (Conjuro) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (conjuro == 5) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(conj));
                                    con = (Conjuro) ficha.readObject();
                                    while (fich != null) {
                                        if (con.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, con);
                                            con = (Conjuro) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe = false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada.");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    case 4:
                        do {
                            int instantaneo = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Coste de mana convertido.\n4.-Color.\n5.-Habilidad.\n"));
                            if (instantaneo == 1) {
                                String ninst = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(inst));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getNombre().compareToIgnoreCase(ninst) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, in);
                                            in = (Instantaneo) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (instantaneo == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(inst));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, in);
                                            in = (Instantaneo) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (instantaneo == 3) {
                                String coscria = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la carta");
                                int cocri = Integer.parseInt(coscria);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(inst));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getCmc() == cocri) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, in);
                                            in = (Instantaneo) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (instantaneo == 4) {
                                String colcria = JOptionPane.showInputDialog("Introduce el color de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(inst));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getColor().compareToIgnoreCase(colcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, in);
                                            in = (Instantaneo) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (instantaneo == 5) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(inst));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, in);
                                            in = (Instantaneo) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe = false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada.");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    case 5:
                        do {
                            int artefacto = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Coste de mana convertido.\n4.-Color.\n5.-Habilidad.\n"));
                            if (artefacto == 1) {
                                String ncria = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(art));
                                    ar = (Artefacto) ficha.readObject();
                                    while (fich != null) {
                                        if (ar.getNombre().compareToIgnoreCase(ncria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, ar);
                                            ar = (Artefacto) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (artefacto == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(art));
                                    ar = (Artefacto) ficha.readObject();
                                    while (fich != null) {
                                        if (ar.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, ar);
                                            ar = (Artefacto) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (artefacto == 3) {
                                String coscria = JOptionPane.showInputDialog("Introduce el coste de mana convertido de la carta");
                                int cocri = Integer.parseInt(coscria);
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(art));
                                    ar = (Artefacto) ficha.readObject();
                                    while (fich != null) {
                                        if (ar.getCmc() == cocri) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, ar);
                                            ar = (Artefacto) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (artefacto == 4) {
                                String colcria = JOptionPane.showInputDialog("Introduce el color de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(art));
                                    ar = (Artefacto) ficha.readObject();
                                    while (fich != null) {
                                        if (ar.getColor().compareToIgnoreCase(colcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, ar);
                                            ar = (Artefacto) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (artefacto == 5) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(art));
                                    in = (Instantaneo) ficha.readObject();
                                    while (fich != null) {
                                        if (in.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, ar);
                                            ar = (Artefacto) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe = false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada.");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    case 6:
                        do {
                            int tierra = Integer.parseInt(JOptionPane.showInputDialog("¿Por que parametro quieres buscar?\n1.-Nombre.\n2.-Rareza.\n3.-Habilidad.\n"));
                            if (tierra == 1) {
                                String ncria = JOptionPane.showInputDialog("Introduce el nombre de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(tier));
                                    t = (Tierra) ficha.readObject();
                                    while (fich != null) {
                                        if (t.getNombre().compareToIgnoreCase(ncria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, t);
                                            t = (Tierra) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (tierra == 2) {
                                String rcria = JOptionPane.showInputDialog("Introduce la rareza de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(tier));
                                    t = (Tierra) ficha.readObject();
                                    while (fich != null) {
                                        if (t.getRareza().compareToIgnoreCase(rcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, t);
                                            t = (Tierra) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            } else if (tierra == 3) {
                                String hcria = JOptionPane.showInputDialog("Introduce la habilidad de la carta");
                                try {
                                    ficha = new ObjectInputStream(new FileInputStream(tier));
                                    t = (Tierra) ficha.readObject();
                                    while (fich != null) {
                                        if (t.getHabilidad().compareToIgnoreCase(hcria) == 0) {
                                            existe = true;
                                            JOptionPane.showMessageDialog(null, t);
                                            t = (Tierra) ficha.readObject();
                                        }
                                    }
                                } catch (EOFException e) {
                                    System.out.println("fin ficheiro " + e.getMessage());
                                }
                            }
                            if (existe = false) {
                                JOptionPane.showMessageDialog(null, "Carta no encontrada.");
                                opcion = "s";
                            } else {
                                opcion = JOptionPane.showInputDialog("¿Quieres buscar otra carta del mismo tipo por algun parametro mas? s/n");
                            }
                        } while (opcion.equals("s"));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No has selecciona ninguna de las opciones permitidas.");
                }
            } catch (Exception e) {
                System.out.println("Algo as introducido mal, vuelve a intentarlo. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error de Lectura" + e.getMessage());
        } finally {
            try {
                ficha.close();
            } catch (IOException ex) {
                System.out.println("erro no peche ");
            }
        }
    }

    public static void crearFicheiro(File ficheiro, File cria, File encan, File inst, File art, File tier, File conj) {
        //Tierra li = pedirTierra(ficheiro);
        // String aux = null; // para instanciar un obxecto tipo libro e escribilo no rexistro
        ObjectOutputStream fich = null;

        try {
            // abrimos ficheiro para engadir rexistros
            fich = new ObjectOutputStream(new FileOutputStream(ficheiro));
            fich = new ObjectOutputStream(new FileOutputStream(cria));
            fich = new ObjectOutputStream(new FileOutputStream(encan));
            fich = new ObjectOutputStream(new FileOutputStream(inst));
            fich = new ObjectOutputStream(new FileOutputStream(art));
            fich = new ObjectOutputStream(new FileOutputStream(tier));
            fich = new ObjectOutputStream(new FileOutputStream(conj));

        } catch (IOException ex) {
            System.out.println("error de escritura " + ex.getMessage());
        } finally {
            if (fich != null) {
                try {
                    fich.close();
                } catch (IOException ex) {
                    System.out.println("erro" + ex.getMessage());
                }
            }
        }
    }
}
