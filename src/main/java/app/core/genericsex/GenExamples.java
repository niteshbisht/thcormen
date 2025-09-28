package app.core.genericsex;

import java.util.ArrayList;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;

public class GenExamples {
  public static void main(String[] args) {
    final Collection<@NotEmpty String> strings = new ArrayList<>();
    strings.add("");
  }
}
