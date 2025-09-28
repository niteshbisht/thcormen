package app.core;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapThreads {

  Map<String, Employee> employeeMap = new HashMap<>();

  public static void main(String[] args) {
    MapThreads map = new MapThreads();
    Employee emp = new Employee("101", 12, 20);
    map.employeeMap.put("101", emp);
    Employee emp2 = new Employee("102", 13, 29);
    map.employeeMap.put("102", emp2);
    Runnable r1 =
        () -> {
          try {
            map.processExecution("101");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        };
    Runnable r2 =
        () -> {
          try {
            map.processExecution("102");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        };
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
  }

  void processExecution(String empId) throws InterruptedException {
    Employee employee = employeeMap.get(empId);
    synchronized (employee) {
      while (employee.salary < 5000) {
        log.info("Print threadName => {} & Salary => {}", empId, employee.salary);
        employee.salary++;
        Thread.sleep(20);
      }
    }
  }
}

@Data
@AllArgsConstructor
class Employee {
  String id;
  int age;
  int salary;
}
