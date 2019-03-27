package hjer;

import hjer.domain.Nota;
import hjer.domain.Student;
import hjer.domain.Tema;
import hjer.repository.NotaXMLRepository;
import hjer.repository.StudentXMLRepository;
import hjer.repository.TemaXMLRepository;
import hjer.service.Service;
import hjer.validation.NotaValidator;
import hjer.validation.StudentValidator;
import hjer.validation.TemaValidator;
import hjer.validation.Validator;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

public class ServiceTest
{
    @Test
    public void addStudentTest()
    {
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Student student : service.findAllStudents())
        {
            count += 1;
        }
        service.saveStudent("20", "Calin", 932);
        for (Student student : service.findAllStudents())
        {
            countafter += 1;
        }
        assert(count + 1 != countafter);
    }

    @Test
    public void addAssignment()
    {
        int count = 0;
        int countafter = 0;

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        for (Tema tema : service.findAllTeme())
        {
            count += 1;
        }
        service.saveTema("20", "Calin", 932, 0);
        for (Tema tema : service.findAllTeme())
        {
            countafter += 1;
        }
        assert(count + 1 != countafter);
    }
}
