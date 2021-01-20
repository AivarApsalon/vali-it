package ee.bcs.valiit.tasks;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController


public class EmployeeController {

    private List<Employee> listOfEmployees = new ArrayList<>();

    @GetMapping("employee/{eesnimi}/{perenimi}/{vanus}/{kood}")
    public Employee employee(@PathVariable("eesnimi") String eesnimi, @PathVariable("perenimi") String perenimi,
                             @PathVariable("vanus") String vanus, @PathVariable("kood") String kood) {
        Employee employee1 = new Employee();
        employee1.setEesnimi("Aivar");
        employee1.setPerenimi("Apsalon");
        employee1.setVanus(40);
        employee1.setKood(111);
        Employee employee2 = new Employee();
        employee2.setEesnimi("Paul");
        employee2.setPerenimi("Kuusk");
        employee2.setVanus(80);
        employee2.setKood(222);

        return employee1;

    }

    @PostMapping("employee/{eesnimi}/{perenimi}/{vanus}/{kood}")
    public Employee employee(@RequestBody Employee employee) {
        System.out.println(employee.getEesnimi());
        return employee;
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee) {
        listOfEmployees.add(employee);
    }

    @GetMapping("employee")
    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    @GetMapping("employee/{id}")
    public Employee idEmployee(@PathVariable("id") int id) {
        return listOfEmployees.get(id);
    }

    @PutMapping("employee/{id}")
    public void replaceEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        listOfEmployees.set(id, employee);

    }

    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        listOfEmployees.remove(id);
    }

}
