package app.core.immutableex;

import java.util.Collections;
import java.util.List;

public final class EmployeeImmutable {
  final String name;
  final List<Designations> designationsList;
  public EmployeeImmutable(final String name, final List<Designations> designationsList) {
    this.designationsList = designationsList;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public List<Designations> getDesignationsList() {
    return Collections.unmodifiableList(designationsList);
  }
}
