package app.core.genericsex;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

public class GenExamples {
  public static void main(String[] args) {
    final Collection< @NotEmpty String > strings = new ArrayList<>();
    strings.add("");
  }
}
