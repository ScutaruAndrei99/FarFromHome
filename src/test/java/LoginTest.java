import com.tonevellah.farfromhome.DBUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class LoginTest {
    @Mock
    private Connection connectionAccount; // Mock pentru conexiunea la baza de date

    @Mock
    private PreparedStatement preparedStatement; // Mock pentru instrucțiunea preparată

    @Mock
    private ResultSet resultSet; // Mock pentru rezultatul interogării

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() throws Exception {
        DBUtils dbUtils = new DBUtils();

        when(connectionAccount.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        // Apelați metoda "registerUser" pe obiectul dvs.
//        dbUtils.registerUser(null, "testUser", "John", "Doe", "password123", "test@example.com");

        // Verificați dacă metodele corespunzătoare au fost apelate cu argumentele corecte
        verify(preparedStatement).setString(1, "testUser");
        // Verificați alte apeluri de metode și asigurați-vă că se comportă așa cum vă așteptați

    }

    @Test
    public void testLoginUser() throws Exception {
        DBUtils dbUtils = new DBUtils();

        when(connectionAccount.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        // Apelați metoda "loginUser" pe obiectul dvs.
//        dbUtils.loginUser(null, "testUser", "password123");

        // Verificați dacă metodele corespunzătoare au fost apelate cu argumentele corecte
        verify(preparedStatement).setString(1, "testUser");
        // Verificați alte apeluri de metode și asigurați-vă că se comportă așa cum vă așteptați

    }
}
