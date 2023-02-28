import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {
    private CSV csvReader;

    @Before
    public void setUp() {
        csvReader = new CSV("test.csv");
    }

    @Test
    public void testReadCSV() {
        List<String[]> data = (List<String[]>) csvReader.read();

        // Verificar el número de filas
        assertEquals(4, data.size());

        // Verificar el número de columnas
        String[] headers = data.get(0);
        assertEquals(3, headers.length);
        for (String[] row : data) {
            assertEquals(3, row.length);
        }

        // Verificar los nombres de las etiquetas de las cabeceras
        assertEquals("Nombre", headers[0]);
        assertEquals("Apellido", headers[1]);
        assertEquals("Edad", headers[2]);

        // Verificar el número que se asigna a cada fila
        assertEquals("1", data.get(1)[0]);
        assertEquals("2", data.get(2)[0]);
        assertEquals("3", data.get(3)[0]);

        // Verificar que las filas recuperadas contienen los mismos valores que se guardaron
        String[] row1 = {"1", "Juan", "Perez", "25"};
        String[] row2 = {"2", "Ana", "Garcia", "30"};
        String[] row3 = {"3", "Pedro", "Lopez", "40"};
        assertTrue(compareRows(row1, data.get(1)));
        assertTrue(compareRows(row2, data.get(2)));
        assertTrue(compareRows(row3, data.get(3)));
    }

    private boolean compareRows(String[] row1, String[] row2) {
        if (row1.length != row2.length) {
            return false;
        }

        for (int i = 0; i < row1.length; i++) {
            if (!row1[i].equals(row2[i])) {
                return false;
            }
        }

        return true;
    }
}
