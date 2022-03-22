package Mezcla;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Random;

    public class MezclaNaturalEjemplo3 {

        public static class Lector
                implements mezcla1.Lector<BigInteger> {

            private final ObjectInputStream ois;
            private BigInteger siguienteEntero;

            public Lector(File archivo) {
                try {
                    ois = new ObjectInputStream(new FileInputStream(archivo));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                leerSiguienteEntero();
            }

            @Override
            public boolean hasNext() {
                return siguienteEntero != null;
            }

            @Override
            public BigInteger next() {
                BigInteger entero = siguienteEntero;
                leerSiguienteEntero();
                return entero;
            }

            // Leer por adelantado el siguiente elemento para
            // retornar el valor correcto en hasNext().
            private void leerSiguienteEntero() {
                try {
                    siguienteEntero = (BigInteger) ois.readObject();
                } catch (EOFException e) {
                    siguienteEntero = null;
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void close() throws IOException {
                ois.close();
            }
        }

        public static class Escritor
                implements mezcla1.Escritor<BigInteger> {

            private final ObjectOutputStream oos;

            public Escritor(File archivo) {
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(archivo));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void accept(BigInteger s) {
                try {
                    oos.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void close() throws IOException {
                oos.close();
            }
        }

        public static void crearArchivoBinario(String archivo) throws IOException {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo, false))) {
                int num_bits = 9;
                Random r = new Random();
                for (int i = 0; i < 200; ++i) {
                    oos.writeObject(new BigInteger(num_bits, r));
                }
            }
        }

        public static void main(String[] args) throws Exception {
            crearArchivoBinario("enteros_grandes.ser");
            mezcla1<BigInteger> ordernamiento =
                    new mezcla1<>(Lector::new, Escritor::new);
            File entrada = new File("enteros_grandes.ser");
            ordernamiento.verificarOrdenamiento(entrada);
            ordernamiento.ordenar(entrada);
            ordernamiento.desplegar(entrada);
            ordernamiento.verificarOrdenamiento(entrada);
        }

    }

