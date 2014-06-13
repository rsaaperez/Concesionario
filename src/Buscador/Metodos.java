/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rsaaperez
 */
public class Metodos {

    //Creamos un metodo para comprobar si existen las cartas.
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

    //Creamos un metodo para crear los objetos y llamar a insertar en la clase conexion.
    public static void insertar(String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa) {
        Cartas c = null;
        Conexion cox = new Conexion();
        if (existe(nombre) == false) {
            switch (tipo) {
                case "criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "tierra":
                    c = new Tierra(habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
            }
        }
    }

    //Creamos un metodo para crear los objetos y llamar a editar en la clase conexion.
    public static void editar(String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa) {
        Cartas c = null;
        Conexion cox = new Conexion();
        if (existe(nombre) == true) {
            switch (tipo) {
                case "criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
                case "encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
                case "artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
                case "instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
                case "conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
                case "tierra":
                    c = new Tierra(habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombre);
                    break;
            }
        }
    }


    /*public static Criatura pedirCriatura(File fich) {
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
     }*/
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
}
