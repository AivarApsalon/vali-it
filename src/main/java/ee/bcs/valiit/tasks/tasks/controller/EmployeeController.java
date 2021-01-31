package ee.bcs.valiit.tasks.tasks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

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
        String sql = "INSERT INTO employee (eesnimi , perenimi, vanus, kood) VALUES(:eesnimiParameter, :perenimiParameter,:vanusParameter, :koodParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("eesnimiParameter", employee.getEesnimi());
        paramMap.put("perenimiParameter", employee.getPerenimi());
        paramMap.put("vanusParameter", employee.getVanus());
        paramMap.put("koodParameter", employee.getKood());
        jdbcTemplate.update(sql, paramMap);

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
