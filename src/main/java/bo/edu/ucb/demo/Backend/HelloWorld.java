package bo.edu.ucb.demo.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * http://localhost:8080/mi_ruta/
 *
 * http://localhost:8080/mi_ruta/dos
 * HOLA MUNDO
 */

@RestController
@RequestMapping("/mi_ruta")
public class HelloWorld {

    private Student student;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return ("HOLA UNO");
    }

    @RequestMapping(value = "/dos", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloTwo() {
        return "Hola dos";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String findStudent() {
        return student.findById(20).toString();
    }
}
