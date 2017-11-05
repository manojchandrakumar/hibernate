package org.manoj.javaminds.dao;

import org.manoj.javaminds.entity.ContractEmployee;
import org.manoj.javaminds.entity.Employee;
import org.manoj.javaminds.entity.RegularEmployee;

public interface EmployeeDAO {

	public void addEmployee(Employee e);

	public void addRegularEmployee(RegularEmployee regEmp);

	public void addCtrctEmployee(ContractEmployee ctrctEmp);
}
